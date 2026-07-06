package lesson23.designpatterns.creation.singleton;

class BillPughAppConfig {
    private final String databaseUrl;

    private BillPughAppConfig() {
        this.databaseUrl = "jdbc:mysql://localhost:3306/app";
    }

    private static class Holder {
        private static final BillPughAppConfig INSTANCE = new BillPughAppConfig();
    }

    public static BillPughAppConfig getInstance() {
        return Holder.INSTANCE;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
}