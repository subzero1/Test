package datastructure.his;

import java.util.Arrays;

public class Sort3 {
    public  void insert(int r[],int n){
        for (int i=1;i<=n-1;i++){
            int temp=r[i];
            int j=i-1;
            for (;j>=0&&r[j]>temp;j--){
                r[j+1]=r[j];
            }
            r[j+1]=temp;
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }
    public  void shell(int r[], int n){

        for (int d=n/2;d>=1;d=d/2){


            for (int i=d;i<=n-1;i++){
                int temp=r[i];
                int j=i-d;
                for (;j>=0&&r[j]>temp;j=j-d){
                    r[j+d]=r[j];
                }
                r[j+d]=temp;
                System.out.println("第" + i + "趟：" + Arrays.toString(r));
            }


        }
    }
    public void bubble(int r[],int n){
        for (int i=0;i<=n-2;i++){
            for (int j=0;j<=n-2-i;j++){
                if (r[j]>r[j+1]){
                    r[j]=r[j]^r[j+1];
                    r[j+1]=r[j]^r[j+1];
                    r[j]=r[j]^r[j+1];
                }
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }
    public void quick(int r[],int left,int right){
        int i=left;
        int j=right;
        if (i>j)
            return;
        int base=r[i];
        while (i<j){
            while (i<j&&base<=r[j])j--;
            if (base>r[j]){
                int temp=r[i];
                r[i]=r[j];
                r[j]=temp;
            }
            while (i<j&&r[i]<=base)i++;
            if (base<r[i]){
                int temp=r[i];
                r[i]=r[j];
                r[j]=temp;
            }
        }
        System.out.println("i=" + i + "#base="+base + Arrays.toString(r));
        quick(r,i+1,right);
        quick(r,left,i-1);
    }
    public void select(int r[],int n){
        for (int i=0;i<=n-2;i++){
            int minIndex=i;
            int minValue=r[i];
            for (int j=i;j<=n-1;j++){
                if (r[j]<minValue){
                    minIndex=j;
                    minValue=r[j];
                }
            }
            if (i!=minIndex){
                int temp=r[i];
                r[i]=r[minIndex];
                r[minIndex]=temp;
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

    public void heap_x(int r[],int start,int end){
        int i=start;//根j节点
        int j=2*i+1;//左节点
        while (j<end-1){
            if (j<end&&r[j]<r[j+1])j++;
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
    public void heap(int r[],int n){
        for (int i=n/2-1;i>=0;i--){
            heap_x(r,i,n-1);
        }
        for (int i=0;i<=n-2;i++){
            int temp=r[0];
            r[0]=r[n-1-i];
            r[n-1-i]=temp;
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
            heap_x(r,0,n-1-i);
        }
    }
    //折半查找非递归
    public int halfsearch1(int r[],int n,int key){
        int low=0;
        int high=n-1;
        int center=-1;
        while (low<=high) {
             center=(low+high)/2;
            if (key>r[center])low=center+1;
            else if (key<r[center])high=center-1;
            else
                return center;
        }
        return -1;
    }

    public int halfsearch2(int r[],int low,int high,int key){
        int center=-1;
        while (low<=high) {
            center=(low+high)/2;
            if (key>r[center])
                return halfsearch2(r,center+1,high,key) ;
             else if (key<r[center])
                return halfsearch2(r,low,center-1,key) ;
             else
                 return center;
        }
        return -1;
    }
    //折半查找递归
    public static void main(String[] args) {
        Sort3 sort3=new Sort3();
        int r[] = {5,4,3,2,1,3,2,1};
        r = new int[]{1, 3, 6, 8, 9, 9, 11};
        int n = r.length;
        int x=sort3.halfsearch2(r, 0,n-1,11);
        System.out.println(x);
    }
}
