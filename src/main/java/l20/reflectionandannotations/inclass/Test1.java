package l20.reflectionandannotations.inclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) {
        Class<Person> clazz = Person.class;

        System.out.println(clazz.getName());
        System.out.println(clazz.getSuperclass().getName());
        System.out.println(clazz.getPackage().getName());
        System.out.println(clazz.getSimpleName());

        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();
        System.out.println("Methods:");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println();

        try {
            Constructor<Person> clazzAli = clazz.getConstructor(String.class, int.class);
            Person ali = clazzAli.newInstance("Ali", 11);
            System.out.println(ali);

            Method setName = clazz.getMethod("setName", String.class);
            setName.invoke(ali, "Murad");
            System.out.println(ali);

            Method setPrivateName = clazz.getDeclaredMethod("setPrivateName", String.class);
            setPrivateName.setAccessible(true);
            setPrivateName.invoke(ali, "Vali");

            System.out.println(ali);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Xeta bas verdi");
        }


    }
}
