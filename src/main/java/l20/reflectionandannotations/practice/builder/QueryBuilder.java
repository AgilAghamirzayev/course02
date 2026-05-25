package l20.reflectionandannotations.practice.builder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import l20.reflectionandannotations.practice.annotation.Column;
import l20.reflectionandannotations.practice.annotation.Id;
import l20.reflectionandannotations.practice.annotation.Table;

public class QueryBuilder {

    public static String selectAll(Class<?> clazz) {
        String tableName = getTableName(clazz); // users
        List<String> columns = getColumnNames(clazz);

        return "SELECT " + String.join(", ", columns) // SELECT name, age FROM users;
                + " FROM " + tableName + ";";
    }

    public static String selectById(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();

        Long id = null;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                id = (Long) field.get(object);
                break;
            }
        }

        String tableName = getTableName(clazz);
        List<String> columns = getColumnNames(clazz);
        String idColumn = getIdColumnName(clazz);

        return "SELECT " + String.join(", ", columns)
                + " FROM " + tableName
                + " WHERE " + idColumn + " = " + id + ";";
    }

    public static String insert(Object object) {
        Class<?> clazz = object.getClass();
        String tableName = getTableName(clazz);

        List<String> columns = new ArrayList<>();
        List<String> placeholders = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);

                columns.add(column.name());
                placeholders.add("?");
            }
        }

        return "INSERT INTO " + tableName
                + " (" + String.join(", ", columns) + ") "
                + "VALUES (" + String.join(", ", placeholders) + ");";
    }

    public static String updateById(Object object) {
        Class<?> clazz = object.getClass();
        String tableName = getTableName(clazz);
        String idColumn = getIdColumnName(clazz);

        List<String> setParts = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)
                    && !field.isAnnotationPresent(Id.class)) {

                Column column = field.getAnnotation(Column.class);
                setParts.add(column.name() + " = ?");
            }
        }

        return "UPDATE " + tableName
                + " SET " + String.join(", ", setParts)
                + " WHERE " + idColumn + " = ?;";
    }

    public static String deleteById(Class<?> clazz) {
        String tableName = getTableName(clazz);
        String idColumn = getIdColumnName(clazz);

        return "DELETE FROM " + tableName
                + " WHERE " + idColumn + " = ?;";
    }

    private static String getTableName(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("Class must have @Table annotation");
        }

        Table table = clazz.getAnnotation(Table.class);
        return table.name();
    }

    private static List<String> getColumnNames(Class<?> clazz) {
        List<String> columns = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                columns.add(column.name());
            }
        }

        return columns;
    }

    private static String getIdColumnName(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class) && field.isAnnotationPresent(Column.class)) {

                Column column = field.getAnnotation(Column.class);
                return column.name();
            }
        }

        throw new RuntimeException("Class must have field with @Id and @Column");
    }
}