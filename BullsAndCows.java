public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int a = 0;
        int b;
        int cSum = 0;
        int[] counts = new int[10];

        for(int i = 0; i < secret.length(); i++) {

            if(secret.charAt(i) == guess.charAt(i)) a++;
            counts[secret.charAt(i) - '0']++;
            counts[guess.charAt(i) - '0']--;
        }
        for(int count: counts) {
            System.out.println(count);
            if(count > 0)
                cSum += count;
        }
        b = secret.length() - cSum - a;
        System.out.println(cSum);

        String res = a + "A" + b + "B";
        return res;
    }

    public static void main(String[] args) {
        BullsAndCows a = new BullsAndCows();
        System.out.println(a.getHint("1122",
                "3456"));
    }
}
