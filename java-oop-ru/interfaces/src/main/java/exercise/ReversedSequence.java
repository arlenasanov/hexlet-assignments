package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    String string;

    public ReversedSequence(String string) {
        StringBuilder sb = new StringBuilder(string);
        this.string = sb.reverse().toString();
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return string.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return string.substring(start, end);
    }

    @Override
    public String toString() {
        return string;
    }
}
// END
