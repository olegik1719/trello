package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigInteger;

/**
 * http://acmp.ru/index.asp?main=task&id_task=11
 * В нашем зоопарке появился заяц. 
 * Его поместили в клетку, и чтобы ему не было скучно, директор зоопарка распорядился поставить в его клетке лесенку.
 * Теперь наш зайчик может прыгать по лесенке вверх, перепрыгивая через ступеньки. 
 * Лестница имеет определенное количество ступенек N. 
 * Заяц может одним прыжком преодолеть не более К ступенек. 
 * Для разнообразия зайчик пытается каждый раз найти новый путь к вершине лестницы. 
 * Директору любопытно, сколько различных способов есть у зайца добраться до вершины лестницы при заданных значениях K и N. 
 * Помогите директору написать программу, которая поможет вычислить это количество. 
 * Например, если K=3 и N=4, то существуют следующие маршруты: 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1.
 * Т.е. при данных значениях у зайца всего 7 различных маршрутов добраться до вершины лестницы.
 * 
 * В единственной строке входного файла INPUT.TXT записаны два натуральных числа K и N (1 ≤ K ≤ N ≤ 300). 
 * К - максимальное количество ступенек, которое может преодолеть заяц одним прыжком, N – общее число ступенек лестницы.
 * 
 * В единственную строку выходного файла OUTPUT.TXT нужно вывести количество возможных вариантов различных маршрутов 
 * зайца на верхнюю ступеньку лестницы без ведущих нулей.
 */

public class ACMP011 {
	
	public static void main(String...a){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int K = sc.nextInt();
        int N = sc.nextInt();
        pw.print(check(K,N));
        pw.flush();
    }
	
	static BigInteger check(int K, int N){
		BigInteger[] result = new BigInteger[N+1];
		result[0] = BigInteger.valueOf(1);
		for (int i = 1; i < N+1; i++){
			result[i] = BigInteger.valueOf(0);
			int j = 1;
			while (j <= K && j <= i){
				result[i] = result[i].add(result[i-j]);
				j++;
			}
		}
		return result[N];
	}
}
