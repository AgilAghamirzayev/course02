package l13.collections.usecases;

import java.util.ArrayList;
import java.util.List;

public class ListUseCaseExample {
    public static void main(String[] args) {
        // Real use case: keep student attendance in order.
        List<String> attendanceList = new ArrayList<>();
        attendanceList.add("Emma");
        attendanceList.add("Noah");
        attendanceList.add("Olivia");

        System.out.println("Where to use List: when order matters and duplicates are allowed.");
        System.out.println("Attendance list: " + attendanceList);
        System.out.println("First student entered class: " + attendanceList.get(0));
    }
}
