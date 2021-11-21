import java.util.*;
class DoublyLinkedList
{
    Node head,tail;
    int size;
    private class Node
    {
        int data;
        Node previous;
        Node next;
    }
    private void insertFirst(int data)
    {
        size++;
        Node newNode= new Node();
        newNode.data=data;
        if(head==null)
        {
            head=newNode;
            tail=newNode;
            return;

        }
        newNode.next=head;
        head.previous=newNode;
        head=newNode;
    }
    private void insertLast(int data)
    {
        size++;
        Node newNode= new Node();
        newNode.data=data;
        if(tail==null)
        {
            head=newNode;
            tail=newNode;
            return;
        }
        newNode.previous=tail;
        tail.next=newNode;
        tail=newNode;
    }
    void insert(int position,int data)
    {
        Node newNode= new Node();
        newNode.data=data;
        Node temp=head;
        if(position==0)
        {
            insertFirst(data);
            return;
        }
        if(size-1==position)
        {
            insertLast(data);
            return;
        }
        size++;
        while(position>1)
        {
            position--;
            temp=temp.next;
        }
        newNode.previous=temp;
        newNode.next=temp.next;
        temp.next=newNode;
    }
    private void deleteFirst()
    {
        size--;
        head=head.next;
        head.previous=null;
    }
    private void deleteLast()
    {
        size--;
        tail=tail.previous;
        tail.next=null;
    }
    void delete(int position)
    {
        if(position==0)
        {
            deleteFirst();
            return;
        }
        if(position==size-1)
        {
            deleteLast();
            return;
        }
        size--;
        Node temp=head;
        while(position>1)
        {
            position--;
            temp=temp.next;
        }
        temp.next.next.previous=temp;
        temp.next=temp.next.next;
    }
    void traverse()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
public class Main
{
    public static void main(String[] args)
    {
        /****** Merge two sorted lists and reverse a list are covered in 16thNov Assignment   ********/
        // Delete a node in Doubly Linked List
        DoublyLinkedList dL= new DoublyLinkedList();
        dL.insert(0,1);
        dL.insert(1,5);
        dL.insert(2,3);
        dL.traverse();
        dL.delete(0);
        dL.traverse();
    }
}
