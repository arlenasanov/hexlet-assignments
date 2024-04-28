package exercise;

import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
    private KeyValueStorage storage;

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(Map.of("key", "value", "car", "mercedes"));
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
        storage = new FileKV("src/test/resources/file", Map.of("key", "value", "car", "mercedes"));
    }

    // BEGIN
    @Test
    public void setTest() {
        storage.set("country", "usa");
        String content = Utils.readFile("src/test/resources/file");
        Map<String, String> expected = Utils.unserialize(content);

        assertEquals(expected, storage.toMap());
    }

    @Test
    public void unsetTest() {
        storage.unset("value");
        String content = Utils.readFile("src/test/resources/file");
        Map<String, String> expected = Utils.unserialize(content);

        assertEquals(expected, storage.toMap());
    }

    @Test
    public void getTest() {
        String expected = "value";
        assertEquals(expected, storage.get("key", "default"));

        expected = "default";
        assertEquals(expected, storage.get("animal", "default"));
    }

    @Test
    public void toMapTest() {
        String content = Utils.readFile("src/test/resources/file");
        Map<String, String> expected = Utils.unserialize(content);

        assertEquals(expected, storage.toMap());
    }


    // END
}
