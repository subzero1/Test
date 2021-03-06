package datastructure.xbackup;

import java.util.Arrays;

public class Sort0520 {
    //Binsearch non-recursion
    public static int halfSort1(int r[], int left, int right, int key) {
        int center = -1;
        while (left<right){
            center=(left+right)/2;
            if (r[center]<key)left=center+1;
            else if (r[center]>key)right=center-1;
            else return center;
        }
        return center;
    }

    //Binsearch recursion
    public static int halfSort2(int r[], int left, int right, int key) {
        int center = -1;
        if (r[center]<key)return halfSort2(r,center+1,right,key);
        else if (r[center]>key)return halfSort2(r,left,center-1,key);
        return center;
    }

    //Direct Insertion Sort
    public static void insert(int r[], int n) {
        for (int i=1;i<=n-1;i++){
            int temp=r[i];
            int j=i-1;
            for (;j>=0&&r[j]>temp;j--)
                r[j+1]=r[j];
            r[j+1]=temp;
        }
    }

    //Shell Sort
    public static void shell(int r[], int n) {
        for (int d=n/2;d>=1;d=d/2){

            for (int i=d;i<=n-1;i++){
                int temp=r[i];
                int j=i-d;
                for (;j>=0&&r[j]>temp;j=j-d)
                    r[j+d]=r[j];
                r[j+d]=temp;
            }

        }
    }

    //Bubble Sort
    public static void bubble(int r[], int n) {
        for (int i=0;i<=n-2;i++){
            for (int j=0;i<=n-2-i;j++){
                if (r[j]>r[j+1]){
                    r[j]=r[j]^r[j+1];
                    r[j+1]=r[j]^r[j+1];
                    r[j]=r[j]^r[j+1];
                }
            }
        }
    }

    //Quicksort
    public static void quick(int r[], int left, int right) {
        int i=left;
        int j=right;
        if (i>j)return;
        int base=r[i];
        while (i<j){
            while (i<j&&base<=r[j])j--;
            if (base>r[j]){
                r[i]=r[i]^r[j];
                r[j]=r[i]^r[j];
                r[i]=r[i]^r[j];
            }
            while (i<j&&base>=r[i])i++;
            if (base<r[j]){
                r[i]=r[i]^r[j];
                r[j]=r[i]^r[j];
                r[i]=r[i]^r[j];
            }
        }
        quick(r,left,i-1);
        quick(r,i+1,right);
    }

    //Selection Sort
    public static void select(int r[], int n) {

    }

    //Heap Sort
    public static void heap(int r[], int n) {

    }

    public static void heap_x(int r[], int start, int end) {

    }
    public static int[] mSort(int[] nums, int l, int h) {
        return nums;
    }

    public static void main(String[] args) {
        int r[] = {1, 3, 4, 5, 6, 7, 9, 10, 14, 16};
        int n = r.length;
//                int index1=halfSort1(r,0,n-1,10);
//                int index2=halfSort2(r,0,n-1,10);
//                System.out.println("index:"+index1+"#index2:"+index2);
        r = new int[]{1, 14, 16, 14, 16, 14,3, 4, 5, 6, 7, 9, 10,  16};
//        r = new int[]{1, 3, 4, 5, 6};
        n = r.length;
        System.out.println(Arrays.toString(r));
        //        insert(r, n );
        //        shell(r,n);
        //        bubble(r,n);
        //        quick(r,0,n-1);
        //        select(r,n);
//        heap(r, n);
//        int s[]=mSort(r,0,n-1);
//        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(r));
    }
}
