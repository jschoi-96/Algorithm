import java.util.*;
class Solution {
    public boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for(int num : arr) set.add(num);

        for(int num : arr) {
            int doubleExist = num * 2;
            if (set.contains(doubleExist)) {
                return true;
            }
        }
        return false;
    }
}