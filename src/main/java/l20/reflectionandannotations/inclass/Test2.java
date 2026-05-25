package l20.reflectionandannotations.inclass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person ali = new Person("Ali", 21);
        Class<? extends Person> aClass = ali.getClass();

        for (Method method : aClass.getMethods()) {
            if (method.isAnnotationPresent(Printable.class)) {
                method.invoke(ali);
            }
        }

    }
}
