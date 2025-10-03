class BottleSong {

    String recite(int startBottles, int takeDown) {
        StringBuilder sb = new StringBuilder();
        for (int i = startBottles; i > (startBottles - takeDown); i--) {
            String bottleOrBottles = i == 1 ? "bottle" : "bottles";

            sb.append(uc(convert(i))).append(" green ").append(bottleOrBottles).append(" hanging on the wall,\n");
            sb.append(uc(convert(i))).append(" green ").append(bottleOrBottles).append(" hanging on the wall,\n");

            sb.append("And if one green bottle should accidentally fall,\n");

            if (i == 2) {
                sb.append("There'll be one green bottle hanging on the wall.\n");
            } else if (i == 1) {
                sb.append("There'll be no green bottles hanging on the wall.\n");
            } else {
                sb.append("There'll be ").append(convert(i-1)).append(" green bottles hanging on the wall.\n");
            }

            boolean isLast = i == startBottles - takeDown + 1;
            if (!isLast) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    private String uc(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    private String convert(int number) {
        return switch (number) {
            case 10 -> "ten";
            case 9 -> "nine";
            case 8 -> "eight";
            case 7 -> "seven";
            case 6 -> "six";
            case 5 -> "five";
            case 4 -> "four";
            case 3 -> "three";
            case 2 -> "two";
            case 1 -> "one";
            default -> throw new IllegalArgumentException("Too much?!");
        };
    }
}