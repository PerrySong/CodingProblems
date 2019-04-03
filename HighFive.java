import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
    /**
         Description
         There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.


         Example
         Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

         Return
     */
    class Record {
        public int id, score;
        public Record(int id, int score){
            this.id = id;
            this.score = score;
        }
    }

    public Map<Integer, Double> highFive(Record[] results) {
        if (results == null || results.length == 0) return null;
        Map<Integer, PriorityQueue<Integer>> idToScores = new HashMap<>();
        Map<Integer, Double> res = new HashMap<>();
        for (int i = 0; i < results.length; i++) {
            Record r = results[i];
            if (!idToScores.containsKey(r.id)) {
                idToScores.put(r.id, new PriorityQueue<>(5, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }));
            }
            idToScores.get(r.id).add(r.score);
        }
        for (int key : idToScores.keySet()) {
            PriorityQueue<Integer> pq = idToScores.get(key);
            double sum = 0;
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }
            res.put(key, sum / 5);
        }
        return res;
    }
}
