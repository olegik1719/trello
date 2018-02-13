package com.github.olegik1719.trello.acmp;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ACMP389Test {
    @Test
    public void test(){
        //Scanner scanner = new Scanner(System.in);
        int nSize = 1 << 0;

        System.out.printf("%s%n", 0 ^ 65535);
        System.out.printf("%s%n", (short)65535);
        System.out.printf("%s%n", (short) 32768);
        System.out.printf("%s%n", 2 ^ 0);
    }
}