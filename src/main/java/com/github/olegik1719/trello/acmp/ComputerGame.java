package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * https://acmp.ru/index.asp?main=task&id_task=29
 * Во многих старых играх с двумерной графикой можно столкнуться с подобной ситуацией.
 * Какой-нибудь герой прыгает по платформам (или островкам), которые висят в воздухе.
 * Он должен перебраться от одного края экрана до другого. При этом при прыжке с одной платформы на соседнюю,
 * у героя уходит |y2-y1| единиц энергии, где y1 и y2 – высоты, на которых расположены эти платформы.
 * Кроме того, у героя есть суперприем, который позволяет перескочить через платформу,
 * но на это затрачивается 3*|y3-y1| единиц энергии.
 * Конечно же, энергию следует расходовать максимально экономно.
 *
 *  В первой строке входного файла INPUT.TXT записано количество платформ n (1 ≤ n ≤ 30000).
 * Вторая строка содержит n натуральных чисел, не превосходящих 30000 – высоты, на которых располагаются платформы.
 *
 * В выходной файл OUTPUT.TXT запишите единственное число – минимальное количество энергии,
 * которую должен потратить игрок на преодоление платформ
 * (конечно же в предположении, что cheat-коды использовать нельзя).
 */

public class ComputerGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        int size = scanner.nextInt();
        int[] platforms = new int[size];
        for (int i = 0; i < size; i++) {
            platforms[i] = scanner.nextInt();
        }
        printWriter.printf("%s%n", minimalEnergy(platforms));
        printWriter.flush();
    }

    public static int minimalEnergy(int[] platforms){
        int size = platforms.length;
        if (size <2) return 0;
        //int
        int needEnergyToPrevPrevious = 0;
        int needEnergyToPrevious = abs(platforms[1] - platforms[0]);
        int needEnergyCurrent=needEnergyToPrevious;

        for (int i = 2; i < size; i++) {

            int needEnergyViaPrevPrev = needEnergyToPrevPrevious + 3 * abs(platforms[i]-platforms[i-2]);
            int needEnergyViaPrev = needEnergyToPrevious +  abs(platforms[i]-platforms[i-1]);
            needEnergyCurrent = min(needEnergyViaPrevPrev,needEnergyViaPrev);
            needEnergyToPrevPrevious = needEnergyToPrevious;
            needEnergyToPrevious = needEnergyCurrent;
        }
        return needEnergyCurrent;
    }
}