package az.texnoera.lesson31controller.controller;

import az.texnoera.lesson31controller.model.request.LoginRequest;
import az.texnoera.lesson31controller.model.request.RegisterRequest;
import az.texnoera.lesson31controller.model.response.AuthReponse;
import az.texnoera.lesson31controller.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


   /*
    products/1/items/2           -> path variable     @PathVariable
    products?color="Red" -> request parameter @RequestParam
    products              -> request body     @RequestBody
    products              -> request header   @RequestHeader

     */


@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/login")
    public AuthReponse login(@RequestBody LoginRequest authRequest) {
        return authService.login(authRequest);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthReponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

}
