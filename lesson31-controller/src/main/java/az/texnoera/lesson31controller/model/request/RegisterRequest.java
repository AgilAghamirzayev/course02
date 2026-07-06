package az.texnoera.lesson31controller.model.request;

public record RegisterRequest (
        String name,
        String surname,
        String email,
        String password
){

}
