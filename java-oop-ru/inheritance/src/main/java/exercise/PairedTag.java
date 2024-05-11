package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String tagBody;
    private final List<Tag> singleTags;

    public PairedTag(String tagName, Map<String, String> attributes,
                     String tagBody, List<Tag> singleTags) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.singleTags = singleTags;
    }

    public String getTagBody() {
        return tagBody;
    }

    public List<Tag> getSingleTags() {
        return List.copyOf(singleTags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(tagBody);
        for (var elem : singleTags) {
            sb.append(elem.toString());
        }
        sb.append(String.format("</%s>", getTagName()));
        return sb.toString();
    }
}
// END
