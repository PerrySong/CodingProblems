public class WaterFlower {
    /**
     * You are a gardener and you take care of your plants. The plants are planted in a row and each of them needs a specific
     * amount of water. You are about to water them using a watering can. To avoid mistakes like applying too much water, or
     * not watering a plant at all, you have decided to:
     *
     * water the plants in the order in which they appear, from left to right;
     * water each plant if you have sufficient water for it, otherwise refill your watering can;
     * water each plant in one go, i.e. without taking a break to refill the watering can in the middle of watering a single plant.
     * This means that you may sometimes have to refill your watering can before or after watering a plant, even though it's not completely empty.
     * You start at the water container, which is positioned one step before the first plant. How many steps will you take, in order
     * to water all the plants in the row? You must take one step to move to the next or the previous plant (all plants are positioned
     * one step apart from each other).
     *
     * Given an array plants of n integers (for the amount of water needed by each plan) and the watering can capacity, return
     * the number of steps needed to water all the plants.
     *
     * Example 1:
     *
     * Input: plants = [2, 4, 5, 1, 2], capacity = 6
     * Output: 17
     * Explanation:
     * First you water plants[0] and plants[1] (2 steps).
     * Then you have to go back to refill (2 steps) and water plants[2] and plants[3] (4 steps).
     * Then again you have to refill (4 steps) and water plants[4] (5 steps).
     * So 2 + 2 + 4 + 4 + 5 = 17.
     * Constraints:
     *
     * n is an integer within the range [1..1,000];
     * each element of array plants is an integer within the range [1..1,000,000];
     * capacity is an integer within the range [1..1,000,000,000];
     * the watering can is large enough to fully water any single plant.
     */

    public static int waterFlower(int[] plants, int capacity) {
        if (plants == null || plants.length == 0) {
            return 0;
        }
        int curWater = capacity;
        int res = 0;
        for (int i = 0; i < plants.length; i++) {
            if (curWater < plants[i]) {
                // go back to origin refill and comeback to the same spot
                res += 2 * i;
                curWater = capacity;
            }
            curWater -= plants[i];
            res++;
        }
        return res;
    }



    public static int waterFlower2(int[] plants, int capacity1, int capacity2) {
        if (plants == null || plants.length == 0) return 0;
        int i = 0, j = plants.length - 1;
        if (plants.length == 1) {
            if (capacity1 >= plants[0] || capacity2 >= plants[0]) {
                return 1;
            }
            return 2;
        }
        int curWater1 = 0, curWater2 = 0;
        int refills = 0;
        while (i < j) {
            if (curWater1 < plants[i]) {
                // refills
                curWater1 = capacity1;
                refills++;
            }

            curWater1 -= plants[i];

            if (curWater2 < plants[j]) {
                curWater2 = capacity2;
                refills++;
            }
            curWater2 -= plants[j];
            i++;
            j--;
        }

        if (i == j && curWater1 + curWater2 < plants[i]) {
            refills++;
        }
        return refills;
    }

    public static int solution(int[] plants, int capacity1, int capacity2) {
        if (plants == null || plants.length == 0) return 0;

        int refill = 0;
        int cap1 = 0;
        int cap2 = 0;
        int i = 0;
        int j = plants.length - 1;

        while (i < j) {
            if (cap1 < plants[i]) {
                cap1 = capacity1;
                refill++;
            }
            cap1 -= plants[i];
            i++;

            if (cap2 < plants[j]) {
                cap2 = capacity2;
                refill++;
            }
            cap2 -= plants[j];
            j--;
        }
        if (i == j) {
            int sumBoth = cap1 + cap2;
            if (sumBoth >= plants[i]) {
                return refill;
            } else {
                refill += 2;
            }
        }
        return refill;
    }

    public static void main(String[] args) {
//        System.out.println(waterFlower2(new int[] {2, 4, 5, 1, 2}, 5, 7));
        System.out.println(solution(new int[] {2, 4, 5, 1, 2}, 5, 7));
    }

}
