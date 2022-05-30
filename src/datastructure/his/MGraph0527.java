package datastructure.his;

import Bean.Entry;

import java.util.Arrays;

public class MGraph0527 {
    private Entry[] vertex;//顶点
    private int[][] arc;//邻接矩阵（弧）
    private int vNum;
    private boolean[] visited;

    public MGraph0527(){
        this(new Entry[]{new Entry("顶点0"),new Entry("顶点1"),new Entry("顶点2"),new Entry("顶点3"),new Entry("顶点4")}, new String[]{"0#1","0#3","1#2","1#3","2#4"});
    }

    /**
     * @param vertexArray 顶点信息数组
     * @param arcArray 边原始数组（格式，初度顶点编号#入度顶点编号）
     */
    public MGraph0527(Entry[] vertexArray, String[] arcArray) {
        int vertexNum=vertexArray.length;
        int arcNum=arcArray.length;
        vertex = new Entry[vertexNum];
        arc = new int[vertexNum][vertexNum];
        vNum=vertexNum;
        visited=new boolean[vNum];
        //頂點一維數組初始化
        for (int i = 0; i <= vertexNum - 1; i++){
            visited[i]=false;
            vertex[i] = vertexArray[i];
        }
        //弧度二維數組（矩陣）初始化
        for (int i = 0; i <= vertexNum - 1; i++)
            for (int j = 0; j <= vertexNum - 1; j++)
                arc[i][j] = 0;
        for (int k=0;k<=arcNum-1;k++){
            String arcs=arcArray[k];
            if (arcs==null||"".equals(arcs))
                continue;
            String[]a=arcs.split("#");
            int v0=Integer.valueOf(a[0]);
            int v1=Integer.valueOf(a[1]);
            arc[v0][v1]=1;
            arc[v1][v0]=1;
        }
    }

    /**
     * Deepth First Traverse
     * @param v
     * System.out.println("访问:"+vertex[v].text);
     */
    public void DFSTraverse(int v){
        System.out.println("访问:"+vertex[v].text);
        visited[v]=true;
        for (int i=0;i<=vNum-1;i++){
            if (arc[v][i]==1&&!visited[i])
                DFSTraverse(i);
        }
    }

    /**
     * Breath First Traverse
     * @param v
     * System.out.println("访问:"+vertex[v].text);
     */
    public void BFSTraverve(int v){
        int front=-1,rear=-1;
        int[] Q=new int[vNum];
        System.out.println("访问:"+vertex[v].text);
        visited[v]=true;
        Q[++rear]=v;
        while (front!=rear){
            v=Q[++front];
            for (int i=0;i<=vNum-1;i++){
                if (arc[v][i]==1&&!visited[i]){
                    System.out.println("访问:"+vertex[i].text);
                    visited[i]=true;
                    Q[++rear]=i;
                }
            }
        }
    }


    public static void main(String[] args) throws CloneNotSupportedException {
//        MGraph graph=new MGraph();
////        graph.DFSTraverse(0);
//        graph.BFSTraverve(0);
        Entry[]entries=new Entry[5];
        entries[0]=new Entry("顶点0");
        entries[1]=new Entry("顶点1");
        entries[2]=new Entry("顶点2");
        entries[3]=new Entry("顶点3");
        entries[4]=new Entry("顶点4");
        String[] arcArray=new String[]{"0#1","0#3","1#2","1#3","2#4"};
        arcArray[0]="0#1";
        arcArray[1]="0#3";
        arcArray[2]="1#2";
        arcArray[3]="1#3";
        arcArray[4]="2#4";
        MGraph0527 graph=new MGraph0527(entries,arcArray);
//        graph.DFSTraverse(0);
        graph.BFSTraverve(0);
    }

    public static class S0529 {
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
            center=(left+right)/2;
            if (r[center]<key)return halfSort2(r,center+1,right,key);
            else if (r[center]>key)return halfSort2(r,left,center-1,key);
            return center;
        }

        //Direct Insertion Sort
        public static void insert(int r[], int n) {
            for (int i=0;i<=n-1;i++){
                int j=i-1;
                int temp=r[i];
                for (;j>=0&&r[j]>temp;j--)
                    r[j+1]=r[j];
                r[j+1]=temp;
            }
        }

        //Shell Sort
        public static void shell(int r[], int n) {
            for (int d=n/2;d>=1;d=d/2){
                for (int i=d;i<=n-1;i++){
                    int j=i-d;
                    int temp=r[i];
                    for (;j>=0&&r[j]>temp;j=j-d)
                        r[j+d]=r[j];
                    r[j+d]=temp;
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
            if (i>j)
                return;
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
                for (int j=i+1;j<=n-2;j++){
                    if (r[minIndex]>r[j])
                        minIndex=j;
                }
                if (i!=minIndex){
                    r[minIndex]=r[minIndex]^r[i];
                    r[i]=r[minIndex]^r[i];
                    r[minIndex]=r[minIndex]^r[i];
                }
            }
        }

        //Heap Sort
        public static void heap(int r[], int n) {
            for (int i=n/2-1;i>=0;i--)
                heap_x(r,i,n);
            for (int i=0;i<=n-2;i++){
                r[0]=r[0]^r[n-i-1];
                r[n-i-1]=r[0]^r[n-i-1];
                r[0]=r[0]^r[n-i-1];
                heap_x(r,0,n-1-i);
            }
        }

        public static void heap_x(int r[], int start, int end) {
            int i=start;
            int j=2*i+1;
            while (j<=end-1){
                if (j<end-1&&r[j]<r[j+1])j++;
                else if (r[i]>=r[j])break;
                else {
                    r[i]=r[i]^r[j];
                    r[j]=r[i]^r[j];
                    r[i]=r[i]^r[j];
                    i=j;
                    j=2*i+1;
                }
            }
        }
        public static int[] mSort(int[] r, int l, int h) {
            if (l==h)return new int[]{r[l]};
            int mid=(l+h)/2;
            int[] leftArray=mSort(r,l,mid);
            int[] rightArray=mSort(r,mid+1,h);
            int[]resultArray=new int[leftArray.length+rightArray.length];
            int i=0,j=0,k=0;
            while (i<leftArray.length&&j<rightArray.length)
                resultArray[k++]=leftArray[i]<rightArray[j]?leftArray[i++]:rightArray[j++];
            while (i<leftArray.length)
                resultArray[k++]=leftArray[i++];
            while (j<rightArray.length)
                resultArray[k++]=rightArray[j++];
            return resultArray;
        }

        public static void main(String[] args) {
            int r[] = {1, 3, 4, 5, 6, 7, 9, 10, 14, 16};
            int n = r.length;
                    int index1=halfSort1(r,0,n-1,10);
                    int index2=halfSort2(r,0,n-1,10);
                    System.out.println("index:"+index1+"#index2:"+index2);
            r = new int[]{1, 14, 16, 14, 16, 14,3, 4, 5, 6, 7, 9, 10,  16};
    //        r = new int[]{1, 3, 4, 5, 6};
            n = r.length;
            System.out.println(Arrays.toString(r));
    //                insert(r, n );
    //                shell(r,n);
    //                bubble(r,n);
    //                quick(r,0,n-1);
    //                select(r,n);
    //        heap(r, n);
            int s[]=mSort(r,0,n-1);
            System.out.println(Arrays.toString(s));
    //        System.out.println(Arrays.toString(r));
        }
    }
}
