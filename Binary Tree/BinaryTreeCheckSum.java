import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCheckSum {

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

    public boolean checkSum(Node temp){
        if(temp==null)
            return true;
        if(temp.left==null && temp.right==null){
            return true;
        }
        int sum=0;
        if(temp.left!=null){
            sum += temp.left.key;
        }
        if(temp.right!=null){
            sum += temp.right.key;
        }

        return (temp.key==sum && checkSum(temp.left) && checkSum(temp.right));
    }

    public static void main(String[] args) {
        BinaryTreeCheckSum binaryTreeCheckSum = new BinaryTreeCheckSum();

        binaryTreeCheckSum.insert(root, 30);
        binaryTreeCheckSum.insert(root, 20);
        binaryTreeCheckSum.insert(root, 10);
        binaryTreeCheckSum.insert(root, 10);
        binaryTreeCheckSum.insert(root, 10);

        boolean ans = binaryTreeCheckSum.checkSum(root);
        System.out.println(ans);
    }
}
