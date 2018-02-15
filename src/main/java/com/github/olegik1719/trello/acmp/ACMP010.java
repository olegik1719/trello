package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://acmp.ru/index.asp?main=task&id_task=10
 * Вася в школе изучил квадратные уравнения и понял, как они легко решаются путем вычисления дискриминанта.
 * Но Петя поведал ему о методе решения кубических уравнений вида A*X^3 + B*X^2 + C*X + D = 0.
 * На факультативе по математике Васе задали решить около ста уравнений как раз такого вида.
 * Но, к сожалению, Вася забыл формулы, о которых рассказывал ему Петя.
 * Но Васе было известно, что все корни уравнений – целые числа и находятся на отрезке [-100, 100].
 * Поэтому у Васи есть шанс найти их методом перебора, но для этого ему придется затратить уйму времени,
 * т.к. возможно необходимо будет осуществить перебор нескольких тысяч значений.
 * Помогите Васе написать программу, которая поможет ему найти корни кубических уравнений!
 *
 * В единственной строке входного файла INPUT.TXT записаны 4 числа:
 * A, B, C и D – целые коэффициенты кубического уравнения.
 * Каждый коэффициент по модулю меньше 32768.
 *
 * В единственную строку выходного файла OUTPUT.TXT нужно вывести через пробел
 * в порядке возрастания все корни заданного кубического уравнения.
 * Кратные корни следует выводить только один раз.
 */

public class ACMP010 {
	
	static int origA;
	static int origB;
	static int origC;
	static int origD;
	
    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        origA = sc.nextInt();
        origB = sc.nextInt();
        origC = sc.nextInt();
        origD = sc.nextInt();
        pw.println(doIt());
        pw.flush();
    }

    static String doIt(){
		int B = origB / origA;
		int C = origC / origA;
		int D = origD / origA;
		//X^3 + B*x^2 + C*X + D = 0
		int[] solve = new int[3];
		if (D == 0){
			//X^3 + B*X^2 + C*X = 0
			solve[0] = 0;
			if (C == 0){
				solve[1] == 0;
				if (B == 0){
					solve[2] == 0;
				}else{
					solve[2] == -B;
				}
			}else{
				int diskriminant = B*B - 4*C;
				solve[1] = (-B + Math.sqrt(diskriminant))/2;
				solve[2] = (-B - Math.sqrt(diskriminant))/2;
			}
		}else{
			int x = 1;
			int index = 0;
			while (x <= 100 && index < 3){
				if ( D%x == 0 ){
					... 
		}
        return null;
    }
	
	static boolean checkSolve(int x){
		return origA * x^3 + origB * x^2 + origC * x + origD
	}

}
