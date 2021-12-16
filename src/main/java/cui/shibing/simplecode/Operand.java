package cui.shibing.simplecode;

import java.util.HashMap;
import java.util.Map;

public abstract class Operand {
    private final Map<String, Object> properties = new HashMap<>();

    public void setValue(String key, Object value) {
        properties.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue(String key) {
        return (T) properties.get(key);
    }
}
