package com.telizhenko.sort.utils;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 13:09
 */
public class SwapUtil {

    public static void swap(final int[] arr, final int pos1, final int pos2) {
        final int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void swap(int[] arr1, int[] arr2) {
        int[] t = arr1.clone();
        System.arraycopy(arr2, 0, arr1, 0, t.length);
        System.arraycopy(t, 0, arr2, 0, t.length);
    }

}
