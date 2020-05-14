public class Frigate implements isSeaVessel {
    private String name;
    private int maxPassengers;
    private int maxSpeed;
    private int displacement;

    public Frigate(String name, int maxPassengers, int maxSpeed, int displacement) {
        this.name = name;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
        this.displacement = displacement;
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
        System.out.println("launching Frigate... boom");
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

    public void fireGun() {
        System.out.println("dor! dor! dor!");
    }
}
