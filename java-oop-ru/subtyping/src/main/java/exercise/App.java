package exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> map = storage.toMap();
        Set<Entry<String, String>> entries = map.entrySet();
        entries.forEach(entry -> storage.unset(entry.getKey()));
        entries.forEach(entry -> storage.set(entry.getValue(), entry.getKey()));
    }

    public static void main(String[] args) {

    }
}
// END
