package lesson23.designpatterns.creation.abstractfactory;

class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(UiFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }
}
