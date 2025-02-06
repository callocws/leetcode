package leetcode._380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class RandomizedSet {

    Set<Integer> set = new HashSet();
    List<Integer> list = new ArrayList();

    public RandomizedSet() {}

    public boolean insert(int val) {
        boolean success = set.add(val);
        if (success) {
            list.add(val);
        }
        return success;
    }

    public boolean remove(int val) {
        boolean success = set.remove(val);
        if (success) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == val) {
                    list.set(i, list.get(list.size() - 1));
                    list.removeLast();
                    break;
                }
            }
        }
        return success;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

class RandomizedSet1 {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList();
    Random random = new Random();

    public RandomizedSet1() {}

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer index = map.remove(val);
        boolean success = index != null;
        if (success) {
            Integer lastVal = list.get(list.size() - 1);
            if (val != lastVal) {
                list.set(index, lastVal);
                map.put(lastVal, index);
            }
            list.removeLast();
        }
        return success;
    }

    public int getRandom() {

        return list.get(random.nextInt(list.size()));
    }
}
