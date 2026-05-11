package l14.colelctions.inclass.s4;

import java.util.ArrayList;
import java.util.List;

public class ListOfDemo {
    public static void main(String[] args) {
        List<String> roles = new ArrayList<>(List.of("ADMIN", "TEACHER", "STUDENT"));
        System.out.println(roles);

        roles.add("GUEST"); // UnsupportedOperationException
        System.out.println(roles);

    }
}