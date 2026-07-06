package lesson23.designpatterns.creation.abstractfactory;

public class Main {
    public static void main(String[] args) {
        UiFactory factory = new MacUiFactory();
        Application app = new Application(factory);
        app.render();
    }
}
