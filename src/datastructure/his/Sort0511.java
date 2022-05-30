package datastructure.his;

import java.util.Arrays;

public class Sort0511 {
    //Binsearch non-recursion
    public static int halfSort1(int r[], int left, int right, int key) {
        int center = -1;
        while (left < right) {
            center = (left + right) / 2;
            if (r[center] < key) left = center + 1;
            else if (r[center] > key) right = center - 1;
            else return center;
        }
        return center;
    }

    //Binsearch recursion
    public static int halfSort2(int r[], int left, int right, int key) {
        int center = -1;
        center = (left + right) / 2;
        if (r[center] < key) return halfSort2(r, center + 1, right, key);
        else if (r[center] < key) return halfSort2(r, left, center - 1, key);
        return center;
    }

    //Direct Insertion Sort
    public static void insert(int r[], int n) {
        for (int i = 1; i <= n - 1; i++) {
            int temp = r[i];
            int j = i - 1;
            for (; j >= 0 && r[j] > temp; j--)
                r[j + 1] = r[j];
            r[j + 1] = temp;
        }
    }

    //Shell Sort
    public static void shell(int r[], int n) {
        for (int d = n / 2; d >= 1; d = d / 2) {

            for (int i = d; i <= n - 1; i++) {
                int temp = r[i];
                int j = i - d;
                for (; j >= 0 && r[j] > temp; j = j - d)
                    r[j + d] = r[j];
                r[j + d] = temp;
            }

        }
    }

