package com.github.olegik1719.trello;

import com.github.olegik1719.trello.Strings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringsTest {

    @Test
    public void countDigits() {
        int test = Strings.countDigits("qw123awse4wq");
        assertEquals("It's not right!", test, 4);
    }
}