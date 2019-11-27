package com.company;

public class functions {
    public static int[] sliceArr (int[] arr, int start, int end) {
        int[] resArr = new int[end - start];

        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = arr[start + i];
        }

        return resArr;
    }
}
