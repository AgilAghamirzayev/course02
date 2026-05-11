package l14.colelctions.inclass.s6;

import java.io.IOException;
import java.sql.SQLException;

public class Test {

    public void test1(boolean flag) throws IOException {
        if (flag) {
            throw new IOException();
        }
        System.out.println("Success");
    }


    public void test2(boolean flag) throws SQLException {
        if (flag) {
            throw new SQLException();
        }
        System.out.println("Success");
    }

    public void test3(boolean flag) throws Exception {
        if (flag) {
            throw new Exception();
        }
        System.out.println("Success");
    }


}
