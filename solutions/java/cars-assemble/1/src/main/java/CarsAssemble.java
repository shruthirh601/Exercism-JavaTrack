public class CarsAssemble {
    
    public double productionRatePerHour(int speed) {
        double result=0;
        if(speed >=1 && speed <=4)
            result=(speed*221);
        else if(speed>=5 && speed <=8)
            result= (0.9*speed*221);
        else if(speed ==9)
            result= (0.8*speed*221);
        else if(speed==10)
            result= (0.77*speed*221);
        return result;
    }

    public int workingItemsPerMinute(int speed) {
        double perHour = this.productionRatePerHour(speed);
        double perMinute = perHour / 60;
        return (int)Math.floor(perMinute);

    }
}
