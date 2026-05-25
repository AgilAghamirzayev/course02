package lessoon23.designpatterns.creation.singleton;

class SafeAppConfig {
    private static volatile SafeAppConfig instance;

    private final String databaseUrl;

    private SafeAppConfig() {
        this.databaseUrl = "jdbc:mysql://localhost:3306/app";
    }

    public static SafeAppConfig getInstance() {

        // First check (without locking)
        if (instance == null) {

            synchronized (AppConfig.class) {

                // Second check (with locking)
                if (instance == null) {
                    instance = new SafeAppConfig();
                }
            }
        }

        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
}