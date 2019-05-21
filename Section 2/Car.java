package kotlinbasics.java;

import kotlinbasics.kotlin.CarKt;

public class Car {

    private String model;

    private final boolean dieselEngine;

    public Car(String model, boolean dieselEngine) {
        this.model = model;
        this.dieselEngine = dieselEngine;
        CarKt carKt = new CarKt("c", true);
        carKt.setModel("mosl");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isDieselEngine() {
        return dieselEngine;
    }
}
