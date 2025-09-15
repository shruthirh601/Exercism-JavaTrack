
class ResistorColorDuo {
    int value(String[] colors) {
        String resultString="";
        for(String color: colors){
            resultString += getBandColor(color);
        }
        if(resultString.length() > 2)
            resultString = resultString.substring(0,2);
        Integer result = new Integer(resultString);
        return result.intValue();
    }

    int getBandColor(String color){
        int score =0;
        switch(color){
            case "black": score = 0;
                break;
            case "brown": score =1;
                break;
            case "red": score =2;
                break;
            case "orange": score =3;
                break;
            case "yellow": score = 4;
                break;
            case "green": score =5;
                break;
            case "blue": score =6;
                break;
            case "violet": score = 7;
                break;
            case "grey": score =8;
                break;
            case "white": score =9;
                break;
        }
        return score;
    }
}