    //Bubble Sort
    public static void bubble(int r[], int n) {
        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= n - 2 - i; j++) {
                if (r[j] > r[j + 1]) {
                    r[j] = r[j] ^ r[j + 1];
                    r[j + 1] = r[j] ^ r[j + 1];
                    r[j] = r[j] ^ r[j + 1];
                }
            }
        }
    }

    //Quicksort
    public static void quick(int r[], int left, int right) {
        int i = left;
        int j = right;
        if (i > j) return;
        int base = r[i];
        while (i < j) {
            while (i < j && base <= r[j]) j--;
            if (base > r[j]) {
                r[i] = r[i] ^ r[j];
                r[j] = r[i] ^ r[j];
                r[i] = r[i] ^ r[j];
            }
            while (i < j && r[i] <= base) i++;
            if (base < r[i]) {
                r[i] = r[i] ^ r[j];
                r[j] = r[i] ^ r[j];
                r[i] = r[i] ^ r[j];
            }
        }
        quick(r, i + 1, right);
        quick(r, left, i - 1);
    }

    //Selection Sort
    public static void select(int r[], int n) {
        for (int i = 0; i <= n - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= n - 2; j++) {
                if (r[j] < r[minIndex]) minIndex = j;
            }
            if (i != minIndex) {
                r[i] = r[i] ^ r[minIndex];
                r[minIndex] = r[i] ^ r[minIndex];
                r[i] = r[i] ^ r[minIndex];
            }
        }
    }

    //Heap Sort
    public static void heap(int r[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap_x(r, i, n);
        }
        System.out.println("-1#" + Arrays.toString(r));
        for (int i = 0; i <= n - 2; i++) {
            r[0] = r[0] ^ r[n - 1 - i];
            r[n - 1 - i] = r[0] ^ r[n - 1 - i];
            r[0] = r[0] ^ r[n - 1 - i];
            System.out.println(i + "#" + Arrays.toString(r));
            heap_x(r, 0, n - 1 - i);
        }
    }

    public static void heap_x(int r[], int start, int end) {
        int i = start;
        int j = 2 * i + 1;
        while (j <= end - 1) {
            if (j < end - 1 && r[j] < r[j + 1]) j++;
            else if (r[i] >= r[j]) break;
            else {
                r[i] = r[i] ^ r[j];
                r[j] = r[i] ^ r[j];
                r[i] = r[i] ^ r[j];
                i = j;
                j = 2 * i + 1;
            }
        }
    }

    /**
     * aja subArray ones Merge
     *
     * @param r  in sortting
     * @param r1 sorted
     * @param s  start subArray
     * @param m  start next subArray
     * @param t  end subArray
     */
    public static void merge(int r[], int r1[], int s, int m, int t) {
        int i = s;
        int j = m + 1;
        int k = s;
        while (i <= m && j <= t) {
            if (r[i] <= r[j]) r1[k++] = r[i++];
            else r1[k++] = r[j++];
        }
        if (i <= m) {
            while (i <= m) r1[k++] = r[i++];
        } else {
            while (j <= t) r1[k++] = r[j++];
        }
    }

    /**
     * @param r  待排序
     * @param r1 有序数组
     * @param n  数组长度
     * @param h  一次划分有序子序列长度
     */
    public static void mergePass(int r[], int r1[], int n, int h) {
        int i = 0;
        int s = 0;
        int m = 0;
        int t = 0;
        while (i <= n - 2 * h) {
            s = i;
            m = i + h - 1;
            t = i + 2 * h - 1;
            merge(r, r1, s, m, t);
            i += 2 * h;
        }
        //待归并序列中有一个小鱼h
        if (i < n - h) {
            s = i;
            m = i + h - 1;
            t = n;
            merge(r, r1, s, m, t);
        }
        //待归并序列只剩一个序列
        else {
            for (int k = i; k <= n - 1; k++) {
                r1[k] = r[k];
            }
        }
    }

    /**
     * @param r  待排序数组
     * @param r1 有序数组
     * @param n  数组长度
     */
    public static void mergeSort1(int r[], int r1[], int n) {
        int h = 1;
        while (h < n) {
            mergePass(r, r1, n, h);
            h = 2 * h;
            mergePass(r, r1, n, h);
            h = 2 * h;
        }
    }

    /**
     * @param r  待排序数组
     * @param r1 有序数组
     * @param n  数组长度
     */
    public static void mergeSort2(int r[], int r1[], int s, int t) {
        if (s == t) r1[s] = r[t];
        else {
            int m = (s + t) / 2;
            mergeSort2(r, r1, s, m);//归并左半区
            mergeSort2(r, r1, m + 1, t);//归并右半区
            merge(r1, r, s, m, t);//归并上述排序结果
            System.out.println("------");
        }
    }

    public static int[] mSort(int[] nums, int l, int h) {
        //剩一个元素直接返回
        if (l == h) return new int[]{nums[l]};
        //拆分
        int mid = (h + l) / 2;
        int[] leftArr = mSort(nums, l, mid); //左有序数组
        int[] rightArr = mSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        //合并
        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        //合并收尾工作
        while (i < leftArr.length) newNum[m++] = leftArr[i++];
        while (j < rightArr.length) newNum[m++] = rightArr[j++];
        return newNum;
    }

    public static void main(String[] args) {
        int r[] = null;
        int n = 0;
//        r = new int[]{1, 3, 4, 5, 6, 7, 9, 10, 14, 16};
//        int n = r.length;
//        int index1 = halfSort1(r, 0, n - 1, 10);
//        int index2 = halfSort2(r, 0, n - 1, 10);
//        System.out.println("index:" + index1 + "#index2:" + index2);
        //        r = new int[]{ 9, 10, 14, 16, 14, 16, 14, 16,1, 3, 4, 5, 6, 7};
//        r = new int[]{14, 16, 5, 6, 1, 3, 4};
        r = new int[]{5, 16, 14};
//        r = new int[]{14, 3, 4, 5, 6, 7, 9, 10,16, 14, 16, 1,  14, 16};
        n = r.length;
//        insert(r, n);
//                shell(r,n);
//                bubble(r,n);
//                quick(r,0,n-1);
//                select(r,n);
        System.out.println(Arrays.toString(r));
//        heap(r, n);
        int r1[] = mSort(r, 0, n - 1);
        System.out.println(Arrays.toString(r1));
    }
}
