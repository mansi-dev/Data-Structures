import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.RunElement;

public class BinaryTreeKDistance {
    static class Node{
        int key;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }
    }

    static Node root;

    public void preOrder(Node temp){
        if(temp==null){
            return;
        }
        System.out.print(temp.key+" ");
        preOrder(temp.left);
        preOrder(temp.right);
    }

    public void printKDist(Node temp,int k){
        if(temp==null){
            return;
        }
        if(k==0){
            System.out.print(temp.key+ " ");
        }else{
            printKDist(temp.left, k-1);
            printKDist(temp.right, k-1);
        }

    }

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

    public static void main(String[] args) {
        BinaryTreeKDistance binaryTreeKDistance = new BinaryTreeKDistance();
        binaryTreeKDistance.insert(root, 10);
        binaryTreeKDistance.insert(root, 20);
        binaryTreeKDistance.insert(root, 30);
        binaryTreeKDistance.insert(root, 40);
        binaryTreeKDistance.insert(root, 50);
        System.out.println("\n-----------------PreOrder---------------------");

        binaryTreeKDistance.preOrder(root);
        System.out.println("\n-----------------Nodes------------------------");

        binaryTreeKDistance.printKDist(root, 2);
    }
}
