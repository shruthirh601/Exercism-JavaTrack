import java.util.*;

class Yacht {

    private int[] dice;
    private YachtCategory yachtCategory;
    private int finalScore;
    int counter;
    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        switch (yachtCategory) {
            case ONES: finalScore =1;
            counter =0;
                for(int i: dice){
                if(i == 1)
                    counter++;
            }
                finalScore = counter*1;
                break;
            case TWOS: finalScore =1;
                counter =0;
                for(int i: dice){
                    if(i == 2)
                        counter++;
                }
                finalScore = counter*2;
                break;
            case  THREES:finalScore =1;
                counter =0;
                for(int i: dice){
                    if(i == 3)
                        counter++;
                }
                finalScore = counter*3;
                break;
            case FOURS:finalScore =1;
                counter =0;
                for(int i: dice){
                    if(i == 4)
                        counter++;
                }
                finalScore = counter*4;
                break;
            case FIVES:finalScore =1;
                counter =0;
                for(int i: dice){
                    if(i == 5)
                        counter++;
                }
                finalScore = counter*5;
                break;
            case SIXES: finalScore =1;
                counter =0;
                for(int i: dice){
                    if(i == 6)
                        counter++;
                }
                finalScore = counter*6;
                break;
            case LITTLE_STRAIGHT: boolean flag = true;
                Arrays.sort(dice);
                for(int i =0; i < dice.length; i++){
                    if(!(dice[i] == i+1))
                        flag = false;
            }
                finalScore = flag ? 30 : 0;
                break;
            case BIG_STRAIGHT: boolean flag1 = true;
                Arrays.sort(dice);
                for(int i =0; i < dice.length; i++){
                    if(!(dice[i] == i+2))
                        flag1 = false;
                }
                finalScore = flag1 ? 30 : 0;
                break;
            case CHOICE: for(int i: dice)
                finalScore = finalScore + i;
            break;
            case YACHT: Set<Integer> set = new HashSet<>();
                for(int i: dice)
                    set.add(i);
            finalScore = (set.size() == 1)? 50:0;
            break;
            case FOUR_OF_A_KIND:  Map<Integer, Integer> freq = new HashMap<>();
                for (int die : dice) {
                    freq.put(die, freq.getOrDefault(die, 0) + 1);
                }
                boolean isFourOrMore = freq.values().stream().anyMatch(count -> count >= 4);
                for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
                    if(entry.getValue() >= 4){
                        finalScore += entry.getKey() * 4;
                    }
                }
                break;
            case FULL_HOUSE: Map<Integer, Integer> freq1 = new HashMap<>();
                for (int die : dice) {
                    freq1.put(die, freq1.getOrDefault(die, 0) + 1);
                }
                boolean isFullHouse = freq1.containsValue(3) && freq1.containsValue(2);
                int sum1 = Arrays.stream(dice).sum();
                finalScore = isFullHouse ? sum1 : 0;
                break;
            default: finalScore = 0;
        }
        return finalScore;
           }

}
