package linkedList;

//Given a linked list, and a number N. Find the Nth node from the end of this linkedlist, and delete it. Return the
//head of the new modified linked list.

public class RemoveNthNodeFromLast extends LL{

    //Naive Approach : By Traversing the list two times
    // We can traverse through the Linked List while maintaining a count of nodes, let’s say in variable count ,and then
    // traversing for the 2nd time for (n – count) nodes to get to the nth node of the list.
    // Time Complexity - o(n)
    public static void naiveApproach(Node head , int n){
        int count = 0;
        Node temp = head;

        while(temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println(count);
        count = count - n - 1;
        while(count-- > 0){
            head = head.next;
        }
        head.next = head.next.next;
    }

    //  Optimal Approach : Using modified two pointer approach
    //      -We will take two pointer slow and faster pointing to head of the list.
    //      -Start traversing until the fast pointer reaches the nth node.
    //      -Now start traversing by one step both of the pointers until the fast pointers reach the end.
    //      -When fast pointer reach the end do the deleting part on the slow pointer.
    // Time complexity - O(n)
    public static void optimalApproach(Node head , int n){
        Node slow = head , fast = head;
        for(int i = 0  ; i < n ; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        int n = 3;

//        naiveApproach(list.head() , n);
        optimalApproach(list.head() , n);

        list.printList();
    }
}
