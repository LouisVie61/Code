import java.util.*;

public class leetCode373 {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            int indexInNums2 = current[2];
            res.add(Arrays.asList(current[0], current[1]));
            if (current[2] == nums2.length - 1) continue;
            pq.offer(new int[]{current[0], nums2[indexInNums2 + 1], indexInNums2 + 1});
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};

        int k = 3;
        List<List<Integer>> ans = kSmallestPairs(nums1, nums2, k);
        System.out.println(ans);
    }
}