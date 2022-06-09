package datastructure.xbackup;

import Bean.ArcNode;
import Bean.VertexNode;

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
    public static void insert(int r[], int n) {
        for (int i = 1; i <= n - 1; i++) {
            int temp = r[i];
            int j = 0;
            for (j = i - 1; j >= 0 && r[j] > temp; j--) {
                r[j + 1] = r[j];
            }
            r[j + 1] = temp;
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

    /**
     * 插入排序-希爾排序
     * @param r 數組
     * @param n 數組長度
     */
    public static void shell(int r[], int n) {
        for (int d = n / 2; d >= 1; d = d / 2) {
            for (int i = d; i <= n - 1; i++) {
                int temp = r[i];
                int j;
                for (j = i - d; j >= 0 && r[j] > temp; j=j-d) {
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
    public static void bubble(int r[],int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (r[j] > r[j + 1]) {
                    int temp  = r[j];
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
        int i = begin;
        int j = end;
        int base = r[begin];
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
     * 交換排序-快速排序
     * @param r 數組
     * @param first 數組長度
     */
    public  static  void Quick_Sort2 (int r[],int first,int end){
        if(first > end)
            return;
        int i = first;
        int j = end;
        //一次劃分，循環直到i=j
        while(i != j){
            while(r[i]<=r[j]  && j > i) j--; //右側掃描，當數組當前值大於基準值,下標左移
            if(j > i){
                int t = r[i];
                r[i] = r[j];
                r[j] = t;
            }
            while(r[i]<=r[j]  && j > i) i++;//左側掃描，當數組當前值小於基準值,下標右移
            //交換ij的值
            if(j > i){
                int t = r[i];
                r[i] = r[j];
                r[j] = t;
            }
            System.out.println("i:" + i + "j："+j+"交換#"+  Arrays.toString(r));
        }
        System.out.println("第=========================趟：" + Arrays.toString(r));
        Quick_Sort2(r, first, i-1);
        Quick_Sort2(r, i+1, end);
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
                int temp  = r[i];
                r[i] = r[maxIndex];
                r[maxIndex] = temp;
            }
            System.out.println("第" + i + "趟：" + Arrays.toString(r));
        }
    }

    /**
     * 選擇排序-堆排序
     * 左邊有序區 右邊無序區
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

    public static class ALGraph0529 {
        boolean []visited;
        VertexNode[]adjlist;
        int vertexNum;
        int arcNum;



        /**
         * @param vertexArray 顶点信息数组
         * @param arcArray 边原始数组（格式，初度顶点编号#入度顶点编号）
         */
        public ALGraph0529(VertexNode[] vertexArray, String[] arcArray) {
            this.vertexNum=vertexArray.length;
            this.arcNum=arcArray.length;
            adjlist=new VertexNode[vertexNum];
            visited=new boolean[vertexNum];
            for (int i=0;i<=vertexNum-1;i++){
                adjlist[i]=vertexArray[i];
                visited[i]=false;
            }

            for (int i=0;i<=arcNum-1;i++){
                String arcs=arcArray[i];
                if (arcs==null||"".equals(arcs))
                    continue;
                String[]a=arcs.split("#");
                int v0=Integer.valueOf(a[0]);
                int v1=Integer.valueOf(a[1]);
                ArcNode arcNode=adjlist[v0].firstedge;
                if (arcNode==null)
                    adjlist[v0].firstedge=new ArcNode(v1);
                while (arcNode!=null){
                    if (arcNode.next==null){
                        arcNode.next=new ArcNode(v1);
                        break;
                    }
                    arcNode=arcNode.next;
                }
            }



        }
    //        System.out.println("访问:"+adjlist[v].vertex);

        public void DFSTraverse(int v){
            System.out.println("访问:"+adjlist[v].vertex);
            visited[v]=true;
            ArcNode arcNode=adjlist[v].firstedge;
            while (arcNode!=null){
                int adjverx=arcNode.adjvex;
                if (!visited[adjverx])  DFSTraverse(adjverx);
                arcNode=arcNode.next;
            }
        }

        public void BFSTraverse(int v){
            int front=-1,rear=-1;
            int[]Q=new int[vertexNum];
            System.out.println("访问:"+adjlist[v].vertex);
            visited[v]=true;
            Q[++rear]=v;
            visited[v]=true;
            while (front!=rear){
                v=Q[++front];
                ArcNode arcNode=adjlist[v].firstedge;
                while (arcNode!=null){
                    int adjverx=arcNode.adjvex;
                    if (!visited[adjverx]){
                        System.out.println("访问:"+adjlist[adjverx].vertex);
                        visited[adjverx]=true;
                        Q[++rear]=adjverx;
                    }
                    arcNode=arcNode.next;
                }
            }

        }


        public static void main(String[] args) {
            VertexNode[]vertexNodes=new VertexNode[4];
            vertexNodes[0]=new VertexNode("顶点0");
            vertexNodes[1]=new VertexNode("顶点1");
            vertexNodes[2]=new VertexNode("顶点2");
            vertexNodes[3]=new VertexNode("顶点3");
            String[] arcArray=new String[8];
            arcArray[0]="0#1";
            arcArray[1]="0#3";
            arcArray[2]="1#0";
            arcArray[3]="1#2";
            arcArray[4]="1#3";
            arcArray[5]="2#1";
            arcArray[6]="3#0";
            arcArray[7]="3#1";
            ALGraph0529 graph=new ALGraph0529(vertexNodes,arcArray);
    //        graph.DFSTraverse(0);
            graph.BFSTraverse(0);
        }
    }
}
