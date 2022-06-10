package datastructure.xbackup;

import Bean.Entry;

public class MGraph0610 {
    private Entry[] vertex;//顶点
    private int[][] arc;//邻接矩阵（弧）
    private int vertexNum;
    private int arcNum;
    private boolean[] visited;

    public MGraph0610(){
        this(new Entry[]{new Entry("顶点0"),new Entry("顶点1"),new Entry("顶点2"),new Entry("顶点3"),new Entry("顶点4")}, new String[]{"0#1","0#3","1#2","1#3","2#4"});
    }

    /**
     * @param vertexArray 顶点信息数组
     * @param arcArray 边原始数组（格式，初度顶点编号#入度顶点编号）
     */
    public MGraph0610(Entry[] vertexArray, String[] arcArray) {
        this.arcNum=arcArray.length;
        this.vertexNum=vertexArray.length;

        this.vertex = new Entry[vertexNum];
        this.arc = new int[vertexNum][vertexNum];
        this.visited=new boolean[vertexNum];
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
    System.out.println("访问:"+vertex[v].text);
    visited[v]=true;
     */
    public void DFSTraverse(int v){
        System.out.println("访问:"+vertex[v].text);
        visited[v]=true;
        for (int i=0;i<=vertexNum-1;i++)
            if (arc[v][i]==1&&!visited[i])
                DFSTraverse(i);
    }

    /**
     * Breath First Traverse
     * @param v
    System.out.println("访问:"+vertex[v].text);
    visited[v]=true;
     */
    public void BFSTraverve(int v){
        int front=-1,rear=-1;
        int[]Q=new int[vertexNum];
        System.out.println("访问:"+vertex[v].text);
        visited[v]=true;
        Q[++rear]=v;
        while (front!=rear){
            v=Q[++front];
            for (int i=0;i<=vertexNum-1;i++)
                if (arc[v][i]==1&&!visited[i]){
                    System.out.println("访问:"+vertex[i].text);
                    visited[i]=true;
                    Q[++rear]=i;
                }
        }
    }

    /**
     * DFS 01243
     * BFS 01324
     * @param args
     */
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
        MGraph0610 graph=new MGraph0610(entries,arcArray);
//        graph.DFSTraverse(0);
        graph.BFSTraverve(0);
    }
}
