package az.texnoera.lesson31controller.model.response;

public record AuthReponse(
        String accessToken,
        String refreshToken,
        UserResponse user
) {
}
