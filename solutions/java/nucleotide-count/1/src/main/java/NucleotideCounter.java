import java.util.*;

class NucleotideCounter {

    private final Map<Character, Integer> nucleotideCount;

    NucleotideCounter(String sequence) {
        nucleotideCount = new HashMap<>();
        // Initialize all valid nucleotides to 0
        nucleotideCount.put('A', 0);
        nucleotideCount.put('C', 0);
        nucleotideCount.put('G', 0);
        nucleotideCount.put('T', 0);

        for (char ch : sequence.toCharArray()) {
            if (!nucleotideCount.containsKey(ch)) {
                throw new IllegalArgumentException();
            }
            nucleotideCount.put(ch, nucleotideCount.get(ch) + 1);
        }
    }

    Map<Character, Integer> nucleotideCounts() {
        return nucleotideCount;
    }
}