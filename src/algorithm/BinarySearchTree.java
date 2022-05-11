package algorithm;

public class BinarySearchTree {

    BST groot;
    int size=0;
    /**
     * 初始化构造二叉搜索树
     */
    public void init(int []array){
        if (array==null||array.length==0)
            return ;
        for (int i=0;i<array.length;i++){
            this.groot=add(this.groot,new BST(array[i]));
            ++size;
        }
    }

    /**
     * 查找
     */
    public void find(int value){

    }

    /**
     * 前序遍历
     */
    public void prelist(){}
    /**
     * 后序遍历
     */
    public void backlist(){}
    /**
     * 中序遍历
     */
    public void centerlist(){}
    /**
     * 插入
     */
//    public void add(BST bst){
//         BST current=root;
//         if (root==null){
//             current=bst;
//             this.root=bst;
//             return;
//         }
//         //左侧扫描寻找插入位置
//         while (current.value>value&&current.left!=null){
//             current=current.left;
//         }
//         if (current.left==null&&value<current.value) {
//             bst.parent=current;
//             current.left=bst;
//             return;
//         }
//
//
//
//
//         //右侧扫描找插入位置
//        while (current.value<value&&current.right!=null){
//            current=current.right;
//        }
//        if (current.right==null) {
//            current.right=bst;
//        }else {
//            BST right= current.right;;
//            current.right=bst;
//            bst.right=right;
//        }
//    }




    public BST add(BST root,BST bst){
        if (root==null){
            root=bst;
        }else if (bst.value< root.value)
            root.left=add(root.left,bst);
        else
            root.right=add(root.right,bst);
        return root;
    }
    /**
     * 删除
     */
    public void delete(int value){

    }
    /**
     * 更新
     */
    public void update(int value){

    }
    private class BST{
        public BST left;
        public BST right;
        public BST parent;
        public int value;
        public BST(int value){
            this.value=value;
        }
    }

    public static void main(String[] args) {
        int r[]={5,1,2,3,4,6,7,8,9,10};
        BinarySearchTree tree=new BinarySearchTree();
        tree.init(r);
        System.out.println(tree);
    }

}
