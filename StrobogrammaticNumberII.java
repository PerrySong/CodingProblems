import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StrobogrammaticNumberII {
    /**
     *
         A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

         Find all strobogrammatic numbers that are of length = n.

         Example:

         Input:  n = 2
         Output: ["11","69","88","96"]
     */

    public List<String> findStrobogrammatic(int n) {
        if (n <= 0) return new ArrayList<>();
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put('0', '0');
        charMap.put('1', '1');
        charMap.put('6', '9');
        charMap.put('9', '6');
        charMap.put('8', '8');

        List<String> list = new ArrayList<>();
        formStrobogrammatic(list, 0, charMap, new StringBuilder(), new StringBuilder(), n);
        return list;
    }

    public void formStrobogrammatic(List<String> list, int position, HashMap<Character, Character> charMap, StringBuilder startNumber, StringBuilder endNumber, int length) {
        if (position == length / 2) {
            if (length % 2 != 0) { //n is odd
                endNumber.reverse();
                list.add(startNumber.toString() + '0' + endNumber.toString());
                list.add(startNumber.toString() + '1' + endNumber.toString());
                list.add(startNumber.toString() + '8' + endNumber.toString());
                endNumber.reverse();
            } else {
                endNumber.reverse();
                list.add(startNumber.toString() + endNumber.toString());
                endNumber.reverse();
            }
            return;
        }

        for (Character key: charMap.keySet()) {

            if (position == 0 && key == '0') {
                continue;
            }

            startNumber.append(key);
            endNumber.append(charMap.get(key));

            System.out.println(startNumber);
            System.out.println(endNumber);


            formStrobogrammatic(list, position + 1, charMap, startNumber, endNumber, length);

            startNumber.deleteCharAt(position);
            endNumber.deleteCharAt(position);
        }
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII a = new StrobogrammaticNumberII();
        System.out.println(a.findStrobogrammatic(4));
        StringBuilder b = new StringBuilder();
        b.append('a');
        b.append('b');
        System.out.println(b);
        b.reverse();
        System.out.println(b);
    }
}
