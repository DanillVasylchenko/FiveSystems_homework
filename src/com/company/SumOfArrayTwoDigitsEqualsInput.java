package com.company;

public class SumOfArrayTwoDigitsEqualsInput {
    public static void get(int[] array, int num){
        if (array.length < 2){
            System.out.println("Array length must be >= 2");
        }
        else {
            int index=1;
            for (int j = 0; j < array.length; j++) {
                for (int i = index; i < array.length; i++) {
                    if (array[j] + array[i] == num) {
                        System.out.println(array[j] + "[" + j + "]" + " + " + array[i] + "[" + i + "]" + " = " + num);
                    }
                }
                index++;
            }
        }
    }

    public static void main(String[] args) {
        SumOfArrayTwoDigitsEqualsInput.get(new int[]{-1,-2,0,1,2,3,4,5,6,7}, 20);
    }
}