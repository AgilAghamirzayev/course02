package az.texnoera.lesson32env.model.properties;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ConfigurationProperties("mock.service.json-placeholder")
public class JsonPlaceholderProperties {

    private String url;
    @EqualsAndHashCode.Exclude
    private Duration connectionTimeout;
    private Duration readTimeout;
    @ToString.Include
    private List<Integer> test;
    private A a;
    private Map<String, String> map;

    public record A(String b, Integer c){}
}
