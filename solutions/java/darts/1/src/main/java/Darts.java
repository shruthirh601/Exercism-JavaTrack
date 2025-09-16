class Darts {
    int score(double xOfDart, double yOfDart) {
        double xSquare = xOfDart * xOfDart;
        double ySquare = yOfDart * yOfDart;
        double distance = Math.sqrt(xSquare + ySquare);
        if(distance <=1)
            return 10;
        else if(distance <= 5)
            return 5;
        else if(distance <= 10)
            return 1;
        else
            return 0;
    }
}
