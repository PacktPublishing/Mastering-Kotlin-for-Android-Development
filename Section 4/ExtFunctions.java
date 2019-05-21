

@SuppressWarnings("ALL")
public class ExtFunctions {

    public void callExtensionFunction() {
        Car car = new Car("xyz", 2015);
        boolean isOld = ExtensionFunctionsKt.isOld(car);
    }
}
