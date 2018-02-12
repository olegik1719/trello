package com.github.olegik1719.trello.acmp;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ACMP389Test {
    @Test
    public void test(){
        //Scanner scanner = new Scanner(System.in);
        int nSize = 1 << 0;
        System.out.printf("!!!%n%s%n!!!%n",nSize);
        //int[] test = new int[-1];
        int a = nSize;
        while (a%2==0){
            a >>=1;
            System.out.printf("%s%n",a);
        }
        System.out.printf("!!!%n%s%n",a);
    }
}