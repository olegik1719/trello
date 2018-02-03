package com.github.olegik1719.trello.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void countDigits() {
        int test = Strings.countDigits("qw123awse4wq");
        assertEquals("It's not right!", 4, test);
    }

    @Test
    public void isPalindrome() {
        assertTrue(Strings.isPalindrome(""));
        assertTrue(Strings.isPalindrome("123454321"));
        assertTrue(Strings.isPalindrome("1234554321"));
        assertFalse(Strings.isPalindrome("159874515648"));
    }
}