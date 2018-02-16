package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://acmp.ru/index.asp?main=task&id_task=12
 * Всем известно, что дачники – народ странный, почти такой же, как и программисты.
 * Строят они свои дачи непонятно где, да и выращивают там непонятно что и непонятно зачем.
 * А уж как они туда добираются, это другая история: кто на автобусе, кто на электричке, кто на автомобиле,
 * ну а кто-то вовсе пешком ходит от дома и до самого участка.
 * Так что не стоит удивляться, если вдруг Вы узнаете, что некое садоводческое товарищество располагается на острове,
 * а дачники добираются до него самолетом. Да еще и на этом острове может не быть посадочной полосы,
 * так что высадиться на остров можно, только прыгая с парашютом
 * (мы уж не рассматриваем то, как они возвращаются с дач домой).
 * Рассмотрим этот уникальный случай.
 * Пилот всегда старается осуществить высадку парашютистов таким образом,
 * чтобы дачники приземлялись как можно ближе к своим прямоугольным участкам.
 * Пилоту интересно знать: сколько дачников приземлится на свои участки? Помогите ему решить эту задачу!
 *
 * В первой строке входного файла INPUT.TXT записано натуральное число N (1 ≤ N ≤ 1000) – количество дачников,
 * далее идут N строк, в каждой из которых описаны координаты каждого дачника и его участка:
 * X Y X1 Y1 X2 Y2 X3 Y3 X4 Y4, где
 * (X,Y) – координаты приземления парашютиста
 * (X1, Y1, X2, Y2, X3, Y3, X4,Y4) – координаты прямоугольного участка на плоскости, указанные последовательно.
 * Все координаты – целые числа, не превышающие 50000 по абсолютной величине
 *
 * В выходной файл OUTPUT.TXT нужно вывести количество дачников, приземлившихся на свой участок.
 * Попадание на границу участка считается попаданием на участок.
 */

public class ACMP012 {
    public static void main(String...a){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int[] tourists = new int[sc.nextInt()*10];
        for (int i = 0; i < tourists.length; i++) {
            tourists[i] = sc.nextInt();
        }
        pw.print(check(tourists));
        pw.flush();
    }

    static Integer check(int[] array){
        int result = 0;
        for (int i = 0; i < array.length/10; i++) {
            int[] b = new int[10];
            System.arraycopy(array,i*10,b,0,10);
            if (goal(b)) result++;
        }
        return result;
    }

    //(y_1-y_2)*y + (x_2-x_1)*x + (x_1*y_2-x_2*y_1) = 0
    public static boolean goal(int[] c){
        BigInteger[] x = new BigInteger[5];
        BigInteger[] y = new BigInteger[5];
        for (int i = 0; i < 5; i++) {
            x[i] = BigInteger.valueOf(c[i*2]);
            y[i] = BigInteger.valueOf(c[i*2+1]);
        }
        BigInteger s_qu = x[1].subtract(x[2]).multiply(x[1].subtract(x[2])).add(y[1].subtract(y[2]).multiply(y[1].subtract(y[2])))
              .multiply ((x[2].subtract(x[3]).multiply(x[2].subtract(x[3])).add(y[2].subtract(y[3]).multiply(y[2].subtract(y[3])))));
        BigInteger s_1 = x[1].subtract(x[0]).multiply(y[2].subtract(y[0])).subtract(x[2].subtract(x[0]).multiply(y[1].subtract(y[0]))).abs();
        BigInteger s_2 = x[2].subtract(x[0]).multiply(y[3].subtract(y[0])).subtract(x[3].subtract(x[0]).multiply(y[2].subtract(y[0]))).abs();
        BigInteger s_3 = x[3].subtract(x[0]).multiply(y[4].subtract(y[0])).subtract(x[4].subtract(x[0]).multiply(y[3].subtract(y[0]))).abs();
        BigInteger s_4 = x[4].subtract(x[0]).multiply(y[1].subtract(y[0])).subtract(x[1].subtract(x[0]).multiply(y[4].subtract(y[0]))).abs();
        BigInteger s_full = s_1.add(s_2).add(s_3).add(s_4);
        return s_full.pow(2).equals(s_qu.multiply(BigInteger.valueOf(4)));

        //int x = c[0];
        //int y = c[1];
//        int x_1 = c[2];
//        int y_1 = c[3];
//        int x_2 = c[4];
//        int y_2 = c[5];
//
//        int pos = (y_1-y_2)*y + (x_2-x_1)*x + (x_1*y_2-x_2*y_1);
//        if (pos == 0) return true;
//        x_1 = c[4];
//        y_1 = c[5];
//        x_2 = c[6];
//        y_2 = c[7];
//        if (pos * ((y_1-y_2)*y + (x_2-x_1)*x + (x_1*y_2-x_2*y_1)) < 0) return false;
//        x_1 = c[6];
//        y_1 = c[7];
//        x_2 = c[8];
//        y_2 = c[9];
//        if (pos * ((y_1-y_2)*y + (x_2-x_1)*x + (x_1*y_2-x_2*y_1)) < 0) return false;
//        x_1 = c[8];
//        y_1 = c[9];
//        x_2 = c[2];
//        y_2 = c[3];
//        if (pos * ((y_1-y_2)*y + (x_2-x_1)*x + (x_1*y_2-x_2*y_1)) < 0) return false;
    }
}
