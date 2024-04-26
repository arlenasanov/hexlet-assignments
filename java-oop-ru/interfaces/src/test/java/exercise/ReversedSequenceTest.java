package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

class ReversedSequenceTest {
    @Test
    void testMethods() {
        CharSequence text = new ReversedSequence("abcdef");
        String expected = "fedcba";

        assertThat(text.toString()).isEqualTo(expected);
        assertThat(text.charAt(1)).isEqualTo('e');
        assertThat(text.toString().length()).isEqualTo(6);
        assertThat(text.subSequence(1, 4).toString()).isEqualTo("edc");
    }
}