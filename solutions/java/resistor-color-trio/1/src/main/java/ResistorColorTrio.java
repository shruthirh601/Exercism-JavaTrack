import java.util.*;
class ResistorColorTrio {
    private Map<String, Integer> resistors;
    public ResistorColorTrio(){
        resistors = new HashMap<>();
        resistors.put("black",0);
        resistors.put("brown",1);
        resistors.put("red",2);
        resistors.put("orange",3);
        resistors.put("yellow",4);
        resistors.put("green",5);
        resistors.put("blue",6);
        resistors.put("violet",7);
        resistors.put("grey",8);
        resistors.put("white",9);
    }

    String label(String[] colors) {
        StringBuilder sb = new StringBuilder();
        sb.append(resistors.get(colors[0]));
        sb.append(resistors.get(colors[1]));

        int multiplier = resistors.get(colors[2]);
        for(int i =0; i<multiplier; i++)
        {
                sb.append("0");
        }
        
        long valeuNum = Long.parseLong(sb.toString());
        String resultat;
        if(valeuNum >= 1_000_000_000){
            resultat = (valeuNum/1_000_000_000) + " gigaohms";
        }
        else if(valeuNum >= 1_000_000) {
            resultat = (valeuNum/1_000_000) + " megaohms";
        }
        else if(valeuNum >= 1_000) {
            resultat = (valeuNum/1_000) + " kiloohms";
        }
        else {
            resultat = valeuNum + " ohms";
        }
        
        return resultat;
    }
}
