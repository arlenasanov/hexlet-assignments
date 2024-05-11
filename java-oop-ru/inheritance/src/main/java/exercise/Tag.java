package exercise;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String tagName;
    private final Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = new LinkedHashMap<>(attributes);
    }

    public final Map<String, String> getAttributes() {
        return attributes;
    }

    public final String getTagName() {
        return tagName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<" + getTagName() + " ");
        for (var elem : getAttributes().entrySet()) {
            sb.append(String.format("%s=\"%s\" ", elem.getKey(), elem.getValue()));
        }
        return sb.substring(0, sb.length() - 1) + '>';
    }
}
// END
