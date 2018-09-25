import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    /**
         A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

         Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

         For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

         Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

         Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

         Note:

         Starting point is assumed to be valid, so it might not be included in the bank.
         If multiple mutations are needed, all mutations during in the sequence must be valid.
         You may assume start and end string is not the same.


         Example 1:

         start: "AACCGGTT"
         end:   "AACCGGTA"
         bank: ["AACCGGTA"]

         return: 1


         Example 2:

         start: "AACCGGTT"
         end:   "AAACGGTA"
         bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

         return: 2


         Example 3:

         start: "AAAAACCC"
         end:   "AACCCCCC"
         bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

         return: 3
     */

    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length()) return -1;

        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }

        int res = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int count = 0; count < size; count++) {
                String cur = queue.poll();
                if (cur.equals(end)) return res; //If match the end we return the res

                for (int i = 0; i < start.length(); i++) {
                    //For each unmatch point we add possible mutations in queue
                    String[] mutations = new String[] {"A", "T", "C", "G"};
                    for (String mut : mutations) { //For each possible mutation, if we did not visit, add to queue
                        String newGene = cur.substring(0, i) + mut + cur.substring(i + 1);
                        if (!newGene.equals(cur) && bankSet.contains(newGene) && visited.add(newGene)) {
                            queue.offer(newGene);
                        }
                    }
                }
            }
            res++; //Increment level
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation a = new MinimumGeneticMutation();
        a.minMutation("AACCGGTT",
                "AAACGGTA",
                        new String[] {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"});
    }
}
