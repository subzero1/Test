package Bean;

/**
 *
 */
public class VertexNode {
    public String text;

    //邻接表专用字段，邻接矩阵不需要此字段
    public ArcNode firstArcNode;

    public VertexNode(String vertex) {
        this.text =vertex;
        this.firstArcNode =null;
    }
}
