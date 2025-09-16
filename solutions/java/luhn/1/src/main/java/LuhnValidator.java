import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {
        final String cnd = candidate.replaceAll(" ", "");
        final int parity = cnd.length() % 2 == 0 ? 0 : 1;

        return  cnd.length() > 1
                &&
                cnd.matches("\\d+")
                &&
                IntStream
                        .range(0, cnd.length())
                        .map(i -> ((i+parity) % 2) == 0
                                ? ((cnd.charAt(i)-'0') < 5
                                    ? ((cnd.charAt(i)-'0') * 2)
                                    : ((cnd.charAt(i)-'0') * 2 - 9))
                                :  (cnd.charAt(i)-'0'))
                        .sum() % 10 == 0;
    }

}