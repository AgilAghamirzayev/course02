package l20.reflectionandannotations.practice.entity;

import l20.reflectionandannotations.practice.annotation.Column;
import l20.reflectionandannotations.practice.annotation.Id;
import l20.reflectionandannotations.practice.annotation.Table;

@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    public User(Long id, String fullName, String email, Integer age) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
    }
    
}