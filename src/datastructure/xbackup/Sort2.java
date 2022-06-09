package datastructure.xbackup;

import java.util.Arrays;

public class Sort2 {
    /**
     * 插入-冒泡排序算法（自创）
     * @param r
     * @param n
     */
    public static void insert_bubble(int []r,int n){
        for (int i=1;i<=n-1;i++){
            for (int j=0;j<i;j++){
                if (r[j]>r[i]){
                    int temp=r[i];
                    r[i]=r[j];
                    r[j]=temp;
                    continue;
                }
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

 public static void insert(int[] r, int n){
        for (int i=1;i<=n-1;i++){
            int current=r[i];
            int j=0;
            for (j=i-1;j >= 0&& r[j]>current ;j--)
                r[j+1]=r[j];
            r[j+1]=current;
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
 }

    public static void shell(int []r,int n){
        for (int d=n/2;d>=1;d=d/2){

            for (int i=d;i<=n-1;i++){
                int current=r[i];
                int j=0;
                for (j=i-d;j >= 0&& r[j]>current ;j=j-d)
                    r[j+d]=r[j];
                r[j+d]=current;
                System.out.println("第" + i + "趟：" + Arrays.toString(r));
            }

        }
    }

    public static void shell_bubble(int []r,int n){
        for (int d=n/2;d>=1;d=d/2){

            for (int i=d;i<=n-1;i++){
                for (int j=i-d;j<i;j=j+d){
                    if (r[i]<r[j]&&r[i]>=r[j-d]){
                        int temp=r[i];
                        r[i]=r[j];
                        r[j]=temp;
                        continue;
                    }
                }
                System.out.println("第" + i + "趟：" + Arrays.toString(r));
            }



        }
    }

    public static void bubble(int r[], int n){
        for (int i=0;i<=n-2;i++){
            for (int j=0;j<=n-2-i;j++){
                if (r[j]>r[j+1]){
//                    int temp = r[j];
//                    r[j]=r[j+1];
//                    r[j+1]=temp;
                    //异或运算交换二者的值
                    r[j]=r[j]^r[j+1];
                    r[j+1]=r[j]^r[j+1];
                    r[j]=r[j]^r[j+1];
                }
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }


    public static void quick(int r[], int left, int right){
        int i=left;
        int j=right;
        while (i<j){
            while (i<j&&r[i]<=r[j]) j--;//右侧扫描
            if (r[i]>r[j]){
                int t=r[i];
                r[i]=r[j];
                r[j]=t;
            }
            while (i<j&&r[i]<=r[j]) i++;//左侧扫描
            if (r[i]<r[i]){
                int t=r[i];
                r[i]=r[j];
                r[j]=t;
            }
        }
        System.out.println("左" + left + "趟：右"+right +"i的值："+i+ Arrays.toString(r));
        quick(r,left,i-1);
        quick(r,i+1,right);
    }

    //选择排序
    public static void sel(int r[], int n){
        for (int i=0;i<=n-1;i++){
            int minValue=r[i];
            int minIndex=i;
            for (int j=i+1;j<=n-1;j++){
             if (r[j]<r[minValue]){
                 minIndex=j;
             }
             if (i!=minIndex){
                 int temp=r[i];
                 r[i]=r[minIndex];
                 r[minIndex]=temp;
             }
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }
    //堆排序


    public static  void main(String[] args) {
        int r[] = {5,4,3,2,1,3,2,1};
        int n = r.length;
        sel(r, n);
    }
}
