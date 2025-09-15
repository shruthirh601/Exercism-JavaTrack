class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int distanceDriven;
    private int numberOfVictories;
    public void drive() {
        distanceDriven += 10;
    }

    public int getDistanceTravelled() {
        return distanceDriven;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override 
    public int compareTo(ProductionRemoteControlCar other){
        return other.numberOfVictories - this.numberOfVictories;
    }
    
}
