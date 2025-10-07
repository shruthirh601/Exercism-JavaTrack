import java.util.*;

public class IntergalacticTransmission {

    public static List<Integer> getTransmitSequence(List<Integer> message) {
        if (message == null || message.isEmpty()) {
            return message;
        }
        String messageString = convertMessage(message);
        List <Integer> output = new ArrayList<>();
        for (int i = 0; i < messageString.length(); i += 7) {
            String part = messageString.substring(i, Math.min(i+7, messageString.length()));
            if (part.length() == 7) {
                output.add(Integer.parseInt(handlePart(part), 2));
            } else {
                while (part.length() < 7) {
                    part += "0";
                }
                output.add(Integer.parseInt(handlePart(part), 2));
            }
        }
        return output;
    }

    public static String convertMessage(List<Integer> message) {
        String messageString = "";
        for (int i : message) {
            messageString += String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            i++;
        }
        return messageString;
    }

    public static String handlePart(String part) {
        int count = countOnes(part);
        if (count % 2 == 0) {
            part += "0";
        } else {
            part += "1";
        }
        return part;
    }

    public static int countOnes(String part) {
        return part.length() - part.replaceAll("1","").length();
    }

    public static List<Integer> decodeSequence(List<Integer> sequence) {
        if (sequence == null || sequence.isEmpty()) {
            return sequence;
        }
        String messageString = convertMessage(sequence), cleanString = "";
        List <Integer> output = new ArrayList<>();
        for (int i = 0; i < messageString.length(); i += 8) {
            String part = messageString.substring(i, Math.min(i+8, messageString.length()));
            if (countOnes(part) % 2 != 0) {
                throw new IllegalArgumentException("the bits are corrupted");
            } else {
                cleanString += part.substring(0, 7);
            }
        }
        for (int i = 0; i + 8 <= cleanString.length(); i += 8) {
            String part = cleanString.substring(i, Math.min(i+8, cleanString.length()));
            output.add(Integer.parseInt(part, 2));
        }
        return output;
    }

}