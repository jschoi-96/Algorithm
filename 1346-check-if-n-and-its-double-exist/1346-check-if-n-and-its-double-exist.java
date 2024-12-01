import java.util.*;
class Solution {
    public boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();

        int cnt = 0;
        for(int num : arr) {
            set.add(num);
            if (num == 0) cnt++;
        }

        if (cnt >= 2) return true;

        for(int num : arr) {
            int doubleExist = num * 2;
            if (set.contains(doubleExist)) {
                if (num != 0) return true;
            }
        }
        return false;
    }
}