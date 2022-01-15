import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeHeight {
    static class Node{
        int key;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }
    }

    static Node root;

    // Function to print In-order traversal of binary tree
    public void inorder(Node temp){
        if(temp==null)
            return;
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    // Function to get the height of the binary tree
    public int height(Node temp){
        if(temp==null){
            return 0;
        }else{
            return Math.max(height(temp.left), height(temp.right))+1;
        }
    }

    // Function to insert new node in the tree
    public void insert(Node temp, int key){
        // If tree is empty, make new node as root
        if(temp==null){
            root = new Node(key);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        
        while (!queue.isEmpty()) {
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

    public static void main(String[] args) {
        BinaryTreeHeight binaryTreeHeight = new BinaryTreeHeight();
        binaryTreeHeight.insert(root, 10);
        binaryTreeHeight.insert(root, 20);
        binaryTreeHeight.insert(root, 30);
        binaryTreeHeight.insert(root, 40);
        binaryTreeHeight.insert(root, 50);

        binaryTreeHeight.inorder(root);

        int height = binaryTreeHeight.height(root);
        System.out.println("\nHeight of Binary Tree = "+height);
    }
}
