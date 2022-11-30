package DataStructure;

public class LinkedList {
 Node head;
    class Node{
     String data;
     Node next;
     Node(String data)
     {
        this.data=data;
        this.next=null;
     }
    }


 void add(String data)
 {
    Node newNode=new Node(data);

    if(head==null)
    {
        head=newNode;
    }
    else
    {
       Node currnetNode=head;
       while(currnetNode.next!=null)
       {
        
        currnetNode=currnetNode.next;
        
       }
      currnetNode.next=newNode;
    }
 }

 void display()
 {
    Node currnetNode=head;
    while(currnetNode.next!=null)
       {
        System.out.println(currnetNode.data);
        currnetNode=currnetNode.next;
       }
       System.out.println(currnetNode.data);
 }


 public static void main(String[] args)
 {
 LinkedList linkedList=new LinkedList();
 linkedList.add("A");
 linkedList.add("N");
 linkedList.add("G");
 linkedList.add("S");
 linkedList.add("H");
 linkedList.add("U");
 linkedList.add("M");
 linkedList.add("A");

 linkedList.display();
 }

}
