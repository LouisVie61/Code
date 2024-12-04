public class leetCode245 {
    // extends 243
    // handle word1 - equals to word2
    // same task
    public static int minimumDistance(String[] wordDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;

        boolean areWordsEqual = word1.equals(word2);

        int lastIndex1 = -1, lastIndex2 = -1;

        for (int i = 0; i < wordDict.length; i++) {
            if (areWordsEqual) {
                if (wordDict[i].equals(word1)) {
                    if (lastIndex1 != -1) {
                        res = Math.min(res, Math.abs(i - lastIndex1));
                    }
                    lastIndex1 = i;
                }
            } else {
                if (wordDict[i].equals(word1)) {
                    lastIndex1 = i;
                } else if (wordDict[i].equals(word2)) {
                    lastIndex2 = i;
                }

                if (lastIndex1 != -1 && lastIndex2 != -1) {
                    res = Math.min(res, Math.abs(lastIndex1 - lastIndex2));
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        String[] wordDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes", word2 = "makes";

        System.out.println(minimumDistance(wordDict, word1, word2));
    }
}