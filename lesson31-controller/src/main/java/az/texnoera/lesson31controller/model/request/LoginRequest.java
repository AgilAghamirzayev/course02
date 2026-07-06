package az.texnoera.lesson31controller.model.request;

public record LoginRequest(
        String email,
        String password
) {
}
