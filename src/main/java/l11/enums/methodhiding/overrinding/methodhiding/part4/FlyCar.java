package l11.enums.methodhiding.overrinding.methodhiding.part4;

public interface FlyCar {
    // ...
    default public int startEngine(EncryptedKey key) {
        // Implementation
        return 0;
    }
}