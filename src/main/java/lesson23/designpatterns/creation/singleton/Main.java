package lesson23.designpatterns.creation.singleton;

public class Main {
    public static void main(String[] args) {
        BillPughAppConfig appConfig = BillPughAppConfig.getInstance();
        System.out.println(appConfig.getDatabaseUrl());

        BillPughAppConfig appConfig2 = BillPughAppConfig.getInstance();
        System.out.println(appConfig2.getDatabaseUrl());

        System.out.println(appConfig == appConfig2);
    }
}
