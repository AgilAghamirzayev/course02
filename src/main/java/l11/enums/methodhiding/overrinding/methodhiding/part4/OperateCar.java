package l11.enums.methodhiding.overrinding.methodhiding.part4;

public interface OperateCar {
    // ...
    default public int startEngine(EncryptedKey key) {
        // Implementation
        return 1;
    }
}