public class leetCode327 {
    // given int[] nums and two integers: lower and upper.
    // task: find the number of range sums that the sum in these range is suitable: lower <= sum && sum <= upper
    // S(i, j): i, j are indexes, i <= j. If (i == j) ? Only a num in nums[i] or nums[j]
    // i <= j: sum (from i in range of (i, j) in [lower, upper] => S(i, j) is a suitable range sum.
    // constraint: nums.length <= 2.10^5, nums[i] in [-2^31, 2^31], -10^5 <= lower <= upper <= 10^5;
}
