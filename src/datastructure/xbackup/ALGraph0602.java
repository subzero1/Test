package datastructure.xbackup;

import Bean.ArcNode;
import Bean.VertexNode;

public class ALGraph0602 {
    boolean []visited;
    VertexNode[]adjlist;
    int vertexNum;
    int arcNum;



    /**
     * @param vertexArray 顶点信息数组
     * @param arcArray 边原始数组（格式，初度顶点编号#入度顶点编号）
     */
    public ALGraph0602(VertexNode[] vertexArray, String[] arcArray) {
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

    /**

     System.out.println("访问:"+adjlist[v].vertex);
     visited[v]=true;
     * @param v
     */
    public void DFSTraverse(int v){
        System.out.println("访问:"+adjlist[v].vertex);
        visited[v]=true;
        ArcNode pNode=adjlist[v].firstedge;
        while (pNode!=null){
            int adjvex=pNode.adjvex;
            if (!visited[adjvex])
                DFSTraverse(adjvex);
            pNode=pNode.next;
        }
    }

    /**

     System.out.println("访问:"+adjlist[v].vertex);
     visited[v]=true;
     * @param v
     */
    public void BFSTraverse(int v){
        int front=-1,rear=-1;
        int[] Q=new int[vertexNum];
        System.out.println("访问:"+adjlist[v].vertex);
        visited[v]=true;
        Q[++rear]=v;
        while (front!=rear){
            v=Q[++front];
            ArcNode pNode=adjlist[v].firstedge;
            while (pNode!=null){
                int adjvex=pNode.adjvex;
                if (!visited[adjvex]){
                    System.out.println("访问:"+adjlist[adjvex].vertex);
                    visited[adjvex]=true;
                    Q[++rear]=adjvex;
                }
                pNode=pNode.next;
            }
        }
    }

    /**
     * DFS 0123
     * BFS 0132
     * @param args
     */
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
        ALGraph0602  graph=new ALGraph0602(vertexNodes,arcArray);
//        graph.DFSTraverse(0);
        graph.BFSTraverse(0);
    }
}
