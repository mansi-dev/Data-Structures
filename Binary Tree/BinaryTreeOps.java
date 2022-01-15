package com.cp.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOps {
    static class Node{
        int key;
        Node left, right;
        
        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;

    static void inorder(Node temp){
        if(temp==null)
            return;
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    static void preOrderTraversal(Node temp){
        if(temp==null)
            return;
        System.out.print(temp.key+" ");
        preOrderTraversal(temp.left);
        preOrderTraversal(temp.right);
    }

    static void postOrderTraversal(Node temp){
        if(temp==null)
            return;
        postOrderTraversal(temp.left);
        postOrderTraversal(temp.right);
        System.out.print(temp.key+" ");
    }

    static void levelOrderTraversal(Node temp){
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

    static void insert(Node temp, int key){
        if(temp==null){
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if(temp.left==null){
                temp.left = new Node(key);
                break;
            }else{
                q.add(temp.left);
            }

            if(temp.right==null){
                temp.right = new Node(key);
                break;
            }else{
                q.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        int key = 12;
        insert(root, key);
        System.out.println("\n-----------------InOrder----------------------");
        inorder(root);
        System.out.println("\n-----------------PreOrder---------------------");

        preOrderTraversal(root);
        System.out.println("\n-----------------PostOrder--------------------");
        postOrderTraversal(root);
        
        System.out.println("\n-----------------LevelOrder--------------------");
        levelOrderTraversal(root);
    }
}
