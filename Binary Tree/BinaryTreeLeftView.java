import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLeftView {
    static class Node{
        int key;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }
    }

    static Node root;
    int maxLevel = 0;

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

    void printLeftView(Node temp, int level){
        if (temp==null) {
            return;
        }
        if(maxLevel<level){
            System.out.print(temp.key+ " ");
            maxLevel = level;
        }
        printLeftView(temp.left, level+1);
        printLeftView(temp.right, level+1);
    }

    public static void main(String[] args) {
        BinaryTreeLeftView binaryTreeLeftView = new BinaryTreeLeftView();
        binaryTreeLeftView.insert(root, 10);
        binaryTreeLeftView.insert(root, 20);
        binaryTreeLeftView.insert(root, 30);
        binaryTreeLeftView.insert(root, 40);
        binaryTreeLeftView.insert(root, 50);

        binaryTreeLeftView.printLeftView(root, 1);

    }
}
