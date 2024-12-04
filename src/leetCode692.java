import java.util.*;

public class leetCode692 {
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new freqWord());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        while (!pq.isEmpty() & k-- >0) {
            ans.add(pq.poll().word);
        }

        return ans;
    }

    public static class Pair {
        String word;
        int count;

        public Pair (String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static class freqWord implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.count > o2.count) {
                return -1;
            } else if (o1.count < o2.count) {
                return 1;
            } else {
                return o1.word.compareTo(o2.word);
            }
        }
    }

    // Output: ["i","love"]

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;

        List<String> ans = topKFrequent(words, 2);
        for (String word : ans) {
            System.out.print(word);
        }
    }
}
