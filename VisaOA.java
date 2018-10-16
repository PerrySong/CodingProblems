import java.util.*;

public class VisaOA {


    public static List<String> sortDates(List<String> dates) {
        // Write your code here
        if (dates == null || dates.size() <= 1) return dates;
        Map<String, Integer> monthToInt = new HashMap<>();
        String[] months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i <= 11; i++) {
            monthToInt.put(months[i], i);
        }
        // We do not want to change the input array, so copy dates to a new array
        List<String> res = new ArrayList<>();
        for (String date : dates) {
            res.add(date);
        }
        // Sort the array.
        Collections.sort(res, (date1, date2) -> {
            //Compare the year first
            String[] d1Arr = date1.split("\\s+"); // d1Arr = [day, month(word), year]
            String[] d2Arr = date2.split("\\s+");
            int year1 = Integer.parseInt(d1Arr[2]);
            int year2 = Integer.parseInt(d2Arr[2]);
            if (year1 != year2) return year1 - year2;
            // If two years are equivalent we compare the months
            int month1 = monthToInt.get(d1Arr[1]);
            int month2 = monthToInt.get(d2Arr[1]);
            if (month1 != month2) return month1 - month2;
            // If months are also the same we compare the days
            return Integer.parseInt(d1Arr[0]) - Integer.parseInt(d2Arr[0]);
        });
        return res;
    }

    public void sortingDates(String[] dates) {
        if (dates == null) return;
        Map<String, Integer> monthToInt = new HashMap<>();
        String[] months = new String[] {"jan", "feb", "mar","apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        for (int i = 0; i < months.length; i++) {
            monthToInt.put(months[i], i + 1);
        }
        Arrays.sort(dates, (s1, s2) -> {
            String[] date1 = s1.split("\\s+");
            String[] date2 = s2.split("\\s+");
            int year1 = Integer.valueOf(date1[2]);
            int year2 = Integer.valueOf(date2[2]);
            if (year1 != year2)
                return year1 - year2;
            int month1 = monthToInt.get(date1[1].toLowerCase());
            int month2 = monthToInt.get(date2[1].toLowerCase());
            if (month1 != month2)
                return month1 - month2;
            return Integer.valueOf(date1[0]) - Integer.valueOf(date2[0]);

        });

    }

//    public List<String> workSchedule(String pattern, int totalHours, int dayHours) {
//        List<String> res = new ArrayList<>();
//        if (pattern == null || pattern.length() != 7) return res;
//
//        for (int i = 0; i < 7; i++) {
//            int num = pattern.charAt(i) - '0';
//            if (num >= 9 || num < 0) continue;
//            totalHours -= num;
//        }
//        if (totalHours < 0) return res;
//        dfs(res, pattern, 0, totalHours, dayHours);
//        return res;
//    }
//
//    private void dfs(List<String> res, String pattern, int index, int target, int dayHours) {
//        if (index == 7) {
//            if (target == 0) {
//                res.add(pattern);
//            }
//            return;
//        }
//        if (target < 0) return;
//        if (pattern.charAt(index) != '?') { // if current char is not '?'
//            dfs(res, pattern, index + 1, target, dayHours);
//            return;
//        }
//        for (int i = 0; i <= dayHours; i++) { // if current char is '?', we try every possible pattern to get target
//            String newPattern = pattern.substring(0, index) + i + pattern.substring(index + 1);
//            dfs(res, newPattern,index + 1, target - i, dayHours);
//        }
//    }


    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (pattern == null || pattern.length() != 7) return res;
        dfs(res, pattern, 0, workHours, dayHours);
        return res;
    }

    private static void dfs(List<String> res, String pattern, int start, int workHours, int dayHours) {
        if (start == pattern.length()) {
            if (workHours == 0)
                res.add(pattern);
            return;
        }
        char curHours = pattern.charAt(start);
        if (curHours != '?') {
            dfs(res, pattern, start + 1, workHours - (curHours - '0'), dayHours);
            return;
        }
        for (int i = 0; i <= dayHours; i++) {
            int remainHours = workHours - i;
            if (remainHours < 0) break; // Prunning
            String newPattern = pattern.substring(0, start) + i + pattern.substring(start + 1);
            dfs(res, newPattern, start + 1, remainHours, dayHours);
        }
    }

    public static void main(String[] args) {
        VisaOA a = new VisaOA();
        String[] sArr = new String[] {"01 Mar 2017", "02 apr 2012"};
        a.sortingDates(sArr);
        System.out.println(sArr[0] + " " + sArr[1]);

        System.out.println(a.findSchedules(56, 8, "???8???"));
        System.out.println(a.findSchedules( 24, 8, "08??840"));
        System.out.println(a.findSchedules( 3, 1, "???????"));
    }
}
