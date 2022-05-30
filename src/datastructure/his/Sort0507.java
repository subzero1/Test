package datastructure.his;

import Bean.ArcNode;
import Bean.VertexNode;

import java.util.Arrays;

public class Sort0507 {
    //折半查找非递归
    public static int halfSort1(int r[],int left,int right,int key){
        int center=-1;
        while (left<right){
            center=(left+right)/2;
            if (r[center]<key)left=center+1;
            else if (r[center]>key)right=center-1;
            else return center;

        }
        return center;
    }
    //折半查找递归
    public static int halfSort2(int r[],int left,int right,int key){
        int center=-1;
        while (left<right){
            center=(left+right)/2;
            if (r[center]<key)return halfSort2(r,center+1,right,key);
            else if (r[center]>key) return halfSort2(r,left,center-1,key);
            return center;
        }
        return center;
    }
    public static void insert(int r[],int n){
        for (int i=1;i<=n-1;i++){
            int temp=r[i];
            int j=i-1;
            for (;j>=0&&r[j]>=temp;j--)
                r[j+1]=r[j];
            r[j+1]=temp;
        }
    }
    public static void shell(int r[],int n){
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
    public static void bubble(int r[],int n){
        for (int i=0;i<=n-2;i++){
            for (int j=0;j<=n-2-i;j++){
                if (r[j]>r[j+1]){
                    int temp=r[j];
                    r[j]=r[j+1];
                    r[j+1]=temp;
                }
            }
        }
    }

    public static void quick(int r[],int left,int right){
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
            if (r[i]>base){
                int temp=r[i];
                r[i]=r[j];
                r[j]=temp;
            }
        }
        quick(r,i+1,right);
        quick(r,left,i-1);
    }
    public static void select(int r[],int n){
        for (int i=0;i<=n-1;i++){
            int minIndex=i;
            int minValue=r[i];
            for (int j=i;j<=n-1;j++){
                if (minValue>r[j]){
                    minIndex=j;
                    minValue=r[j];
                }
            }
            if (i!=minIndex){
                int temp=r[i];
                r[i]=r[minIndex];
                r[minIndex]=temp;
            }
        }
    }
    public static void heap(int r[],int n){
        for (int i=n/2-1;i>=0;i--){
            heap_x(r,i,n-1);
        }

        for (int i=0;i<=n-2;i++){
            int temp=r[n-1-i];
            r[n-1-i]=r[0];
            r[0]=temp;
            heap_x(r,0,n-1-i);
        }

    }
    private static void heap_x(int r[], int start, int end){
        int i=start;
        int j=2*i+1;
        while (j<end-1){
            if (j<end&&r[j]<r[j+1])j++;
            else if (r[i]>r[j])
                break;
            else {
                int temp=r[i];
                r[i]=r[j];
                r[j]=temp;
                i=j;
                j=2*i+1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int r[]={10,11,9,4,16,3,4,5,6,7};
        int n=r.length;
//        int index=halfSort2(r,0,n-1,10);
//        System.out.println("index:"+index);
//        insert(r,n);
//        shell(r,n);
//        bubble(r,n);
//        quick(r,0,n-1);
//        select(r,n);
        heap(r,n);
        System.out.println(Arrays.toString(r));
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
                if (!visited[adjverx]){
                    DFSTraverse(adjverx);
                }
                arcNode=arcNode.next;
            }
        }

        public void BFSTraverse(int v){
            int front=-1,rear=-1;
            int []Q=new int[vertexNum];
            System.out.println("访问:"+adjlist[v].vertex);
            visited[v]=true;
            Q[++rear]=v;
            while (rear!=front){
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
