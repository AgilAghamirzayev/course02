package az.texnoera.lesson32env.model.properties;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants
@AllArgsConstructor(staticName = "of")
public class User {
    private String name;
    private String surname;
}
