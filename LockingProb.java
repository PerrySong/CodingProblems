public class LockingProb {
    /**
     *
     */

    public boolean[] locking() {
        boolean[] lock = new boolean[101];
        for (int i = 1; i < lock.length; i++) {
            int count = 0;
            for (int j = i; j >= 1; j--) {
                if (j % i == 0) count++;
            }
            if (count % 2 != 0) lock[i] = true;
        }
        return lock;
    }

}
