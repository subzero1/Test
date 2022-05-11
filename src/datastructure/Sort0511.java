package datastructure;

import java.util.Arrays;

public class Sort0511 {
    //Binsearch non-recursion
    public static int halfSort1(int r[], int left, int right, int key) {
        int center = -1;
        return center;
    }

    //Binsearch recursion
    public static int halfSort2(int r[], int left, int right, int key) {
        int center = -1;
        return center;
    }

    //Direct Insertion Sort
    public static void insert(int r[], int n) {

    }

    //Shell Sort
    public static void shell(int r[], int n) {

    }

    //Bubble Sort
    public static void bubble(int r[], int n) {

    }

    //Quicksort
    public static void quick(int r[], int left, int right) {

    }

    //Selection Sort
    public static void select(int r[], int n) {

    }

    //Heap Sort
    public static void heap(int r[], int n) {

    }

    public static void heap_x(int r[], int start, int end) {

    }

    public static void main(String[] args) {
        int r[] = {1, 3, 4, 5, 6, 7, 9, 10, 14, 16};
        int n = r.length;
        //        int index1=halfSort1(r,0,n-1,10);
        //        int index2=halfSort2(r,0,n-1,10);
        //        System.out.println("index:"+index1+"#index2:"+index2);
        //        r = new int[]{1, 3, 4, 5, 6, 7, 9, 10, 14, 16, 14, 16, 14, 16};
        r = new int[]{1, 3, 4, 5, 6};
        n = r.length;
        //        insert(r, n );
        //        shell(r,n);
        //        bubble(r,n);
        //        quick(r,0,n-1);
        //        select(r,n);
//        heap(r, n);
        System.out.println(Arrays.toString(r));
    }
}
