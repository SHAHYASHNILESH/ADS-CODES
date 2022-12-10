//Interval Tree

import java.io.*;

public class Main
{
    
    static class Interval{
        
        int low,high;
        
        public Interval(int low,int high){
            this.low=low;
            this.high=high;
        }
        
        public String toString(){
            return "["+this.low+","+this.high+"]";
        }
        
    }
    
    static class Node{
        Interval range;
        int max;
        Node left,right;
        
        public Node(Interval range,int max){
            this.range=range;
            this.max=max;
        }
        
        public String toString(){
            return "["+this.range.low+","+this.range.high+"]"+" Max="+this.max;
        }
        
    }
    
    public static Node insert(Node root,Interval x){
        
        if(root==null){
            return new Node(x,x.high);
        }
        
        else if(x.low<root.range.low){
            root.left=insert(root.left,x);
        }
        
        else{
            root.right=insert(root.right,x);
        }
        
        if(root.max<x.high){
            root.max=x.high;
        }
        
        return root;
    }
    
    public static void inorder(Node root){
        
        if(root==null){
            return;
        }
        
        inorder(root.left);
        System.out.println(root);
        inorder(root.right);
    }
    
    public static Interval isOverlapping(Node root,Interval x){
        
        if(root==null){
            return new Interval(-1,-1);
        }
        
        else if((x.low>root.range.low&&x.low<root.range.high)||(x.high>root.range.low&&x.high<root.range.high)){
            return root.range;
        }
        
        else if(root.left!=null && root.left.max>x.low){
            return isOverlapping(root.left,x);
        }
        
        else{
            return isOverlapping(root.right,x);
        }
    }
    
	public static void main(String[] args) {
	    
		Node root=insert(null,new Interval(15,20));
		root=insert(root,new Interval(10,30));
		root=insert(root,new Interval(17,19));
		root=insert(root,new Interval(5,20));
		root=insert(root,new Interval(12,15));
		root=insert(root,new Interval(30,40));
		
		System.out.println("Inorder Traversal of Interval Tree:");
		inorder(root);
		
		Interval i=new Interval(6,7);
		System.out.println("Search for:"+i);
		System.out.println("The interval "+i+" overlaps with: "+isOverlapping(root,new Interval(6,7)));
	}
	
}
