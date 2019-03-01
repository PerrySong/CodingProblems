import java.util.*;

public class CountingWithRules {
    private static final int ONE_MIN = 60;
    private static final int FIVE_MIN_WINDOW_BAN_THREADHOLD = 10;

        class Request implements Comparable<Request> {
            String clientName;
            int timeStamp;

            public Request(String req) {
                String[] tokens = req.split("\\s+");
                clientName = tokens[0];
                timeStamp = Integer.parseInt(tokens[1]);
            }

            public int compareTo(Request req2) {
                return timeStamp - req2.timeStamp;
            }

            public String toString() {
                return clientName + " " + timeStamp;
            }
        }

        public String[] solution(String[] A, int Y) {

            if (A == null || A.length == 0) return null;
            String[] res;
            Map<String, Integer> nameToRequests = new HashMap<>(); // [name : number of successful requests]
            Map<String, List<Integer>> nameToLastFiveMinReq = new HashMap<>(); // Records the number of requests for every min in last five min
            Map<String, Integer> nameToBlockedUntil = new HashMap<>();
            Set<String> clientNames = new LinkedHashSet<>();
            List<Request> requests = parseToSortedRequests(A, clientNames);

            int curMin = 0;
            for (Request req : requests) {

                String name = req.clientName;
                int nextMin = req.timeStamp / ONE_MIN;
                int lastMinReq;
                List<Integer> lastFiveMinRequests = nameToLastFiveMinReq.getOrDefault(name, new LinkedList<>());

                // Go into next min
                if (nextMin > curMin) {
                    // Update blacklist
                    updateBlackList(name, curMin, nameToLastFiveMinReq, nameToBlockedUntil);
                }

                // update every list to the current timestamp
                for (int i = 0; i < 5 && curMin < nextMin; i++, curMin++) {
                    nextMin(nameToLastFiveMinReq);
                }
                // update curMin
                curMin = nextMin;

                lastMinReq = lastFiveMinRequests.isEmpty() ? 0 : lastFiveMinRequests.get(lastFiveMinRequests.size() - 1);

                // Update block list
                if (lastMinReq >= Y) {
                    // If exceed one min requests limit, ban next one min
                    nameToBlockedUntil.put(name, Math.max(nameToBlockedUntil.getOrDefault(name, 0), nextMin + 1));
                }

                // Process current request
                if (!nameToBlockedUntil.containsKey(name) || nameToBlockedUntil.get(name) <= nextMin) {
                    allowOneRequest(name, nameToLastFiveMinReq, nameToRequests, lastFiveMinRequests);
                }
            }

            // Form the result
            res = new String[nameToRequests.size()];
            int i = 0;
            for (String name : clientNames) {
                res[i++] = name + " " + nameToRequests.get(name);
            }

            return res;
        }

    /**
     * Allow client "name" make one request, update relative data
     * @param name
     * @param nameToLastFiveMinReq
     * @param nameToRequests
     * @param lastFiveMinRequests
     */
        private void allowOneRequest(String name, Map<String, List<Integer>> nameToLastFiveMinReq, Map<String, Integer> nameToRequests, List<Integer> lastFiveMinRequests) {

            if (lastFiveMinRequests.isEmpty()) {
                lastFiveMinRequests.add(1);
                nameToLastFiveMinReq.put(name, lastFiveMinRequests);
            } else {
                lastFiveMinRequests.set(lastFiveMinRequests.size() - 1, lastFiveMinRequests.get(lastFiveMinRequests.size() - 1) + 1);
            }
            // Update the request num
            nameToRequests.put(name, nameToRequests.getOrDefault(name, 0) + 1);
        }

    /**
     * Check if current client should be put into blacklist, and update the blacklist
     * @param name
     * @param curMin
     * @param nameToLastFiveMinReq
     * @param nameToBlockedUntil
     */
        private void updateBlackList(String name, int curMin, Map<String, List<Integer>> nameToLastFiveMinReq, Map<String, Integer> nameToBlockedUntil) {
            List<Integer> lastFiveMinRequests = nameToLastFiveMinReq.get(name);
            int fiveMinReq = sum(lastFiveMinRequests);
            int total = totalRequest(nameToLastFiveMinReq);
            if (fiveMinReq * 2 > total && total >= FIVE_MIN_WINDOW_BAN_THREADHOLD) {
                nameToBlockedUntil.put(name, curMin + 2);
            }
        }

    /**
     * Return the total request in the nameToLastFiveMinReq
     * @param nameToLastFiveMinReq
     * @return
     */
    private int totalRequest(Map<String, List<Integer>> nameToLastFiveMinReq) {
            int res = 0;
            for (List<Integer> reqList : nameToLastFiveMinReq.values()) {
                for (int i : reqList) {
                    res += i;
                }
            }
            return res;
        }

    /**
     * Poll the first elem from the LastFiveMinReq, and add 0 to the end
     * @param nameToLastFiveMinReq
     */
    private void nextMin(Map<String, List<Integer>> nameToLastFiveMinReq) {
            for (List<Integer> curList : nameToLastFiveMinReq.values()) {
                if (curList.size() == 5) {
                    curList.remove(0);
                    curList.add(0);
                } else {
                    curList.add(0);
                }
            }
        }

    /**
     * Parse
     * @param A
     * @param clientNames
     * @return
     */
        private List<Request> parseToSortedRequests(String[] A, Set<String> clientNames) {
            List<Request> requests = new ArrayList<>();
            for (String req : A) {
                clientNames.add(req.split("\\s")[0]);
                requests.add(new Request(req));
            }
            Collections.sort(requests);
            return requests;
        }

    /**
     *
     * @param list
     * @return
     */
    private int sum(List<Integer> list) {
            int res = 0;
            for (int i : list) {
                res += i;
            }
            return res;
        }


    public static void main(String[] args) {
        CountingWithRules a = new CountingWithRules();
        String[] input = new String[] {
                "a 0",
                "a 15",
                "a 59",
                "a 59",
                "a 60",
                "a 63",
                "a 80",
                "a 120",
                "a 180",
                "a 240",
                "b 0",
                "b 60",
                "b 120",
                "b 180",
                "b 240",
                "b 320",
        };

        String[] res = a.solution(input, 3);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
