import java.util.stream.*;
class TwelveDays {
     private final String[] gifts = {
        "a Partridge in a Pear Tree.",
        "two Turtle Doves,",
        "three French Hens,",
         "four Calling Birds,",
         "five Gold Rings,",
         "six Geese-a-Laying,",
         "seven Swans-a-Swimming,",
         "eight Maids-a-Milking,",
         "nine Ladies Dancing,",
         "ten Lords-a-Leaping,",
         "eleven Pipers Piping,",
         "twelve Drummers Drumming,"
    };

    private final String[] dayNames = {
        "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh","twelfth"
    };

    public String verse(int verseNumber) {
        StringBuilder verseBuilder = new StringBuilder();
        verseBuilder.append("On the ").append(dayNames[verseNumber - 1])
                    .append(" day of Christmas my true love gave to me: ");

        for (int i = verseNumber - 1; i >= 0; i--) {
            if (i == 0 && verseNumber > 1) {
                verseBuilder.append("and ");
            }
            verseBuilder.append(gifts[i]);
            if (i > 0) {
                verseBuilder.append(" ");
            }
        }
        verseBuilder.append("\n");
        return verseBuilder.toString();
    }

    String verses(int startVerse, int endVerse) {
        String verses;
        verses = IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(i -> verse(i) + "\n")
                .collect(Collectors.joining(""));
        return verses.substring(0, verses.length() - 1);
    }
    
    String sing() {
        return verses(1,12);
    }
}
