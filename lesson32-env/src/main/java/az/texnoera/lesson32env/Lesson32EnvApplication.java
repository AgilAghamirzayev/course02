package az.texnoera.lesson32env;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Lesson32EnvApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson32EnvApplication.class, args);
    }

}
