import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSize {

    static class Node{
        int key;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }
    }

    static Node root;

    public void insert(Node temp, int key){
        if(temp==null){
            root = new Node(key);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while(!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();

            if(temp.left==null){
                temp.left = new Node(key);
                break;
            }else{
                queue.add(temp.left);
            }

            if(temp.right==null){
                temp.right = new Node(key);
                break;
            }else{
                queue.add(temp.right);
            }
        }
    }

    public int getSizeOfTree(Node temp){
        if(temp==null){
            return 0;
        }else{
            return 1+getSizeOfTree(temp.left)+getSizeOfTree(temp.right);
        }
        
    }

    public int getMaxInTree(Node temp){
        if(temp==null){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(temp.key,Math.max(getMaxInTree(temp.left), getMaxInTree(temp.right)));
        }
    }
    public static void main(String[] args) {
        BinaryTreeSize binaryTreeSize = new BinaryTreeSize();
        binaryTreeSize.insert(root, 10);
        binaryTreeSize.insert(root, 20);
        binaryTreeSize.insert(root, 30);
        binaryTreeSize.insert(root, 40);
        binaryTreeSize.insert(root, 50);

        int size = binaryTreeSize.getSizeOfTree(root);

        System.out.println("Size of tree = "+size);

        int max = binaryTreeSize.getMaxInTree(root);

        System.out.println("Max value in tree = "+ max);
    }
}
