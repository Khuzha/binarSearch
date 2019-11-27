package com.company;
import java.util.Arrays;
import java.util.Scanner;
import com.company.functions;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Введите длину массива от 3 до 100.000.000");
        int length = keyboard.nextInt();

        if (length < 3 || length > 100000000) {
            System.out.println("Вы ввели недопустимое значение");
            return;
        }

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                array[i] = array[i-1] + 1;
            }
        }
        System.out.println(Arrays.toString(array));

        System.out.println(String.format("Какое значение нужно найти? Учтите, что принимаются только натуральные числа от 0 до %d", length - 1));
        int value = keyboard.nextInt();

        if (value < 0 || value > length -1) {
            System.out.println("Вы ввели недопустимое значение");
            return;
        }


        boolean ready = false;
        while (ready != true) {
            int lenOfArr = array.length;
            int midOfArr = Math.round(lenOfArr / 2);

            if (value > array[midOfArr]) {
                System.out.println(midOfArr);
                array = functions.sliceArr(array, midOfArr, lenOfArr);
            } else if (value == array[midOfArr]) {
                System.out.println(String.format("Succes! %d", array[midOfArr]));
                ready = true;
                return;
            } else {
                array = functions.sliceArr(array, 0, midOfArr);
            }

            System.out.println(Arrays.toString(array));

            if (array.length == 1) {
                System.out.println(String.format("Succes! %d", array[0]));
                ready = true;
                return;
            }
        }

    }

}
