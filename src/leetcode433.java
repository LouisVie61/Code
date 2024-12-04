import java.util.*;

public class leetcode433 {
    public static int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.length() != endGene.length()) {
            return -1;
        }

        if (startGene.equals(endGene)) {
            return 0;
        }

        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if (!geneBank.contains(endGene)) {
            return -1;
        }

        char[] geneArrays = {'A', 'C', 'G', 'T'};

        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(startGene, 0));
        visited.add(startGene);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentGene = current.gene;
            int mutations = current.mutation;

            if (currentGene.equals(endGene)) {
                return mutations;
            }

            for (int i = 0; i < currentGene.length(); i++) {
                char[] genes = currentGene.toCharArray();
                char original = genes[i];

                for (char gene : geneArrays) {
                    if (gene == original) {continue;}
                    genes[i] = gene;
                    String newGene = new String(genes);

                    if (geneBank.contains(newGene) && !visited.contains(newGene)) {
                        queue.add(new Pair(newGene, mutations + 1));
                        visited.add(newGene);
                    }
                }
                genes[i] = original;
            }
        }
        return -1;
    }

    public static class Pair {
        String gene;
        int mutation;

        public Pair(String gene, int mutation) {
            this.gene = gene;
            this.mutation = mutation;
        }
    }


    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(startGene, endGene, bank));

    }
}
