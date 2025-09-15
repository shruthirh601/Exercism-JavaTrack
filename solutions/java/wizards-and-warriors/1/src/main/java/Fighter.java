class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter{

    @Override
    public String toString(){
        return "Fighter is a Warrior";
    }

    boolean isVulnerable(){
        return false;
    }

    int getDamagePoints(Fighter opponent){
        return opponent.isVulnerable() ? 10: 6;
    }
}

class Wizard extends Fighter{
    boolean spellPrepared;
    
    @Override
    public String toString(){
        return "Fighter is a Wizard";
    }

    public boolean prepareSpell(){
        spellPrepared = true;
        return spellPrepared;
    }
    public boolean isVulnerable(){
        return !spellPrepared;
    }

    int getDamagePoints(Fighter opponent){
        return spellPrepared ? 12:3;
    }
}