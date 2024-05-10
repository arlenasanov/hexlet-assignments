package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    String tagValue;
    TagInterface tag;

    public LabelTag(String tagValue, TagInterface tag) {
        this.tagValue = tagValue;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" + tagValue + tag.render() + "</label>";
    }
}
// END
