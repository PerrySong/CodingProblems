import java.sql.ResultSet;
import java.util.*;

public class CountingWithRules {
    private static final int ONE_MIN = 60;
    private static final int FIVE_MINS_REQUEST_LIMIT = 10;

//    class Client {
//        int blockUntil;
//        int curStartTime;
////        int curFiveMinStart;
//        int oneMinRequests;
//        int fiveMinRequests;
//        public Client() {
//            blockUntil = 0;
//            curStartTime = 0;
////            curFiveMinStart = 0;
//
//            oneMinRequests = 0;
//            fiveMinRequests = 0;
//        }
//
//        public boolean allowRequest(int timeStamp) {
//            int startTime = (timeStamp / ONE_MIN) * ONE_MIN;
////            int fiveMinStartTime = ((timeStamp / ONE_MIN) / 5) * ONE_MIN;
//            if (timeStamp != curStartTime) {
//                curStartTime = timeStamp;
//            }
//
//            if (curStartTime > blockUntil) {
//                oneMinRequests++;
//                fiveMinRequests++;
//                return true;
//            }
//            return false;
//        }
//
//        public void block(int time) {
//            blockUntil = curStartTime + time;
//        }
//
//
//    }

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

        Map<String, Integer> nameToRequest = new HashMap<>();
        List<Request> requests = sortRequest(A);
        Map<String, List<Integer>> nameToLastFiveMinReq = new HashMap<>();
        Map<String, Integer> nameToBannedUntil = new HashMap<>();
        String[] res;

        int curMin = 0;
        for (Request req : requests) {

            String name = req.clientName;
            int nextMin = req.timeStamp / ONE_MIN;
            int reqInOneMin;

            List<Integer> lastFiveMinRequest = nameToLastFiveMinReq.getOrDefault(name, new LinkedList<>());

            if (nextMin > curMin) { // if finishing current min, we check previous 5 mins requests
                // If exceed five min's requests limit, ban two mins
                int fiveMinQeq = sum(lastFiveMinRequest);
                int total = totalRequest(nameToLastFiveMinReq);
                if (fiveMinQeq * 2 > total && total >= 10) {
                    nameToBannedUntil.put(name, curMin + 2);
                }
            }

            // update every list to the current timestamp
            for (int i = 0; i < 5 && curMin < nextMin; i++, curMin++) {
                pollPrevFiveMin(nameToLastFiveMinReq);
            }
            curMin = nextMin;

            reqInOneMin = lastFiveMinRequest.isEmpty() ? 0 : lastFiveMinRequest.get(lastFiveMinRequest.size() - 1);

            if (reqInOneMin >= Y) {
                // If exceed one min requests limit, ban next one min
                nameToBannedUntil.put(name, Math.max(nameToBannedUntil.getOrDefault(name, 0), nextMin + 1));
            }


            // Accept current request
            if (!nameToBannedUntil.containsKey(name) || nameToBannedUntil.get(name) <= nextMin) {
                if (lastFiveMinRequest.isEmpty()) lastFiveMinRequest.add(1);
                else 
                    lastFiveMinRequest.set(lastFiveMinRequest.size() - 1, reqInOneMin + 1);
                // Update the request num
                nameToRequest.put(name, nameToRequest.getOrDefault(name, 0) + 1);
                System.out.println(req);
            }
            nameToLastFiveMinReq.put(name, lastFiveMinRequest);
        }

        res = new String[nameToRequest.size()];
        int i = 0;
        for (String name : nameToRequest.keySet()) {
            res[i++] = name + " " + nameToRequest.get(name);
        }
        return res;
    }

    private int totalRequest(Map<String, List<Integer>> nameToLastFiveMinReq) {
        int res = 0;
        for (List<Integer> reqList : nameToLastFiveMinReq.values()) {
            for (int i : reqList) {
                res += i;
            }
        }
        return res;
    }

    private void pollPrevFiveMin(Map<String, List<Integer>> nameToLastFiveMinReq) {
        for (List<Integer> curList : nameToLastFiveMinReq.values()) {
            if (curList.size() == 5) {
                curList.remove(0);
                curList.add(0);
            } else {
                curList.add(0);
            }
        }
    }

    private int sum(List<Integer> list) {
        int res = 0;
        for (int i : list) {
            res += i;
        }
        return res;
    }

    private List<Request> sortRequest(String[] A) {
        List<Request> requests = new ArrayList<>();
        for (String req : A) {
            requests.add(new Request(req));
        }
        Collections.sort(requests);
        return requests;
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
