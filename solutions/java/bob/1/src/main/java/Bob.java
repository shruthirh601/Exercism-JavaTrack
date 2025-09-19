public class Bob {
    public String hey(String phrase) {
        String trimmedPhrase = phrase.trim();

        if (trimmedPhrase.isEmpty()) {
            return "Fine. Be that way!";
        }

        boolean isQuestion = trimmedPhrase.endsWith("?");
        boolean isYelling = trimmedPhrase.toUpperCase().equals(trimmedPhrase) && trimmedPhrase.matches(".*[A-Z].*");

        if (isQuestion && isYelling) {
            return "Calm down, I know what I'm doing!";
        } else if (isQuestion) {
            return "Sure.";
        } else if (isYelling) {
            return "Whoa, chill out!";
        } else {
            return "Whatever.";
        }
    }
}