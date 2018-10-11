import java.util.*;

public class VisaOA {

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

    public List<String> workSchedule(String pattern, int totalHours, int dayHours) {
        List<String> res = new ArrayList<>();
        if (pattern == null || pattern.length() != 7) return res;

        for (int i = 0; i < 7; i++) {
            int num = pattern.charAt(i) - '0';
            if (num >= 9 || num < 0) continue;
            totalHours -= num;
        }
        if (totalHours < 0) return res;
        dfs(res, pattern, 0, totalHours, dayHours);
        return res;
    }

    private void dfs(List<String> res, String pattern, int index, int target, int dayHours) {
        if (index == 7) {
            if (target == 0) {
                res.add(pattern);
            }
            return;
        }
        if (target < 0) return;
        if (pattern.charAt(index) != '?') { // if current char is not '?'
            dfs(res, pattern, index + 1, target, dayHours);
            return;
        }
        for (int i = 0; i <= dayHours; i++) { // if current char is '?', we try every possible pattern to get target
            String newPattern = pattern.substring(0, index) + i + pattern.substring(index + 1);
            dfs(res, newPattern,index + 1, target - i, dayHours);
        }
    }

    public static void main(String[] args) {
        VisaOA a = new VisaOA();
        String[] sArr = new String[] {"01 Mar 2017", "02 apr 2012"};
        a.sortingDates(sArr);
        System.out.println(sArr[0] + " " + sArr[1]);

        System.out.println(a.workSchedule("???8???", 56, 8));
        System.out.println(a.workSchedule("08??840", 24, 8));
    }
}
