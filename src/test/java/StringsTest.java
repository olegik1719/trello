import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void countDigits() {
        int test = Strings.countDigits("qw123awse4wq");
        assert test == 4;
    }
}