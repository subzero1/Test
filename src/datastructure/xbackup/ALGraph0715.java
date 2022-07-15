package datastructure.xbackup;;

import Bean.ArcNode;
import Bean.VertexNode;

public class ALGraph0715 {
    VertexNode[]adjlist;

    int vertexNum;
    int arcNum;
    private boolean []visited;



    /**
     * @param vertexArray 顶点信息数组
     * @param arcArray 边原始数组（格式，初度顶点编号#入度顶点编号）
     */
    public ALGraph0715(VertexNode[] vertexArray, String[] arcArray) {
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
            ArcNode arcNode=adjlist[v0].firstArcNode;
            if (arcNode==null)
                adjlist[v0].firstArcNode=new ArcNode(v1);
            while (arcNode!=null){
                if (arcNode.next==null){
                    arcNode.next=new ArcNode(v1);
                    break;
                }
                arcNode=arcNode.next;
            }
        }



    }

    /**
     * Depth first traverse recursion
     System.out.println("访问:"+adjlist[v].text);
     visited[v]=true;
     * @param v
     */
    public void DFSTraverse(int v){
        System.out.println("访问:"+adjlist[v].text);
        visited[v]=true;
        ArcNode pNode=adjlist[v].firstArcNode;
        while (pNode!=null){
            int vex=pNode.adjvex;
            if (!visited[vex])
                DFSTraverse(vex);
            pNode=pNode.next;
        }
    }
    /**
     * Depth first traverse non-recursion
     * @param v
     */
    public void DFSTraverse1(int v){
        int top=-1;
        int[]stack=new int[vertexNum];
        System.out.println("访问:"+adjlist[v].text);
        visited[v]=true;
        stack[++top]=v;
        while (top!=-1){
            v=stack[top];
            ArcNode pNode=adjlist[v].firstArcNode;
            while (pNode!=null){
                int vex=pNode.adjvex;
                if (!visited[vex]){
                    System.out.println("访问:"+adjlist[vex].text);
                    visited[vex]=true;
                    stack[++top]=vex;
                    break;
                }
                pNode=pNode.next;
            }
            if (pNode==null)
                top--;
        }
    }

    /**
     * Breadth first traverse non-recursion
     System.out.println("访问:"+adjlist[v].text);
     visited[v]=true;
     * @param v
     */
    public void BFSTraverse(int v){
        int front=-1,rear=-1;
        int[]Q=new int[vertexNum];
        System.out.println("访问:"+adjlist[v].text);
        visited[v]=true;
        Q[++rear]=v;
        while (front!=rear){
            v=Q[++front];
            ArcNode pNode=adjlist[v].firstArcNode;
            while (pNode!=null){
                int vex=pNode.adjvex;
                if (!visited[vex]){
                    System.out.println("访问:"+adjlist[vex].text);
                    visited[vex]=true;
                    Q[++rear]=vex;
                }
                pNode=pNode.next;
            }
        }

    }

    /**
     * DFS 01243
     * BFS 01324
     * @param args
     */
    public static void main(String[] args) {
        VertexNode[]vertexNodes=new VertexNode[5];
        vertexNodes[0]=new VertexNode("顶点0");
        vertexNodes[1]=new VertexNode("顶点1");
        vertexNodes[2]=new VertexNode("顶点2");
        vertexNodes[3]=new VertexNode("顶点3");
        vertexNodes[4]=new VertexNode("顶点4");
        String[] arcArray=new String[10];
        arcArray[0]="0#1";
        arcArray[1]="0#3";
        arcArray[2]="1#0";
        arcArray[3]="1#2";
        arcArray[4]="1#3";
        arcArray[5]="2#1";
        arcArray[6]="2#4";
        arcArray[7]="3#0";
        arcArray[8]="3#1";
        arcArray[9]="4#2";
        ALGraph0715  graph=new ALGraph0715(vertexNodes,arcArray);
//        graph.DFSTraverse(0);
//        graph.DFSTraverse1(0);
        graph.BFSTraverse(0);
    }
}
