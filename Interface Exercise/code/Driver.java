public class Driver {
    public static void main(String[] args) {
        isVehicle[] vehicleArray = new isVehicle[4];

        vehicleArray[0] = new Jeep("cherokee", 4, 400, 4);
        vehicleArray[1] = new Hovercraft("airlift", 10, 80, 0, 200);
        vehicleArray[2] = new Frigate("tobacco", 80, 500, 30000);
        vehicleArray[3] = new PoliceCar("LAPD", 5, 407, 4);

        isEmergency emergency = (isEmergency)vehicleArray[3];
        emergency.soundSiren();

        for (int i=0; i<vehicleArray.length; i++) {

            System.out.println(vehicleArray[i].getName());

            if (vehicleArray[i] instanceof isLandVehicle) {
                isLandVehicle land = (isLandVehicle)vehicleArray[i];
                land.drive();
            } else {
                isSeaVessel sea = (isSeaVessel)vehicleArray[i];
                sea.launch();
            }

        }
    }
}
