import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class RandomizedSet {
    HashMap<Integer, Integer> Rmap;
    int[] Rset;
    int Rsize;
    int Rnum;
    final int INITNUM = 100;

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(100);
        obj.insert(20);
        boolean param_2 = obj.remove(100);
        int param_3 = obj.getRandom();

    }

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        Rmap = new HashMap<Integer, Integer>();
        Rset = new int[INITNUM];
        Rsize = INITNUM;
        Rnum = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!Rmap.containsKey(val)) {
            Rset[Rnum++] = val;
            Rmap.put(val, Rnum - 1);
            if (Rnum > Rsize / 2) {//扩容
                int[] item = Arrays.copyOf(Rset, Rsize * 2);
                Rset = item;
                Rsize *= 2;
            }
            return true;
        } else {
            return false;
        }

    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (Rmap.containsKey(val)) {
            int i = Rmap.get(val);
            int item = Rset[i];
            Rset[i] = Rset[Rnum - 1];
            Rnum--;
            Rmap.replace(Rset[i], i);
            Rmap.remove(item);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random r = new Random();
        int k = r.nextInt(Rnum);
        return Rset[k];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */