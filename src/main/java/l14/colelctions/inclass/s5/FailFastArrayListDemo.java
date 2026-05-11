package l14.colelctions.inclass.s5;

import java.util.ArrayList;
import java.util.List;

public class FailFastArrayListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Ali", "Veli", "Aynur"));
        
        for (String n : names) {
            if (n.equals("Veli")) {
                names.add("Nigar"); // struktur dəyişikliyi
            }
        }

    }
}