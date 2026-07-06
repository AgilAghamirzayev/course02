package az.texnoera.lesson32env;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Value("${mock.service.json-placeholder.url}")
    private  String postApi;

    @Value("${mock.service.json-placeholder.connection-timeout}")
    private Duration connectionTimeout;

    @Value("${mock.service.json-placeholder.read-timeout}")
    private  Duration readTimeout;


    @GetMapping
    public String getPostApi() {
        return postApi;
    }

    @GetMapping("/timeout")
    public String getPostApiTimeout() {
        return postApi + " " + connectionTimeout + " " + readTimeout;
    }


}

