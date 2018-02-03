package com.github.olegik1719.trello.strings;

import com.github.olegik1719.trello.strings.Strings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringsTest {

    @Test
    public void countDigits() {
        int test = Strings.countDigits("qw123awse4wq");
        assertEquals("It's not right!", test, 4);
    }

    @Test
    public void substring() {
        System.out.printf("%s,%n",Strings.substring("asasdas","as"));
    }
}