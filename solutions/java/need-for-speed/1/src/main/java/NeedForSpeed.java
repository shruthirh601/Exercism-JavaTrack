class NeedForSpeed {
    private int battery = 100;
    private int speed;
    private int batteryDrain;
    private int distance;
    public NeedForSpeed(int speed, int batteryDrain) {
        this.batteryDrain = batteryDrain;
        this.speed = speed;
    }

    public boolean batteryDrained() {
        return battery < batteryDrain;
    }

    public int distanceDriven() {
        return distance; 
    }

    public void drive() {
         if(batteryDrained())
             return;
         distance += speed;
         battery -= batteryDrain;

         battery = Math.max(0, battery);
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50,4);
    }
}

class RaceTrack {
    private int distance;
    public RaceTrack(int distance) {
            this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        while(!car.batteryDrained() && car.distanceDriven() <= distance)
            car.drive();

        return car.distanceDriven() >= distance;
    }
}
