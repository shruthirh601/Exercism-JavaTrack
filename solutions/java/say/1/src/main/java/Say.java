import java.util.HashMap;

import java.util.Stack;



public class Say {



    private HashMap<Integer, String> words = new HashMap<Integer, String>();



    public Say() {

        intializeWords();

    }



    public String say(long number) {



        if (number < 0 || number > 999_999_999_999L)

            throw new IllegalArgumentException("Only positive numbers and < 1 trillion.");



        if (number == 0)

            return "zero";



        var word = "";

        var thousands = splitIntoThousands(number);



        while (!thousands.isEmpty()) {

            var thousandPower = thousands.size() - 1;

            var thousand = thousands.pop();

            if (thousand == 0)

                continue;

            word += say1to999(thousand);

            if (thousandPower == 1)

                word += " thousand ";

            else if (thousandPower == 2)

                word += " million ";

            else if (thousandPower == 3)

                word += " billion ";

        }



        return word.stripTrailing();

    }



    private Stack<Integer> splitIntoThousands(long number) {

        var thousands = new Stack<Integer>();



        while (number > 0) {

            thousands.add((int) (number % 1000));

            number /= 1000;

        }



        return thousands;

    }



    private String say1to99(int number) {



        if (number == 0)

            return "";



        if (number < 20)

            return words.get(number);



        int digit = number % 10;

        var word = words.get(number - digit);

        word += (digit != 0) ? "-" + words.get(digit) : "";



        return word;

    }



    private String say1to999(int number) {



        if (number < 100)

            return say1to99(number);



        var tens = number % 100;

        var hundreds = (int) number / 100;

        var word = "";



        word += words.get(hundreds) + " hundred";

        if (tens > 0)

            word += " " + say1to99(tens);



        return word;

    }



    private void intializeWords() {

        words.put(1, "one");

        words.put(2, "two");

        words.put(3, "three");

        words.put(4, "four");

        words.put(5, "five");

        words.put(6, "six");

        words.put(7, "seven");

        words.put(8, "eight");

        words.put(9, "nine");

        words.put(10, "ten");

        words.put(11, "eleven");

        words.put(12, "twelve");

        words.put(13, "thirteen");

        words.put(14, "fourteen");

        words.put(15, "fifteen");

        words.put(16, "sixteen");

        words.put(17, "seventeen");

        words.put(18, "eighteen");

        words.put(19, "nineteen");

        words.put(20, "twenty");

        words.put(30, "thirty");

        words.put(40, "forty");

        words.put(50, "fifty");

        words.put(60, "sixty");

        words.put(70, "seventy");

        words.put(80, "eighty");

        words.put(90, "ninety");

    }



}