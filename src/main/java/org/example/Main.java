package org.example;

import org.example.Integer.IntegerList;
import org.example.Integer.IntegerListImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IntegerListImpl integerList = new IntegerListImpl();

        integerList.addInteger(1);
        integerList.addInteger(2);
        integerList.addInteger(3);
        integerList.addInteger(4);
        integerList.addInteger(5);
        integerList.addInteger(5, 6);
        integerList.addInteger(6, 7);
        integerList.addInteger(7, 8);

        integerList.display();
        System.out.println();
        Integer[] arr = integerList.generateRandomArray(10);
        integerList.printingAnArray(arr);

        measuringTheSortingMethod();
        binarySearchMethod();

    }

    private static void measuringTheSortingMethod() {
        IntegerList integerList = new IntegerListImpl();

        Integer[] arr = integerList.generateRandomArray(10000);
        Integer[] arrOne = Arrays.copyOf(arr, arr.length);
        Integer[] arrTwo = Arrays.copyOf(arr, arr.length);
        Integer[] arrThree = Arrays.copyOf(arr, arr.length);

        long start;
        start = System.currentTimeMillis();
        integerList.sortBubble(arrOne);
        long sortBubble = System.currentTimeMillis() - start;
        System.out.println("Время, сортировки пузырьком: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        integerList.sortSelection(arrTwo);
        long sortSelection = System.currentTimeMillis() - start;
        System.out.println("Время, сортировки выбором: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        integerList.sortInsertion(arrThree);
        long sortInsertion = System.currentTimeMillis() - start;
        System.out.println("Время, сортировки вставкой: " + (System.currentTimeMillis() - start));


        if (sortBubble == sortSelection) {
            System.out.println("Сортировка пузырьком и сортировка выбором самые быстрые из всех сортировок!");
        } else if (sortBubble == sortInsertion) {
            System.out.println("Сортировка пузырьком и сортировка вставкой самые быстрые из всех сортировок!");
        } else if (sortSelection == sortInsertion) {
            System.out.println("Сортировка выбором и сортировка вставкой самые быстрые из всех сортировок!");
        } else if (sortBubble == sortSelection && sortSelection == sortInsertion) {
            System.out.println("Сортировка пузырьком, сортировка выбором и сортировка вставкой самые быстрые из всех сортировок!");
        } else if (sortBubble < sortSelection || sortBubble < sortInsertion) {
            System.out.println("Сортировка пузырьком самая быстрая из всех сортировок!");
        } else if (sortSelection < sortBubble || sortSelection < sortInsertion) {
            System.out.println("Сортировка выбором самая быстрая из всех сортировок!");
        } else if (sortInsertion < sortBubble || sortInsertion < sortSelection) {
            System.out.println("Сортировка вставкой самая быстрая из всех сортировок!");
        }
    }

    private static void binarySearchMethod() {
        IntegerList integerList = new IntegerListImpl();

        integerList.addInteger(1);
        integerList.addInteger(2);
        integerList.addInteger(3);
        integerList.addInteger(4);
        integerList.addInteger(5);

        System.out.println(integerList.containsInteger(1));
        System.out.println(integerList.containsInteger(2));
        System.out.println(integerList.containsInteger(3));
        System.out.println(integerList.containsInteger(52));
        System.out.println(integerList.containsInteger(133));
    }

}