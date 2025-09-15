import java.util.*;
import java.util.stream.Collectors;

class HighScores {

    private List<Integer> highScores;
    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    List<Integer> scores() {
        return highScores;
    }

    Integer latest() {
        Integer latest = highScores.get(highScores.size() -1);
        return latest;
    }

    Integer personalBest() {
       Integer max = highScores.stream()
                        .sorted(Comparator.reverseOrder())
                        .findFirst()
                        .orElse(null);
        return max;
    }

    List<Integer> personalTopThree() {
       List<Integer> top3Elements = highScores.stream()
                                            .sorted(Comparator.reverseOrder())
                                            .limit(3)
                                            .collect(Collectors.toList());
        return top3Elements;
    }

}
