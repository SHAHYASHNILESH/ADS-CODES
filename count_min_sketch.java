//Count-min sketch

import java.util.*;

class CountMinSketch{
    
    private int h1[];
    private int h2[];
    private int size;
    public static int DEFAULT_SIZE=11;
    
    public CountMinSketch(){
        size=DEFAULT_SIZE;
        h1=new int[size];
        h2=new int[size];
    }
    
    public void insert(int val){
        int hash1=hashFunc1(val);
        int hash2=hashFunc2(val);
        h1[hash1]++;
        h2[hash2]++;
    }
    
    public int sketchCount(int val){
        int hash1=hashFunc1(val);
        int hash2=hashFunc2(val);
        return min(h1[hash1],h2[hash2]);
    }
    
    public int min(int a,int b){
        int min=(a<b)?a:b;
        return min;
    }
    
    public void print(){
        System.out.print("h1: ");
        for(int i=0;i<size;i++){
            System.out.print(h1[i]+" ");
        }
        System.out.print("\nh2: ");
        for(int i=0;i<size;i++){
            System.out.print(h2[i]+" ");
        }
        System.out.println();
    }
    
    public int hashFunc1(int val){
        return val%size;
    }
    
    public int hashFunc2(int val){
        return (val*(val+3))%size;
    }
}

public class Main
{
	public static void main(String[] args) {
	    
		Scanner sc=new Scanner(System.in);
		CountMinSketch cms=new CountMinSketch();
		
		while(true){
		    System.out.println("Count-Min Sketch Operations\n1.Insert\n2.Get Sketch Count\n3.Print\n4.Exit\nEnter your choice:");
		    int choice=sc.nextInt();
		    
		    switch(choice){
		        
		        case 1:System.out.println("Enter the int value:");
		        int val=sc.nextInt();
		        cms.insert(val);
		        cms.print();
		        break;
		        
		        case 2: System.out.println("Enter the value:");
		        val=sc.nextInt();
		        cms.print();
		        System.out.println("The Sketch Count for "+val+" is: "+cms.sketchCount(val));
		        break;
		        
		        case 3:cms.print();
		        break;
		        
		        case 4:System.exit(0);
		        
		        default:System.out.println("Invalid Choice\n");
		    }
		}
	}
}
