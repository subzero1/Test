package datastructure.his;

import java.util.Arrays;

public class Sort1 {
    public static void insert(int[] r, int n) {
        for (int i = 1; i <= n - 1; i++) {
            int temp = r[i];
            int j;
            for (j = i - 1; j >= 0 && r[j] > temp; j--) {
                r[j + 1] = r[j];
            }
            r[j + 1] = temp;
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }


    /**
     * 插入排序-希爾排序
     *
     * @param r 數組
     * @param n 數組長度
     */
    public static void shell(int r[], int n) {
        for (int d = n / 2; d >= 1; d = d / 2) {


            for (int i = d; i <= n - 1; i++) {
                int temp = r[i];
                int j;
                for (j = i - d; j >= 0 && r[j] > temp; j = j - d) {
                    r[j + d] = r[j];
                }
                r[j + d] = temp;
            }
            System.out.println("第" + d + "趟：" + Arrays.toString(r));
        }
    }


    /**
     * 交換排序-起泡排序
     * 左邊無序區 右邊有序區
     */
    public static void bubble(int r[], int n) {
        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= n - i - 2; j++) {
                if (r[j] > r[j + 1]) {
                    int temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

    /**
     * 交換排序-快速排序
     *
     * @param r     數組
     * @param first 數組長度
     */
    public static void Quick_Sort(int r[], int first, int end) {
        if (first > end)
            return;
        int i = first;
        int j = end;
        //一次劃分，循環直到i=j
        while (i != j) {
            while (r[i] <= r[j] && j > i) j--; //右側掃描，當數組當前值大於基準值,下標左移
            if (j > i) {
                int t = r[i];
                r[i] = r[j];
                r[j] = t;
            }
            while (r[i] <= r[j] && j > i) i++;//左側掃描，當數組當前值小於基準值,下標右移
            //交換ij的值
            if (j > i) {
                int t = r[i];
                r[i] = r[j];
                r[j] = t;
            }
            System.out.println("i:" + i + "j：" + j + "交換#" + Arrays.toString(r));
        }
        System.out.println("第=========================趟：" + Arrays.toString(r));
        Quick_Sort(r, first, i - 1);
        Quick_Sort(r, i + 1, end);
    }

    public static void select(int[] r, int n) {
        for (int i = 0; i <= n - 2; i++) {
            int index = i;
            for (int j = i; j <= n - 2; j++) {
                if (r[index] > r[j + 1])
                    index = j + 1;
            }
            if (i != index) {
                int temp = r[i];
                r[i] = r[index];
                r[index] = temp;
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

    public static void sel(int r[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i; j < n - 1; j++) {
                //記住最小值的下標
                if (r[maxIndex] > r[j + 1]) {
                    maxIndex = j + 1;
                }
            }
            //如果最大值不等於當前值額下標，則交換兩者的值
            if (i != maxIndex) {
                int temp = r[i];
                r[i] = r[maxIndex];
                r[maxIndex] = temp;
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

    /**
     * 選擇排序-堆排序
     * 左邊無序區 右邊有序區
     * @param r
     * @param n
     */
    public  static  void heapSort(int r[],int n){
        for (int i=n/2-1;i>=0;i--){
            sift(r,i,n);
        }
        System.out.println("初建堆" + Arrays.toString(r));
        for (int i=0;i<n-1;i++){
            int temp=r[0];
            r[0]=r[n-i-1];
            r[n-i-1]=temp;
            sift(r,0,n-i-1);
            System.out.println("重建堆" +i+":"+ Arrays.toString(r));
        }
    }
    /**
     * 選擇排序-堆排序
     * @param r 數組
     * @param k 堆排序第一個元素，可能下標為零的也可能是無序區最大的非葉子節點
     * @param m 無序區長度
     */
    public static void sift(int r[],int k,int m) {
        int i=k;
        int j=2*i+1;
        while (j<m-1){
            if (j<m&&r[j]<r[j+1])j++;
            if (r[i]>r[j])break;
            else {
                int temp=r[i];
                r[i]=r[j];
                r[j]=temp;
                i=j;
                j=2*i+1;
            }
        }
    }

    public static void main(String[] args) {
        int r[] = {1, 5, 2, 4, 3,6,10};
        int n = r.length;
//        Quick_Sort(r, 0,n-1);
        heapSort(r, n);
    }


}
