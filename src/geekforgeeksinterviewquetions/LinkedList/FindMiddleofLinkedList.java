package geekforgeeksinterviewquetions.LinkedList;
/**
 * 
 * Given a singly linked list of N nodes.
The task is to find the middle of the linked list. For example, if the linked list is
1-> 2->3->4->5, then the middle node of the list is 3.
If there are two middle nodes(in case, when N is even), print the second middle element.
For example, if the linked list given is 1->2->3->4->5->6, then the middle node of the list is 4.
 * 
 * 
 */
public class FindMiddleofLinkedList {

Node head;
    class Node{
        int data;
        Node next;
        Node(int d)
        {
            data=d;
            next=null;
        }
    }

public void add(int d)
{
    Node newNode =new Node(d);
    if(head == null)
    {
head=newNode;
    }
    else
    {
     Node currNode=head;
    while(currNode.next!=null)
    {
        currNode=currNode.next;
    }
   currNode.next=newNode;

    }

}
    public int getMiddle()
    {
        Node fast=this.head;
        Node slow=this.head;
        //1 2 3 4 5 6 7 8 9
        while(fast!=null && fast.next!=null)
        {
        
            slow=slow.next;
            System.out.println("Slow:"+slow.data);

            fast=fast.next.next;
            System.out.println("Fast:"+fast.data);
        }
        return slow.data;
    }

    public static void main(String[] args)
    {
        FindMiddleofLinkedList linkedList=new FindMiddleofLinkedList();
        for(int i=1;i<=9;i++)
        {
            linkedList.add(i);
        }

        System.out.println(linkedList.getMiddle());
    }





}



    

