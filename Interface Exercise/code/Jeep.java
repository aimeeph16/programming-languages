public class Jeep implements isLandVehicle{
    private String name;
    private int maxPassengers;
    private int maxSpeed;
    private int numWheels;

    public Jeep(String name, int maxPassengers, int maxSpeed, int numWheels) {
        this.name = name;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
        this.numWheels = numWheels;
    }


    @Override
    public int getNumWheels() {
        return numWheels;
    }

    @Override
    public void setNumWheels(int numWheels1) {
        numWheels = numWheels1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name1) {
        name = name1;
    }

    @Override
    public int getMaxPassengers() {
        return maxPassengers;
    }

    @Override
    public void setMaxPassengers(int maxPassengers1) {
        maxPassengers = maxPassengers1;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void setMaxSpeed(int maxSpeed1) {
        maxSpeed = maxSpeed1;
    }

    public void drive() {
        System.out.println("vroom it's driving [Deja Vu starts playing]");
    }

    public void soundHorn() {
        System.out.println("*Jeep horns*");
    }
}
