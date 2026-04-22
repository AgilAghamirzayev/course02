package l11.enums.methodhiding.overrinding.methodhiding.part4;

public class FlyingCar implements OperateCar, FlyCar {
    // ...
    public int startEngine(EncryptedKey key) {
        FlyCar.super.startEngine(key);
        OperateCar.super.startEngine(key);
        return 0;
    }
}
