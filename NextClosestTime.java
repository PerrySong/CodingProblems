import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextClosestTime {
    /**
         Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
         There is no limit on how many times a digit can be reused.

         You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid.
         "1:34", "12:9" are all invalid.

         Example 1:

         Input: "19:34"
         Output: "19:39"
         Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
         It is not 19:33, because this occurs 23 hours and 59 minutes later.
         Example 2:

         Input: "23:59"
         Output: "22:22"
         Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the
         returned time is next day's time since it is smaller than the input time numerically.
     */
    public String nextClosestTime(String time) {
        if (time == null || time.length() == 0) return null;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        String[] hourAndMin = time.split(":");
        int hour = Integer.valueOf(hourAndMin[0]);
        int min = Integer.valueOf(hourAndMin[1]);
        boolean contains0 = false;
        boolean hFirst0 = hourAndMin[0].charAt(0) == '0';
        boolean mFirst0 = hourAndMin[1].charAt(0) == '0';
        for (char c : time.toCharArray()) {
            if (c != ':') {
                if (c == '0') contains0 = true;
                list.add(c - '0');
            }
        }
        Collections.sort(list);



        for (int i : list) {
            for (int j : list) {
                if (!contains0 && j == 0) continue;
                int newMin = 10 * i + j;
                if (newMin >= 60) break;
                if (newMin > min && newMin < 60) {
                    if (mFirst0 && newMin < 10)
                        return hourAndMin[0] + ":" + "0" + newMin;
                    else
                        return hourAndMin[0] + ":" + newMin;
                }
            }
        }

        for (int i : list) {
            for (int j : list) {
                if (!contains0 && j == 0) continue;
                int newHour = 10 * i + j;
                if (newHour >= 24) break;
                if (newHour > hour && newHour < 24) {
                    if (hFirst0 && newHour < 10)
                        return "0" + newHour + ":" + list.get(1).toString() + list.get(1).toString();
                    else
                        return newHour + ":" + list.get(1).toString() + list.get(1).toString();
                }
            }
        }

        return list.get(1).toString() + list.get(1).toString() + ":" + list.get(1).toString() + list.get(1).toString();

    }

    public static void main(String[] args) {
        NextClosestTime a = new NextClosestTime();
        System.out.println(a.nextClosestTime("01:37"));
    }
}
