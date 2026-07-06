package az.texnoera.lesson32env;

import az.texnoera.lesson32env.model.properties.JsonPlaceholderProperties;
import az.texnoera.lesson32env.model.properties.User;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/v2")
public class PostControllerV2 {

    private final JsonPlaceholderProperties jsonPlaceholderProperties;

    @GetMapping("/user")
    public User user() {
        String surname = User.Fields.surname;
        String name = User.Fields.name;
        System.out.println(surname + " " + name);
        return User.of("ali", "vali");
    }


    @GetMapping("/timeout")
    public String getPostApiTimeout() {
        return jsonPlaceholderProperties.getUrl() + " "
                + jsonPlaceholderProperties.getConnectionTimeout() + " "
                + jsonPlaceholderProperties.getReadTimeout();
    }

    @GetMapping
    public List<Integer> getPostApi() {
        return jsonPlaceholderProperties.getTest();
    }

    @GetMapping("/a")
    public JsonPlaceholderProperties.A getPostA() {
        return jsonPlaceholderProperties.getA();
    }

    @GetMapping("/map")
    public Map<String, String> getPostB() {
        return jsonPlaceholderProperties.getMap();
    }

    @GetMapping("/builder")
    public JsonPlaceholderProperties getPostDuration() {
        return JsonPlaceholderProperties.builder()
                .url("a")
                .connectionTimeout(Duration.ZERO)
                .readTimeout(Duration.ZERO)
                .test(new ArrayList<>())
                .a(new JsonPlaceholderProperties.A("ali", 33))
                .map(Map.of("k", "v"))
                .build();
    }
}

