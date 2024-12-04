import java.util.List;

public class leetcode139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String w : wordDict) {
                int start = i + 1 - w.length();
                if (start >= 0 && dp[start] && s.substring(start, i + 1).equals(w)) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of(new String[]{"leet", "code"});

        if (wordBreak(s, wordDict)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
