
class Hovercraft implements isLandVehicle, isSeaVessel{
    private String name;
    private int maxPassengers;
    private int maxSpeed;
    private int numWheels;
    private int displacement;

    public Hovercraft(String name, int maxPassengers, int maxSpeed, int numWheels, int displacement) {
        this.name = name;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
        this.numWheels = numWheels;
        this.displacement = displacement;
    }


    @Override
    public int getNumWheels() {
        return numWheels;
    }

    @Override
    public void setNumWheels(int numWheels1) {
        this.numWheels = numWheels1;
    }

    @Override
    public void drive() {
        System.out.println("I'm a hovercraft broom broom");
    }

    @Override
    public int getDisplacement() {
        return displacement;
    }

    @Override
    public void setDisplacement(int displacement1) {
        displacement = displacement1;
    }

    @Override
    public void launch() {
        System.out.println("launching le hovercraft");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getMaxPassengers() {
        return maxPassengers;
    }

    @Override
    public void setMaxPassengers(int maxPassengers1) {
        this.maxPassengers = maxPassengers1;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void enterLand() {
        System.out.println("landing...");
    }

    public void enterSea() {
        System.out.println("watering...");
    }
}
