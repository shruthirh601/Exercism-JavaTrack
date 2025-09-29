class Robot {

    private int xCord;
    private int yCord;
    private Orientation orientation;
    Robot(GridPosition initialPosition, Orientation initialOrientation) {
        xCord = initialPosition.x;
        yCord = initialPosition.y;
        orientation = initialOrientation;
    }

    GridPosition getGridPosition() {
        return new GridPosition(xCord, yCord);
    }

    Orientation getOrientation() {
        return orientation;
    }

    void advance() {
       switch(orientation){
        case NORTH: yCord++; break;
        case EAST: xCord++; break;
        case SOUTH: yCord--; break;
        case WEST: xCord--; break;
       }
    }

    void turnLeft() {
        switch (orientation) {
            case NORTH: orientation = Orientation.WEST; break;
            case EAST: orientation = Orientation.NORTH; break;
            case SOUTH: orientation = Orientation.EAST; break;
            case WEST: orientation = Orientation.SOUTH; break;
        }
    }

    void turnRight() {
        switch(orientation) {
            case NORTH: orientation = Orientation.EAST; break;
            case EAST: orientation = Orientation.SOUTH; break;
            case SOUTH: orientation = Orientation.WEST; break;
            case WEST: orientation = Orientation.NORTH; break;
        }
    }

    void simulate(String instructions) {
        for(char c : instructions.toCharArray()) {
            switch(c) {
                case 'L': turnLeft(); break;
                case 'R': turnRight(); break;
                case 'A': advance(); break;
            }
        }
    }

}