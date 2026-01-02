import java.util.*;
import java.util.stream.Collectors;

class ParallelLetterFrequency {

    private final List<String> texts;
    ParallelLetterFrequency(String[] texts) {
        this.texts = Arrays.asList(texts);
            }

    Map<Character, Integer> countLetters() {
        return texts.parallelStream().flatMapToInt(String::chars).mapToObj(c -> Character.toLowerCase((char)c)).filter(Character::isLetter)
            .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(e -> 1)));
    }

}
