package linkedList2;

// Problem Statement: Given head, the head of a linked list, determine if the linked list has a cycle in it. There is a
// cycle in a linked list if there is some node in the list that can be reached again by continuously following the next
// pointer.
// Return true if there is a cycle in the linked list. Otherwise, return false.

import linkedList.LL;

import java.util.HashSet;

public class DetectCycle extends LL {

    /*
        Method-1 : Using hashing
        Approach:--
            Create a hashSet to store the nodes.
            Iterate over the list and if current Node is present in the HashSet then return true
            If we iterate successfully to the end i.e., null means there exist no cycle and hence return false.
        Time Complexity - O(n)
        Time Complexity - O(n)
    */
    public static boolean method1UingHashing(Node head){
        if(head == null || head.next == null){
            return false;
        }
        HashSet<Node> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /*
        Method-2 : Using Two Pointer Approach
        Take two pointer fast and slow and point them to head
        Now iteratively increase fast pointer by 2 and slow pointer by 1 until both collide
        If both Collides means there is cycle and if fast pointer becomes null means there is no cycle.

        Time Complexity - O(n)
        Space Complexity -O(1)
    */
    public static boolean method2UsingTwoPointer(Node head){
        if(head == null || head.next == null){
            return false;
        }

        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
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
        list.add(list.head().next.next);

//        boolean res = method1UingHashing(list.head());
        boolean res = method2UsingTwoPointer(list.head());

        //Printing the result
        if(res){
            System.out.println("Yes! Cycle exists in the loop.");
        }else{
            System.out.println("No! Cycle not exists in the loop.");
        }
    }
}
