package l14.colelctions.inclass.s6;

import java.io.IOException;
import java.sql.SQLException;

public class Main2 {


    public static void main(String[] args) {
        Test test = new Test();

        try {
            test.test1(false);
            test.test2(true);
        } catch (IOException | SQLException e) {
            System.out.println("Xeta bas verdi ");
        } catch (Exception e) {
            System.out.println("Exception ");
        }

    }

}
