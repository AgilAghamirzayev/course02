package l20.reflectionandannotations.inclass;

public interface House {
    /**
     * @deprecated use of open
     * is discouraged, use
     * openFrontDoor or
     * openBackDoor instead.
     */
    @Deprecated(forRemoval = false, since = "1.0")
    void open();

    void openFrontDoor();

    void openBackDoor();
}