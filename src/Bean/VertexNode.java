package Bean;

/**
 *
 */
public class VertexNode {
    public String vertex;

    //邻接表专用字段，邻接矩阵不需要此字段
    public ArcNode firstedge;

    public VertexNode(String vertex) {
        this.vertex=vertex;
        this.firstedge=null;
    }
}
