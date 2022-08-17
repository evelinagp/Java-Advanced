package Generics8.Generics8_JarOfTLab01;

import Generics8.GenericArrayCreatorLab2.ArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer []array = ArrayCreator.create(13, 13);
        String [] strings = ArrayCreator.create(String.class, 13, "Java");
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }

    public static void print(Object num) {
        System.out.println(num);
    }
}

