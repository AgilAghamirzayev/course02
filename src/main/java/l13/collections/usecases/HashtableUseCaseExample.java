package l13.collections.usecases;

import java.util.Hashtable;

public class HashtableUseCaseExample {
    public static void main(String[] args) {
        // Real use case: legacy synchronized settings store.
        Hashtable<String, String> settings = new Hashtable<>();
        settings.put("theme", "dark");
        settings.put("language", "English");

        System.out.println("Where to use Hashtable: old synchronized key-value collections.");
        System.out.println("Language setting: " + settings.get("language"));
    }
}
