package lesson23.designpatterns.creation.builder;


public class Main {
    public static void main(String[] args) {
        User build = User.builder().firstName("Ali")
                .lastName("Aliyev")
                .age(21)
                .build();

        System.out.println(build);


        User build1 = User.builder().firstName("Ali")
                .lastName("Aliyev")
                .email("21")
                .build();

        System.out.println(build1);
    }
}
