import java.util.*;

public class leetCode229 {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int k = nums.length / 3;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > k) {
                res.add(entry.getKey());
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4};
        List<Integer> result = majorityElement(nums);
        System.out.println(result);
    }
}
