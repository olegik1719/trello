package com.github.olegik1719.trello.strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringsTest {

    @Test
    public void countDigits() {
        int test = Strings.countDigits("qw123awse4wq");
        assertEquals("It's not right!", test, 4);
    }

    @Test
    public void isPalindrome() {
        assertTrue(Strings.isPalindrome(""));
        assertTrue(Strings.isPalindrome("123454321"));
        assertTrue(Strings.isPalindrome("1234554321"));
        assertFalse(Strings.isPalindrome("159874515648"));
    }

    @Test
    public void substring() {
        String string = "asasdasa";
        String substring = "as";
        List<Integer> actual = Strings.substring(string, substring);
        List<Integer> expected = Arrays.asList(0,2,5);
        assertEquals(expected,actual);
        assertEquals(string.length()+1,Strings.substring(string,"").size());
        string = "aaaaaaa";
        substring = "a";
        actual = Strings.substring(string,substring);
        expected = Arrays.asList(0,1,2,3,4,5,6);
        assertEquals(expected,actual);
    }
}