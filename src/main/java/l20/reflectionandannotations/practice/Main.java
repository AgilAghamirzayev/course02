package l20.reflectionandannotations.practice;

import l20.reflectionandannotations.practice.builder.QueryBuilder;
import l20.reflectionandannotations.practice.entity.User;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        System.out.println();
        User user = new User(
                1L,
                "Ali Aliyev",
                "agil@example.com",
                11
        );

        System.out.println(QueryBuilder.selectAll(User.class));
        System.out.println(QueryBuilder.selectById(user));
        System.out.println(QueryBuilder.insert(user));
        System.out.println(QueryBuilder.updateById(user));
        System.out.println(QueryBuilder.deleteById(User.class));
    }
}