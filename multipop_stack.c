//Multi-pop stack

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#define SIZE 10

float cost=0.0,avg=0.0;
int ToS=-1,a[SIZE];

void push(){
    
    if(ToS==SIZE-1){
        printf("Stack Overflow\n");
        cost++;
    }
    
    else{
        int x=rand()%100;
        cost++;
        ToS++;
        a[ToS]=x;
        printf("Pushed Element:%d\n",a[ToS]);
    }
}

void pop(){
    
    if(ToS==-1){
        printf("Stack Underflow\n");
        cost++;
    }
    
    else{
        cost++;
        printf("Popped Element:%d\n",a[ToS]);
        ToS--;
        
    }
}

void multipop(){
    
   if(ToS==-1){
        printf("Stack Underflow\n");
        cost++;
    }
    
    else{
        int x=rand()%5;
        for(int i=1;i<=x;i++){
            pop();
            cost++;
        }
    }
}

void main(){
    
    int n,i;
    printf("Enter the number of operations:");
    scanf("%d",&n);
    
    for(i=1;i<=n;i++){
        
        int choice=rand()%3;
        //printf("%d\n",choice);
        
        switch(choice){
            case 0:push();
            break;
            case 1:pop();
            break;
            case 2:multipop();
            break;
            default:printf("Invalid choice\n");
        }
    }
    
    printf("Total Cost:%f\n",cost);
    avg=cost/n;
    printf("Average Cost:%f\n",avg);
        
}