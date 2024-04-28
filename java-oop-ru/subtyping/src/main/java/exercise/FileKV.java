package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    String path;
    Map<String, String> db;

    public FileKV(String path, Map<String, String> db) {
        this.path = path;
        this.db = new HashMap<>(db);
        writeChangesToFile();
    }

    public void writeChangesToFile() {
        String content = Utils.serialize(db);
        Utils.writeFile(path, content);
    }

    @Override
    public void set(String key, String value) {
        db.put(key, value);
        writeChangesToFile();
    }

    @Override
    public void unset(String key) {
        db.remove(key);
        writeChangesToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return db.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(db);
    }
}
// END
