import java.util.*;
import java.util.stream.Collectors;

class DnDCharacter {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public DnDCharacter(){
        this.strength = diceMethod();
        this.dexterity= diceMethod();
        this.constitution = diceMethod();
        this.intelligence = diceMethod();
        this.wisdom = diceMethod();
        this.charisma = diceMethod();
    }

    public int diceMethod(){
        return this.ability(rollDice());
    }
    int ability(List<Integer> scores) {
        List<Integer> top3Elements = scores.stream()
                                            .sorted(Comparator.reverseOrder())
                                            .limit(3)
                                            .collect(Collectors.toList());
        int sum =0;
        for(int x: top3Elements){
            sum+= x;
        }
        return sum;
    }

    List<Integer> rollDice() {
        List<Integer> diceThrows = new ArrayList<>();
        Random randomGen = new Random();
        for(int i=0; i<4; i++){
            diceThrows.add(randomGen.nextInt(6) +1);
        }
        return diceThrows;
    }

    int modifier(int input) {
        double num =  ((input - 10) /2.0);
        if(num < 0){
            num = -1 * num;
            return  - 1 * (int)Math.ceil(num);
        }else{
            return (int)num;
        }
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
         return constitution;   
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(constitution);
    }
}
