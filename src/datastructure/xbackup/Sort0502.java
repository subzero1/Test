package datastructure.xbackup;

public class Sort0502 {
    //折半查找非递归
//    public static int halfSort1(int r[],int left,int right,int key){
//        int index = -1;
//        while (left<right){
//            index=(left+right)/2;
//            if (r[index]<key) left=index;
//            else if (r[index]>key)right=index;
//            else return index;
//        }
//        return index;
//    }
//    //折半查找递归
//    public static int halfSort2(int r[],int left,int right,int key){
//        int index = -1;
//        while (left<right){
//            index=(left+right)/2;
//            if (r[index]<key) return halfSort2(r,index+1,right,key);
//            else if (r[index]>key) return halfSort2(r,left,index-1,key);
//            else return index;
//        }
//        return index;
//    }
//
//    public void insert(int r[],int n){
//        for (int i=1;i<=n-1;i++){
//            int j=i-1;
//        }
//    }
    //折半查找非递归
    public static int halfSort1(int r[],int left,int right,int key){
        return left;
    }
    //折半查找递归
    public static int halfSort2(int r[],int left,int right,int key){
        return left;
    }
    public void insert(int r[],int n){}
    public void shell(int r[],int n){}
    public void bubble(int r[],int n){}
    public void quick(int r[],int n){}
    public void select(int r[],int n){}
    public void sift(int r[],int n){}

    public static void main(String[] args) {
        int r[]={1,3,4,5,6,7,9,10,14,16};
        int n=r.length;
        int index=halfSort2(r,0,n-1,10);
        System.out.println("index:"+index);
    }
}
