package com.github.olegik1719.trello.strings;

import org.junit.Test;

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
        System.out.printf("%s%n",Strings.substring("asasdasa","as"));
        System.out.printf("%s%n",Strings.substring("asasdasa",""));
        System.out.printf("%s%n","".indexOf("",0));
    }
}