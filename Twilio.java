import java.util.ArrayList;
import java.util.List;

public class Twilio {

    public void solution1() {

    }

    public List<String> missingWord(String s1, String s2) {
        List<String> res = new ArrayList<>();
        if (s1 == null || s2 == null) return res;
        String[] words1 = s1.split("\\s+"), words2 = s2.split("\\s+");
        int p1 = 0, p2 = 0;
        while (p1 < words1.length && p2 < words2.length) {
            if (words1[p1].equals(words2[p2])) {
                p1++;
                p2++;
            } else {
                res.add(words1[p1]);
                p1++;
            }
        }
        while (p1 < words1.length) {
            res.add(words1[p1++]);
        }

        return res;
    }

    public static void main(String[] args) {
        Twilio a = new Twilio();
        System.out.println(a.missingWord("I like cheese", "like"));
        System.out.println(a.missingWord("I am using HackerRank to improve programming", "am HackerRank to improve"));
        System.out.println();
    }
}
