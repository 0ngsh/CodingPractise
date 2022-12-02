package geekforgeeksinterviewquetions.LinkedList;
// Java program to detect and remove loop in linked list
public class RemoveLoopInLinkedList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            this.data=d;
            this.next=null;
        }



    }


    int detectAndRemoveLoop(Node head){
    
        Node slow=head;
        Node fast= head;
        while(slow!=null && fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next.next; //for these  fast.next!=null in while loop
          if (slow==fast)
          {
            removeLoop(slow,head);
            return 1;
          }

        }

        return 0;
    }


    void removeLoop(Node loop, Node head)
    {
        Node ptr1=loop;
        Node ptr2=loop;
        int k=1,i;
        
        Node prevNode=ptr1;
        while(ptr1.next!=ptr2) 
        {
            prevNode=ptr1;
            ptr1=ptr1.next;
            k++;
        }
        
        System.out.println(prevNode.data);
        prevNode.next=null;


//         //k=3;

      
//         //fix one pointer to head
//         ptr1=head;
//         // And the other pointer to k nodes after head
//         ptr2=head;
//         for(i=0;i<k;i++)
//         {
//             ptr2=ptr2.next;
//         }

//         /*  Move both pointers at the same pace,
//          they will meet at loop starting node */

//         while(ptr1!=ptr2){
//             ptr1=ptr1.next;
//             ptr2=ptr2.next;

//         }

//         // Get pointer to the last node
//         while(ptr2.next!=ptr1)
//         {
//             ptr2=ptr2.next;
//         }
//        /* Set the next node of the loop ending node
//                  to fix the loop */
//         ptr2.next=null;



    }

   void printList(Node node)
   {
    while(node!=null)
    {
        System.out.println(node.data);
        node=node.next;
    }
   }


    public static void main(String[] args) {
        RemoveLoopInLinkedList linkedList=new RemoveLoopInLinkedList();
        // linkedList.head=new Node(50);
        // linkedList.head.next=new Node(20);
        // linkedList.head.next.next=new Node(15);
        // linkedList.head.next.next.next=new Node(4);
        // linkedList.head.next.next.next.next=new Node(10);

        linkedList.head=new Node(7);
        linkedList.head.next=new Node(58);
        linkedList.head.next.next=new Node(36);
        linkedList.head.next.next.next=new Node(34);
        linkedList.head.next.next.next.next=new Node(16);




        // creatin loop for testing 
        head.next.next.next.next.next=linkedList.head.next.next.next;
       
        linkedList.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
         linkedList.printList(head);
    }
}
