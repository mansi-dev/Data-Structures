import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeProblems {
    static class Node{
        int key;
        Node left, right;

        Node(int key){
            this.key = key;
        }
    }
    static Node root;
    public void insert(Node temp, int key){
        if (temp==null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.poll();
            System.out.print(temp.key + " ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }
    public int isBalanced(Node temp){
        if(temp==null)
            return 0;
        int lh = isBalanced(temp.left);
        if(lh==-1) 
            return -1;
        int rh = isBalanced(temp.right);
        if(rh==-1)
            return -1;
        if(Math.abs(rh-lh)>1) 
            return -1;
        else
            return Math.max(lh, rh)+1;
    }
    public static void main(String[] args) {
        BinaryTreeProblems binaryTreeProblems = new BinaryTreeProblems();
        binaryTreeProblems.insert(root, 10);
        binaryTreeProblems.insert(root, 20);
        binaryTreeProblems.insert(root, 30);
        binaryTreeProblems.insert(root, 40);
        binaryTreeProblems.insert(root, 50);
        System.out.println("\n-----------------Is Balanced---------------------");
        int bl = binaryTreeProblems.isBalanced(root);
        System.out.println(bl);
    }
}
