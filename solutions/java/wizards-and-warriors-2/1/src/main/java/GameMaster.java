public class GameMaster {

    public String describe(Character c){
        return String.format("You're a level %d %s with %d hit points.", c.getLevel(), c.getCharacterClass(), c.getHitPoints());
    }

    public String describe(Destination d){
        return String.format("You've arrived at %s, which has %d inhabitants.",d.getName(), d.getInhabitants());
    }

    public String describe(TravelMethod t){
        return String.format("You're traveling to your destination %s.",
                            switch(t){
            case WALKING -> "by walking";
            case HORSEBACK -> "on horseback";
                            });
    }

    public String describe(Character c, Destination d, TravelMethod t){
        return describe(c)+" "+describe(t)+" "+describe(d);
    }

    public String describe(Character character, Destination destination) {
        return describe(character, destination, TravelMethod.WALKING);
    }
}
