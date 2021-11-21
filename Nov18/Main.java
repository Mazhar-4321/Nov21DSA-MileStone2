
import java.util.*;
class LinkedList
{
    Node head,tail;
    int size;
    void addCycle(int NodeNumber)
    {
        Node temp=head;
        while(NodeNumber>1)
        {
            temp=temp.next;
            NodeNumber--;
        }
        tail.next=temp;
    }
    boolean cycleDetection(Node head)
    {
        Node temp= head;
        int count=0;

        while(true)
        {
            try
            {count++;
                if(temp.flag)
                {
                    flipFlags(head,count);
                    return true;
                }
                if(temp.flag==false)
                {
                    temp.flag=true;
                }
                temp=temp.next;
            }
            catch(NullPointerException e)
            {
                flipFlags(head,count);
                return false;
            }

        }

    }
    void flipFlags(Node head,int count)
    {

        Node temp = head;
        while(count>0)
        {

            count--;
            try
            {
                temp.flag=false;
                temp=temp.next;
            }
            catch(Exception e)
            {

            }
        }
    }

    void cycleRemoval(Node head)
    {
        Node temp=head;
        int count=0;
        while(true)
        {
            try
            {
                count++;
                //System.out.print(temp.data+"->");
                if(temp.next.flag)
                {
                    //System.out.println("ho gaya");
                    //System.out.println(temp.next);
                    temp.next=null;
                    flipFlags(head,count);
                    //System.out.println(temp.next);
                    return;
                }
                if(temp.flag==false)
                {
                    temp.flag=true;
                }
                temp=temp.next;
            }
            catch(NullPointerException e)
            {
                flipFlags(head,count);
                System.out.println("No cycle detected");
            }

        }
    }
    boolean palindromeLinkedList(Node head)
    {
        Node fast=head;
        Node slow= head;
        int even_odd=0;
        Stack <Integer> s= new Stack<Integer>();
        while(true)
        {
            s.push(slow.data);
            slow=slow.next;

            if(fast.next==null)
            {
                even_odd=1;break;
            }
            if(fast.next.next==null)
            {
                break;
            }
            fast=fast.next.next;


        }
        if(even_odd==1)
        {
            s.pop();
        }
        while(!s.isEmpty())
        {
            
            if(s.peek()==slow.data)
            {
                s.pop();
                slow=slow.next;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
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
    int middleOfTheLinkedList()
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
}
class Node
{
    int data;
    Node next;
    boolean flag;
}
class MyStack
{
    private Node head=null;
    private int size=0;
    int size()
    {
        return size;
    }
    void push(Object data){
        size++;
        Node newNode= new Node();
        newNode.data=data;
        if(head==null)
        {
            head=newNode;return;
        }
        newNode.next=head;
        head=newNode;
    }
    void pop(){
        if(head==null)
        {
            System.out.println("Stack UnderFlow");return;
        }
        size--;
        head=head.next;
    }
    Object peek(){
        if(head!=null)
            return head.data;
        return null;
    }
    private class Node
    {
        Object data;
        Node next;
    }
}
public class Main
{
    public static void main(String[] ar)
    {
        // MyStack class with push(x) pop() and peek() functionality
        MyStack myStack= new MyStack();
        myStack.push(10);
        myStack.push(15);
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        //Validate Parenthesis
        String expression="()(())[()]{}";
        MyStack validateParenthesis=new MyStack();
        boolean flag=true;
        for(int i=0;i<expression.length();i++)
        {
            switch(expression.charAt(i))
            {
                case '(':validateParenthesis.push('(');break;
                case '[':validateParenthesis.push('[');break;
                case '{':validateParenthesis.push('{');break;
                case '}':
                    if((char)validateParenthesis.peek()!='{')
                    {

                        flag=false;
                    }
                    else
                    {
                        validateParenthesis.pop();
                    }
                    break;
                case ']':
                    if((char)validateParenthesis.peek()!='[')
                    {
                        flag=false;
                    }
                    else
                    {
                        validateParenthesis.pop();
                    }
                    break;
                case ')':
                    if((char)validateParenthesis.peek()!='(')
                    {
                        flag=false;
                    }
                    else
                    {
                        validateParenthesis.pop();
                    }
                    break;




            }
            if(!flag)
            {
                System.out.println("Invalid Parenthesis");
                break;
            }
        }
        if(flag)
        {
            System.out.println("Valid Parenthesis");
        }
        // Cycle Detection
        LinkedList ll= new LinkedList();
        ll.add(5,0);ll.add(6,1);ll.add(77,2);ll.add(78,3);

        System.out.println("Cycle Detected1="+ll.cycleDetection(ll.head));

        // Cycle Removal
        LinkedList ll2= new LinkedList();
        ll2.add(5,0);ll2.add(6,1);ll2.add(77,2);ll2.add(78,3);
        System.out.println(ll2.cycleDetection(ll2.head));
        ll2.addCycle(2);
        System.out.println(ll2.cycleDetection(ll2.head));
        ll2.cycleRemoval(ll2.head);
        System.out.println("Cycle detected="+(ll2.cycleDetection(ll2.head)));
        LinkedList ll1= new LinkedList();
        ll1.add(1,0);
        ll1.add(2,1);
        ll1.add(2,2);
        ll1.add(1,3);
        // Palindromic LinkedList
        System.out.println("Palindrome="+ll1.palindromeLinkedList(ll1.head));
        //Middle Element of the LinkedList
        System.out.println(ll1.middleOfTheLinkedList());



    }
}
