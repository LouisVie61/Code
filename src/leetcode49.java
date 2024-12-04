import java.util.*;

public class leetcode49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] words) {
            List<List<String>> resutls = new ArrayList<>();
            Map<Integer, List<String>> hashMap = new HashMap<>();

            for (String word : words) {
                boolean added = false;
                for (int key : hashMap.keySet()) {
                    if (checkAnagram(hashMap.get(key).get(0), word)) {
                        hashMap.get(key).add(word);
                        added = true;
                        break;
                    }
                }

                if (!added) {
                    List<String> newGroup = new ArrayList<>();
                    newGroup.add(word);
                    hashMap.put(hashMap.size(), newGroup);
                }
            }

            resutls.addAll(hashMap.values());
            return resutls;
        }

        private boolean checkAnagram(String str1, String str2) {
            int len1 = str1.length();
            int len2 = str2.length();

            if(len1 != len2) {
                return false;
            }

            int[] frequency = new int[26];
            for (int i = 0; i < len1; i++) {
                frequency[str1.charAt(i) - 'a']++;
                frequency[str2.charAt(i) - 'a']--;
            }

            for (int cnt : frequency) {
                if (cnt != 0) {
                    return false;
                }
            }

            return true;
        }
    }



    /**
     * List result contains:
     * eat, tea, ate
     * bat
     * tan, nat
     *
     * 1 <= words.length <= 10^4
     * 0 <= words[i].length <= 100;
     * all lower cases.
     * @param args la mot bien
     */

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "ate", "bat", "tan", "nat"};

        leetcode49 problem = new leetcode49();
        Solution s = problem.new Solution();
        List<List<String>> answer = s.groupAnagrams(words);

        System.out.print(answer);
    }
}
