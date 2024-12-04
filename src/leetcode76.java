import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode76 {
    /**
     * sliding window:
     * th1: adobecodbanc and t = "abc"
     * substr with minimum size: banc
     *
     * th2 adcfabcb and t = "abc"
     * str with minimum size: "abc"
     *
     * adcfabcb, adcfab, adcfabc, abc
     * result: abc
     */

    /**
     * base idea: hash table
     * store: key: character + value: the number of character
     */

    public static String minimumWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> targetFre = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFre.put(c, targetFre.getOrDefault(c, 0) + 1);
        }

        Map<Character,  Integer> windowFre = new HashMap<>();
        int left = 0, min_size = Integer.MAX_VALUE, start = 0;
        int requried = targetFre.size();
        int formed = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowFre.put(c, windowFre.getOrDefault(c, 0) + 1);

            if (targetFre.containsKey(c) && windowFre.get(c).equals(targetFre.get(c))) {
                formed++;
            }

            while (left <= right && formed == requried) {
                c = s.charAt(left);

                if (right - left + 1 < min_size) {
                    min_size = right - left + 1;
                    start = left;
                }

                windowFre.put(c, windowFre.get(c) - 1);
                if (targetFre.containsKey(c) && windowFre.get(c) < targetFre.get(c)) {
                    formed--;
                }

                left++;
            }
        }

        return (min_size == Integer.MAX_VALUE) ? "" : s.substring(start, start + min_size);
    }
}
