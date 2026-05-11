package l14.colelctions.inclass.s6;

import java.io.IOException;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        Test test = new Test();

        try {
            test.test1(false);
            test.test2(true);
        } catch (IOException e) {
            System.out.println("IOException bas verdi ");
        } catch (SQLException e) {
            System.out.println("SQLException bas verdi");
        }

    }

}
