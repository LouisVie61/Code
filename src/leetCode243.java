public class leetCode243 {
    // wordDict : an array of word
    // contains two words: word1 and word2
    // find the minimum distance between word1 and word2

    public static int minimumDistance(String[] wordDict, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordDict.length; i++) {
            if (wordDict[i].equals(word1)) {
                index1 = i;
            } else if (wordDict[i].equals(word2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] wordDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes", word2 = "coding";
        System.out.println(minimumDistance(wordDict, word1, word2));
    }
}