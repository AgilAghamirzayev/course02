package az.texnoera.lesson31controller.service;

import az.texnoera.lesson31controller.model.request.LoginRequest;
import az.texnoera.lesson31controller.model.request.RegisterRequest;
import az.texnoera.lesson31controller.model.response.AuthReponse;
import az.texnoera.lesson31controller.model.response.UserResponse;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public AuthReponse login(LoginRequest authRequest) {

        System.out.println("LOGIN.SUCCESS");

        return new AuthReponse(
                Arrays.toString(authRequest.password().concat(authRequest.email()).getBytes()),
                Arrays.toString(authRequest.password().concat(authRequest.email()).getBytes()),
                new UserResponse(authRequest.email(), authRequest.password()));
    }

    public AuthReponse register(RegisterRequest registerRequest) {
        System.out.println("REGISTER.SUCCESS");

        return new AuthReponse(
                Arrays.toString(registerRequest.password().concat(registerRequest.email()).getBytes()),
                Arrays.toString(registerRequest.password().concat(registerRequest.email()).getBytes()),
                new UserResponse(registerRequest.email(), registerRequest.password()));    }
}
