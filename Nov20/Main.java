import java.util.*;
class RecentCounter {
    java.util.Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        queue.offer(t);
        int time = t - queue.peek();
        while(time > 3000) {
            queue.poll();
            time = t - queue.peek();
        }
        return queue.size();
    }
}
class Queue
{
    private  Stack stack1=new Stack(),stack2=new Stack();
    void enqueue(int data)
    {
        if(stack1.size()==0)
        {

            stack1.push(data);

            return;
        }
stack1.push(data);
        while(stack1.size()>0)
        {
            stack2.push(stack1.pop());
            //stack1.pop();

        }

        while(stack2.size()>0)
        {
            stack1.push(stack2.pop());
            //stack2.pop();
        }
        System.out.println(stack1.size());
    }
    void deQueue()
    {
        while(stack1.size()!=0)
        {
            stack2.push(stack1.peek());
            stack1.pop();
        }
        stack2.pop();
        while(stack2.size()!=0)
        {
            stack1.push(stack2.peek());
            stack2.pop();
        }
    }
    void print()
    {

        while(stack1.size()!=0)
        {
            stack2.push(stack1.peek());
            stack1.pop();
        }
        while(stack2.size()!=0)
        {

            stack1.push(stack2.peek());
            System.out.print(stack2.peek()+" ");
            stack2.pop();
        }
    }
}

public class Main
{



    public static void main(String[] args)
    {

        //Implement Queue using Stack
        Queue queue= new Queue();
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.print();
        queue.deQueue();
        System.out.println();
        queue.print();
        // BackSpace String Compare

        String s1="abc#de",s2="ab#de";
        Stack<Character> stack= new Stack<Character>();
        Stack<Character> stack1= new Stack<>();
        for(int i=0;i<s1.length();i++)
        {
            if(stack.size()==0&&s1.charAt(i)=='#')
            {

            }
            else
            {
                if(s1.charAt(i)=='#')
                {
                    stack.pop();
                }
                else
                    stack.push(s1.charAt(i));
            }
        }
        for(int i=0;i<s2.length();i++)
        {
            if(stack1.size()==0&&s2.charAt(i)=='#')
            {

            }
            else
            {
                if(s2.charAt(i)=='#')
                {
                    stack1.pop();
                }
                else
                    stack1.push(s2.charAt(i));
            }
        }
        while(true)
        {
            if(stack.peek()==stack1.peek())
            {
                stack.pop();
                stack1.pop();
            }
            else
            {
                System.out.println("false");
                return;
            }
            if(stack.size()==0&&stack1.size()==0)
            {
                break;
            }
        }
        System.out.println("true");

    }
}
