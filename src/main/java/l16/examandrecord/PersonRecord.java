package l16.examandrecord;

import java.util.ArrayList;
import java.util.List;

public record PersonRecord(String name, List<String> courses) {
    public PersonRecord {
        if (name == null) throw new NullPointerException("name cannot be null");
    }

    public List<String> courses() {
        return new ArrayList<>(courses);
    }

}
