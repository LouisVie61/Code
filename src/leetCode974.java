import java.util.HashMap;
import java.util.Map;

public class leetCode974 {
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int r = sum % k;
            if (r < 0) { r += k; }
            if (map.containsKey(r)) {
                cnt += map.get(r);
            }

            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 9};
        int k = 2;
        System.out.println(subarraysDivByK(nums, k));
    }
}
