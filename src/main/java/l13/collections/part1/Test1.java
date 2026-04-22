package l13.collections.part1;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map<String, String> azAndEng = new HashMap<>();
        azAndEng.put("alma", "apple");
        azAndEng.put("masin", "car");
        azAndEng.put("alma", "apple1");

        String value = azAndEng.get(new String("alma"));

        System.out.println(value);

        System.out.println(2044440 % 16);
    }
}
