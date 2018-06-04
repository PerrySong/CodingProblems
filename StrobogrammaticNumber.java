import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    /**
         A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

         Write a function to determine if a number is strobogrammatic. The number is represented as a string.

         Example 1:

         Input:  "69"
         Output: true
         Example 2:

         Input:  "88"
         Output: true
         Example 3:

         Input:  "962"
         Output: false
     */
    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        for(int i = 0; i <= num.length() / 2; i++) {

            if(!(map.containsKey(num.charAt(i)) &&  map.containsKey(num.charAt(num.length() - 1 - i))) || map.get(num.charAt(i)) != num.charAt(num.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("962"));
    }
}
