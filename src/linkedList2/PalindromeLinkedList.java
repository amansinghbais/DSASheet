package linkedList2;
import linkedList.LL;

import java.util.ArrayList;

//Problem Statement: Given the head of a singly linked list, return true if it is a palindrome.

public class PalindromeLinkedList extends LL {

    //Method-1 : Using Extra ArrayList
    // In this we store all the node value in arraylist
    // Then we traverse over arrayList and check whether the list is palindrome or not
    // Time Complexity - O(n)
    // Space Complexity - O(n)
    public static boolean method1UsingSpace(Node head){
        ArrayList<Integer> list = new ArrayList<>();
        int ind = 0;
        while(head != null){
            list.add(head.data);
            head = head.next;
            ind++;
        }
        int n = list.size();
        for(int i = 0 ; i < n/2 ; i++){
            if(list.get(i) != list.get(n - i - 1)){
                return false;
            }
        }
        return true;
    }

    /*
        Method-2 : Using two Pointer Approach
        In this we use two pointer fast and slow pointing to the head.
        Then we traverse over the list and move slow pointer by one while fast pointer by 2
        When fast pointer reaches end of the list the slow pointer is pointing to the middle node of the list
        Now we reverse the list from the middle to the end and then check the list for palindrome.
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static boolean method2UsingTwoPointer(Node head){
        if(head == null || head.next == null){
            return false;
        }
        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;

        while(slow != null && head != null){
            if(slow.data != head.data){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        list.add(5);
        list.add(3);
        list.add(2);
        list.add(1);

//        boolean res = method1UsingSpace(list.head());
        boolean res = method2UsingTwoPointer(list.head());

        //Printing the Result.
        if(res){
            System.out.println("Yes! The list is Palindrome.");
        }else{
            System.out.println("No! The list is not a Palindrome");
        }

    }

    //Function to reverse the linked list.
    public static Node reverse(Node head){
        Node curr = head , nex = null , prev = null;
        while(curr!= null){
            nex = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }

}
