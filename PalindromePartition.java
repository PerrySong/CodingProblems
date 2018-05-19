import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        findPartitions(res, new ArrayList<String>(), s);
        return res;
    }

    private void findPartitions(List<List<String>> res, List<String> list, String s) {
        if(s.length() == 0){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if(isPalindrome(sub)) {
                list.add(sub);
                findPartitions(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != (s.charAt(s.length() - 1 - i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition a = new PalindromePartition();
        System.out.println(a.partition("aab"));
    }
}
