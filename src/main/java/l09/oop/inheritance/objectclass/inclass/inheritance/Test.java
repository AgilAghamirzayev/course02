package l09.oop.inheritance.objectclass.inclass.inheritance;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    public static Logger logger = Logger.getLogger(Test.class.getName());
    public static HashMap<Long, String> map = new HashMap<>();

    public static void main(String[] args) {
        long id = 1;
        logger.log(Level.WARNING, "id: " + id);
    }

}
