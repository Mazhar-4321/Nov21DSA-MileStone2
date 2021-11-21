import java.util.*;
class MyStack
{
    Node array[] ;
    int size;
    public class Node
    {
        int data;
        int max;
        int min;
        int avg;

    }
    MyStack(int size)
    {
        array= new Node[size];
    }
    void push(int data){
        Node newNode= new Node();
        newNode.data=data;
        newNode.max=data;
        newNode.min=data;
        newNode.avg=data;
        int max=0,min=0,avg=0;
        if(size<array.length)
        {
            if(size!=0)
            {
                newNode.max=Math.max(newNode.data,peek().max);
                newNode.min=Math.min(newNode.data,peek().min);
                newNode.avg=(peek().avg+newNode.data)/(size+1);
                array[size]=newNode;
            }
            else
            {
                array[size]=newNode;
            }
            size++;
        }
        else
        {
            System.out.println("Stack Overflow");
        }

    }
    void pop(){
        if(size==0){System.out.println("Stack Underflow");}
        else
        {
            size--;
        }
    }
    Node peek()
    {
        if(size==0)
            return new Node();
        else
        {
            return array[size-1];
        }
    }
    int getMax(){
        if(size!=0)
        {
            return array[size-1].max;
        }
        return 0;}
    int getMin(){
        if(size!=0)
        {
            return array[size-1].min;
        }
        return 0;}
    int getAvg(){
        if(size!=0)
        {
            return array[size-1].avg;
        }
        return 0;}
}
class CircularQueueUsingLinkedList
{
    private Node head,tail;
    private class Node
    {
        int data;
        Node next;
    }
    void enqueue(int data)
    {
        Node newNode= new Node();
        newNode.data=data;
        if(head==null)
        {
            head=newNode;
            tail=newNode;
            tail.next=head;
            return;
        }
        newNode.next=head;
        tail.next=newNode;
        tail=newNode;
    }
    void dequeue()
    {
        try
        {
            head=head.next;
            tail.next=head;
        }
        catch(Exception e)
        {
            System.out.println("Queue Underflow");
        }
    }
    void traverse()
    {
        Node temp=head;

        while(temp.next!=head)
        {

            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println(temp.data);

    }

}
class CircularQueueUsingArray
{
    int array[];
    int front=-1,rear=-1,size,size1;
    CircularQueueUsingArray(int size)
    {
        array= new int[size];
        this.size=size;
        size1=size;
    }
    void enqueue(int data)
    {
        if(size>0)
        {
            array[(rear+1)%size1]=data;
            rear++;
            size--;
        }
        else
        {
            System.out.println("Queue Overflow");
        }
    }
    void dequeue()
    {
        //System.out.println(rear+" "+front);
        if(rear==front)
        {
            System.out.println("Queue Underflow");
        }
        else
        {
            front++;size++;
        }
    }
    void traverse()
    {
        //System.out.println(front+" "+rear);
        for(int i=front+1;i<=rear;i++)
        {
            try
            {
                System.out.print(array[i%size1]+" ");
            }
            catch(Exception e)
            {

            }
        }
    }
}
public class Main
{
    public static void main(String[] args)
    {
        // Circular Queue Using LinkedList
        CircularQueueUsingLinkedList c= new CircularQueueUsingLinkedList();
        c.enqueue(5);
        c.enqueue(6);
        c.enqueue(4);
        c.traverse();
        c.dequeue();
        c.traverse();
        c.dequeue();
        c.traverse();
        // Circular Queue Using Array
        CircularQueueUsingArray c1= new CircularQueueUsingArray(15);
        c1.enqueue(1);
        c1.enqueue(2);
        c1.enqueue(3);
        c1.enqueue(4);
        c1.enqueue(5);
        c1.traverse();
        c1.enqueue(6);
        c1.dequeue();
        c1.dequeue();
        c1.dequeue();
        c1.dequeue();
        c1.dequeue();
        c1.dequeue();
        c1.dequeue();
        c1.enqueue(5);

        c1.traverse();
        System.out.println();
        // MyStack with push pop peek min max avg functionality
        MyStack m= new MyStack(5);
        m.push(5);
        System.out.println(m.peek().data+" "+m.getMin()+" "+m.getMax()+" "+m.getAvg());
        m.push(6);
        System.out.println(m.peek().data+" "+m.getMin()+" "+m.getMax()+" "+m.getAvg());

        m.push(8);
        System.out.println(m.peek().data+" "+m.getMin()+" "+m.getMax()+" "+m.getAvg());


        System.out.println(m.peek().data+" "+m.getMin()+" "+m.getMax()+" "+m.getAvg());

        // Reversing a Sentence based on words
        String s ="My Name is Ali";
        String[] split=s.split(" ");
        for(int i=split.length-1;i>=0;i--)
        {
            if(split[i]!=" ")
            {
                if(i==0)
                {
                    System.out.print(split[i]);
                }
                else
                    System.out.print(split[i]+" ");
            }
        }
    }
}
