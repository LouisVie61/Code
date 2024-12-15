import java.util.*;

public class leetCode327 {
    // given int[] nums and two integers: lower and upper.
    // task: find the number of range sums that the sum in these range is suitable: lower <= sum && sum <= upper
    // S(i, j): i, j are indexes, i <= j. If (i == j) ? Only a num in nums[i] or nums[j]
    // i <= j: sum (from i in range of (i, j) in [lower, upper] => S(i, j) is a suitable range sum.
    // constraint: nums.length <= 2.10^5, nums[i] in [-2^31, 2^31], -10^5 <= lower <= upper <= 10^5;

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (lower == upper && lower > nums.length && upper > nums.length) {
            return 0;
        }

        TreeMap<Long, Integer> prefixMap = new TreeMap<>();
        prefixMap.put(0L, 1);

        long prefixSum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            Map<Long, Integer> subMap = prefixMap.subMap(prefixSum - upper, true,
                    prefixSum - lower, true);

            for (int value : subMap.values()) {
                cnt += value;
            }

            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        int lower = 0;
        int upper = 0;

        System.out.println(countRangeSum(nums, lower, upper));
    }
}
