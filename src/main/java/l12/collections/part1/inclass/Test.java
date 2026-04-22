package l12.collections.part1.inclass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

//        MyList myList = new MyList();
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        for (Integer s: myList) {
//            System.out.println(s);
//        }
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//        list.add(3);
//
//        System.out.println(list);
//
//        list.remove(1);
//        System.out.println(list);
//
//        boolean contains = list.contains(3);
//        System.out.println(contains);
//
//        for (Integer i : list) {
//            System.out.println(i);
//        }
//
//
        List<Person> people = new ArrayList<>();
        people.add(new Person("A", 1));
        people.add(new Person("A", 1));
        people.add(new Person("A", 1));
        people.add(new Person("A", 1));
        people.add(new Person("A", 1));

        System.out.println(people);
        for (Person person : people) {
            System.out.println(person);
        }

        List<Person> people2 = new LinkedList<>();
    }
}
