package datastructure;

import java.util.Arrays;

public class Sort0522 {
    //Binsearch non-recursion
    public static int halfSort1(int r[], int left, int right, int key) {
        int center = -1;
        while (left<right){
            center=(left+right)/2;
            if (r[center]<key)left=center+1;
            else if (r[center]>key)right=center-1;
            else return  center;
        }
        return center;
    }

    //Binsearch recursion
    public static int halfSort2(int r[], int left, int right, int key) {
        int center = -1;
        center=(left+right)/2;
        if (r[center]<key)return halfSort2(r,center+1,right,key);
        else if(r[center]>key)return halfSort2(r,left,center-1,key);
        return center;
    }

    //Direct Insertion Sort
    public static void insert(int r[], int n) {
        for (int i=0;i<=n-1;i++){
            int temp=r[i];
            int j=i-1;
            for (;j>=0&&r[j]>temp;j--)r[j+1]=r[j];
            r[j+1]=temp;
        }
    }

    //Shell Sort
    public static void shell(int r[], int n) {
        for (int d=n/2;d>=1;d=d/2){

            for (int i=d;i<=n-1;i++){
                int temp=r[i];
                int j=i-d;
                for (;j>=0&&r[j]>temp;j=j-d)r[d+1]=r[j];
                r[d+1]=temp;
            }

        }
    }

    //Bubble Sort
    public static void bubble(int r[], int n) {
        for (int i=0;i<=n-2;i++){
            for (int j=0;j<=n-2-i;j++){
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
            if (base<r[i]){
                r[i]=r[i]^r[j];
                r[j]=r[i]^r[j];
                r[i]=r[i]^r[j];
            }
        }
        quick(r,i+1,right);
        quick(r,left,i-1);
    }

    //Selection Sort
    public static void select(int r[], int n) {
        for (int i=0;i<=n-1;i++){
            int minIndex=i;
            for (int j=i+1;j<=n-1;j++){
                if (r[minIndex]>r[j])minIndex=j;
            }
            if (i!=minIndex){
                r[i]=r[i]^r[minIndex];
                r[minIndex]=r[i]^r[minIndex];
                r[i]=r[i]^r[minIndex];
            }
        }
    }

    //Heap Sort
    public static void heap(int r[], int n) {
        for (int i=n/2-1;i>=0;i--){
            heap_x(r,i,n);
        }
        for (int i=0;i<=n-2;i++){
            r[0]=r[0]^r[n-1-i];
            r[n-1-i]=r[0]^r[n-1-i];
            r[0]=r[0]^r[n-1-i];
            heap_x(r,i,n-1-i);
        }
    }

    public static void heap_x(int r[], int start, int end) {
        int i=start;
        int j=2*i+1;
        while (j<=end-1){
            if (r[j]<r[j+1])j++;
            else if (r[0]>=r[j])break;
            else {
                r[i]=r[i]^r[j];
                r[j]=r[i]^r[j];
                r[i]=r[i]^r[j];
                i=j;
                j=2*i+1;
            }
        }
    }
    public static int[] mSort(int[] nums, int l, int h) {
        if (l==h)return new int[]{nums[l]};
        int m=(l+h)/2;
        int[] lArray=mSort(nums,l,m);
        int[] hArray=mSort(nums,m+1,h);
        int[] resultArray=new int[lArray.length+hArray.length];
        int i=0,j=0,k=0;
        while (i<lArray.length&&j<hArray.length)
            resultArray[k++]=lArray[i]<=hArray[j]?lArray[i++]:hArray[j++];
        while (i<lArray.length)
            resultArray[k++]=lArray[i++];
        while (j<hArray.length)
            resultArray[k++]=hArray[j++];
        return resultArray;
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
