//Dynamic Array

import java.util.*;

class DynamicArray{
    
    private int arr[];
    private int size,capacity,cost;
    
    public DynamicArray(){
        size=0;
        capacity=1;
        cost=1;
        arr=new int[1];
    }
    
    public void addElement(int elem){
        
        if(size==capacity){
            doubleCapacity();
        }
        else cost=1;
        arr[size]=elem;
        size++;
    }
    
    public void doubleCapacity(){
        
        int temp[]=arr;
        arr=new int[2*capacity];
        
        for(int i=0;i<temp.length;i++){
            arr[i]=temp[i];
        }
        cost=capacity+1;
        capacity=2*capacity;
    }
    
    public int size(){
        
        return size;
    }
    
    public int capacity(){
        
        return capacity;
    }
    
    public int cost(){
        
        return cost;
    }
    
    public void printElements(){
        
        System.out.println("Elements in the array:"+Arrays.toString(arr));
    }

    
}

public class Main{
    
    public static void main(String args[]){
        
        DynamicArray array=new DynamicArray();
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();
        
        int i=0;
        while(i<n){
            
            System.out.println("Inserted Element:"+(i+1));
            array.addElement(i+1);
            array.printElements();
            
            System.out.println("Size:"+array.size());
            System.out.println("Capacity:"+array.capacity());
            System.out.println("Cost:"+array.cost());
            
            i++;
        }
    }
}