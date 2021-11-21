import java.util.*;
class LinkedList
{
    Node head,tail;
    int size;
    void add(int data,int position)
    {
        if(position>size)
        {
            System.out.println("error");
            return;
        }
        Node newNode=new Node();
        newNode.data=data;
        newNode.next=null;
        if(head==null)
        {
            head=newNode;
            tail=newNode;
            size++;return;
        }
        if(position==0)
        {
            newNode.next=head;
            head=newNode;
            size++;return;
        }
        if(position==size+1)
        {
            tail.next=newNode;
            tail=newNode;
            size++;return;
        }
        Node temp=head;
        while(position>1)
        {
            temp=temp.next;
            position--;
        }

        if(temp.next!=null)
        {
            newNode.next=temp.next;
            temp.next=newNode;
        }
        else
        {
            temp.next=newNode;
            tail=newNode;
        }
        size++;
    }

    void traverse()
    {
        Node temp=head;
        while(temp!=null)
        {
            if(temp.next!=null)
                System.out.print(temp.data+"->");
            else
                System.out.print(temp.data);
            temp=temp.next;
        }
    }
    void kthElementInLinkedList(int k)
    {
        Node p1=head;
        Node p2=null;
        while(p1!=null)
        {


            if(k<=0)
            {
                if(p2==null)
                {
                    p2=head;
                }
                else
                    p2=p2.next;
            }
            k--;
            p1=p1.next;
            //System.out.println(p1==null);
        }

        if(k>=0)
        {
            System.out.println("null");
        }
        else
        {
            System.out.println(p2.data);
        }
    }
    void kthElementInLinkedListUsingTwoTraversal(int k)
    {
        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        count=count-k;
        temp=head;

        while(count>1)
        {
            temp=temp.next;
            count--;
        }
        System.out.println(temp.data);
    }
    void reverse()
    {
        Node temp=head;
        Node previous=null;

        while(temp!=null)
        {
            //previous=temp.next;
            temp=temp.next;
            head.next=previous;
            previous=head;
            head=temp;
            //head.next=previous;
            //temp=temp.next;
            //head.next=previous;
            //temp=temp.next;
            //System.out.println(previous.data+" "+head.data+" "+temp.data);
        }
        //previous=head;
        while(previous!=null)
        {
            System.out.print(previous.data+" ");
            previous=previous.next;
        }
    }

}
class Node
{
    int data;
    Node next;
}
public class Main
{
    static void print(Node head)
    {
        Node temp=head;
        if(temp==null)
        {
            System.out.println("null");
        }
        while(temp!=null)
        {
            if(temp.next!=null)
                System.out.print(temp.data+"->");
            else
                System.out.print(temp.data);
            temp=temp.next;
        }
        System.out.println();
    }
    static Node mergeSortedLinkedLists
            (Node head1,Node head2)
    {
        Node head,tail;
        if(head1==null&&head2==null)
        {
            return null;
        }
        if(head1==null)
        {
            return head2;
        }
        if(head2==null)
        {
            return head1;
        }
        if(head1.data<head2.data)
        {
            head=head1;
            tail=head1;
            head1=head1.next;
        }
        else
        {
            head=head2;
            tail=head2;
            head2=head2.next;
        }
//        print(head1);
//        print(head2);
        while(true)
        {
            //System.out.println("test="+head2.next);
            if(head1==null&&head2!=null)
            {
                tail.next=head2;
                tail=head2;
                head2=head2.next;



            }

            if(head2==null&&head1!=null)
            {
                //System.out.println("aa gaya");
                tail.next=head1;
                tail=head1;
                head1=head1.next;


            }
            if(head1==null&&head2==null)
            {
                break;
            }
            if(head1!=null&&head2!=null&&head1.data<head2.data)
            {
                tail.next=head1;
                tail=head1;
                head1=head1.next;

                continue;
            }

            if(head2!=null&&head1!=null&&head2.data<head1.data)
            {
                tail.next=head2;
                tail=head2;
                head2=head2.next;


            }
        }
        return head;
    }
   static Node merge_smaller_into_large(Node head1,Node head2)
    {
        Node temp_head1=head1,temp_head2=head2;
        int c_1=0,c_2=0;
        while(temp_head1.next!=null)
        {
            c_1++;
            temp_head1=temp_head1.next;
        }
        while(temp_head2.next!=null)
        {
            c_2++;
            temp_head2=temp_head2.next;
        }
        if(c_1>c_2){
            temp_head1.next=head2;
            return head1;
        }
        else
        {
            temp_head2.next=head1;
            return  head2;
        }
    }
    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.add(55,0);
        ll.add(66,1);
        ll.add(111,2);
        ll.add(222,3);
        LinkedList ll1 = new LinkedList();
        ll1.add(1,0);
        ll1.add(99,1);
        ll1.add(110,2);
        ll1.add(227,3);
        ll.traverse();
        System.out.println();
        ll1.traverse();
        System.out.println();
        // Merge two sorted LinkedLists
        Node newNode=mergeSortedLinkedLists(ll.head,ll1.head);
        while(newNode!=null)
        {
            System.out.print(newNode.data+" ");
            newNode=newNode.next;
        }
        LinkedList ll11 = new LinkedList();
        ll11.add(1,0);
        ll11.add(99,1);
        ll11.add(110,2);
        ll11.add(227,3);
        System.out.println();
        ll11.traverse();
        System.out.println();
        // Find kth element in a linked list using single traversal
        ll11.kthElementInLinkedList(2);
        // Find kth element in a linked list using two traversals
        ll11.kthElementInLinkedListUsingTwoTraversal(2);
        // Reversing a linked list
        ll11.reverse();
        // Merge smaller linked list into larger one
        LinkedList small = new LinkedList();
        LinkedList large = new LinkedList();
        small.add(1,0);
        small.add(13,1);
        large.add(100,0);
        large.add(113,1);
        large.add(31,2);
        large.add(43,3);
        Node head=merge_smaller_into_large(small.head,large.head);
        System.out.println();
        print(head);

    }
}
