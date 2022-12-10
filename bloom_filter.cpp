//Bloom filter

#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int h1(int val,int size){
    return val%size;
}

int h2(int val,int size){
    return (val*(val+3))%size;
}

bool lookup(bool *bitarray,int size,int val){
    int a=h1(val,size);
    int b=h2(val,size);
    
    if(bitarray[a] && bitarray[b]){
        return true;
    }
    
    else{
        return false;
    }
    
}

void insert(bool *bitarray,int size,int val){
    
    if(lookup(bitarray,size,val)){
        cout << val << " is Probably Already Present in bloom filter" <<endl;
    }
    
    else{
        int a=h1(val,size);
        int b=h2(val,size);
        bitarray[a]=true;
        bitarray[b]=true;
        cout << val << " is Inserted in the bloom filter" << endl;
       
    }
    
}

int main()
{
    bool bitarray[100]={false};
    int size=100;
    int arr[7]={1,3,5,7,9,11,5};
    
    for(int i=0;i<7;i++){
        insert(bitarray,size,arr[i]);
    }

    return 0;
}