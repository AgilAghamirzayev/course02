package lesson23.designpatterns.creation.singleton;

class AppConfig {
    private static AppConfig instance;

    private String databaseUrl;

    private AppConfig() {
        this.databaseUrl = "jdbc:mysql://localhost:3306/app";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
}