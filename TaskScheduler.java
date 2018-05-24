import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c: tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int i = 24;
        while(count[i] == count[25]) i--;
        System.out.println(count[25]);
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);

    }

    public static void main(String[] args) {
        char[] b = {'A','A','A','B','B','B'};
        TaskScheduler a = new TaskScheduler();
        System.out.println(a.leastInterval(b, 2));
    }
}
