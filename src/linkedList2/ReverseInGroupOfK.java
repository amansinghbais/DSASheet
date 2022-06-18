package linkedList2;

import linkedList.LL;

public class ReverseInGroupOfK extends LL {

    public static int length(Node head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    /*
        Solution:--
            -Create a dummy node. Point next to this node to head of the linked list provided.
            -Iterate through the given linked list to get the length of the list.
            -Create three pointer pre,cur and nex to reverse each group. Why? If we observe output, we can see that we
            -have to reverse each group, apart from modifying links of group.
            -Iterate through the list until the length of list to be processed is greater than and equal to given k.
            -For each iteration, point cur to pre->next and nex to nex->next.
            -Start nested iteration for length of k.
           - For each iteration, modify links as following steps:-
                cur->next = nex->next
                nex->next = pre->next
                pre->next = nex
                nex = cur->next
                -Move pre to cur and reduce length by k.
        Time Complexity - O(n)
        Space Complexity - O(1)
    */

    public static Node reverseGroup(Node head , int k){
        if(head == null){
            return null;
        }else if(head.next == null){
            return head;
        }

        int size = length(head);
        Node dummyNode = new Node(0);
        dummyNode.next = head;

        Node curr = null;
        Node prev = dummyNode;
        Node nex = null;

        while(size >= k){
            curr = prev.next;
            nex = curr.next;
            for(int ind = 1 ; ind < k ; ind++){
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            size -= k;
        }
        return dummyNode.next;
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
        list.add(8);
        list.add(9);

        Node res = reverseGroup(list.head() , 3);

        list.printList(res);
    }
}
