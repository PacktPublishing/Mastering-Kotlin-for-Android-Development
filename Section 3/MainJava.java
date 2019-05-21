package classes;

@SuppressWarnings("ALL")
public class MainJava {

    private void accessKotlinSingleton() {
        String name = Singleton.INSTANCE.getName();
    }

    private void accessCompanionObject() {
        VehicleFactory.Companion.newVehicle();
        VehicleFactory.newVehicleStatic();
    }
}
