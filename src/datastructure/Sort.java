package datastructure;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int r[] = {6,	1,	2,	7,	9,	3,	4,	5,	10,	8};
        int n = r.length;
//        Quick_Sort(r,0,9);
        heapSort(r,10);
    }


    /**
     * 插入排序-簡單插入排序
     * 左邊有序區 右邊無序區
     * @param r 數組
     * @param n 數組長度
     */
    public static void insert(int r[],int n){
        for (int i=1;i<n;i++){
            for (int j=i-1;j>=0;j--){
                if (r[j]>r[j+1]){
                    int temp = 0;
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

    /**
     * 插入排序-希爾排序
     * @param r 數組
     * @param n 數組長度
     */
    public static void shell(int r[],int n){
        for(int d=n/2;d>0;d=d/2){
            //内循环是标准的插入排序
            for (int i=d;i<n;i++){
                for (int j=i-d;j>=0;j=j-d){
                    if (r[j]>r[j+1]){
                        int temp = 0;
                        temp = r[j];
                        r[j] = r[j + 1];
                        r[j + 1] = temp;
                    }
                }
                System.out.println("第" + i + "趟：" + Arrays.toString(r));
            }
        }

    }

    /**
     * 交換排序-起泡排序
     * 左邊無序區 右邊有序區
     */
    public static void bubble(int r[],int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (r[j] > r[j + 1]) {
                    int temp = 0;
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

    /**
     * 交換排序-快速排序
     * @param r 數組
     * @param begin 數組長度
     */
    public  static  void Quick_Sort (int r[],int begin,int end){
        if(begin > end)
            return;
        int base = r[begin];
        int i = begin;
        int j = end;
        //一次劃分，循環直到i=j
        while(i != j){
            while(base<=r[j]  && j > i)//右側掃描，當數組當前值大於基準值,下標左移
                j--;
            while(base>=r[i] && j > i)//左側掃描，當數組當前值小於基準值,下標右移
                i++;
            //交換ij的值
            if(j > i){
                int t = r[i];
                r[i] = r[j];
                r[j] = t;
            }
            System.out.println("i:" + i + "j："+j+"交換#"+  Arrays.toString(r));
        }
        r[begin] = r[i];
        r[i] = base;
        Quick_Sort(r, begin, i-1);
        Quick_Sort(r, i+1, end);
    }





        /**
         * 選擇排序-簡單選擇排序
         * 左邊有序區 右邊無序區
         * @param r
         * @param n
         */
    public static void sel(int r[],int n) {
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
                int temp = 0;
                temp = r[i];
                r[i] = r[maxIndex];
                r[maxIndex] = temp;
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

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
     * @param k 數組長度
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

}
