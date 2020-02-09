package algo;

/**
 * @author labvi
 * @version 1.0.0
 */
public class BinaryTreeTraversal {

    //前序遍历
    private static void preSort(Node node){
        if (null == node){
            return;
        }
        System.out.println(node.value);
        preSort(node.left);
        preSort(node.right);
    }

    //中序遍历
    private static void midSort(Node node){
        if (null == node){return;}
        midSort(node.left);
        System.out.println(node.value);
        midSort(node.right);
    }

    //后序遍历
    private static void postSort(Node node){
        if (null == node){return;}
        postSort(node.left);
        postSort(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(6);
        Node node5 = new Node(7);
        Node node6 = new Node(8);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //前序遍历
//        preSort(node1);
        //中序遍历
//        midSort(node1);
        //后序遍历
        postSort(node1);
    }


    private static class Node{
        private Node left;
        private Node right;
        private int value;

        Node(int value){
            this.value = value;
        }

        public void setLeft(Node node){
            this.left = node;
        }
        public void setRight(Node node){
            this.right = node;
        }
    }

}
