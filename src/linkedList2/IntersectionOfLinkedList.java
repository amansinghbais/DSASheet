package linkedList2;

// Problem Statement: Given the heads of two singly linked-lists headA and headB, return the node at which the two lists
// intersect. If the two linked lists have no intersection at all, return null.

import linkedList.LL;

import java.util.HashSet;

public class IntersectionOfLinkedList extends LL {
    //Let m be the length of list1 and n be the length of the list2.
    /*
        Method-1 : Brute Force Approach
        . Take a list and Iterate over this list and for each node
        . Iterate on second list and if the node on first list matches the node on the second list return the intersection
          node
        . If we complete the iteration for both list
        . Return null such that no intersection is found

        Time Complexity - O(m * n)
        Space Complexity - O(1)
    */
    public static Node bruteApproach(Node h1 , Node h2){
        Node temp;
        while(h1 != null){
            temp = h2;
            while(temp != null){
                if(temp == h1){
                    return temp;
                }
            }
        }
        return null;
    }

    /*
        Method-2 : Using Hashing
            -Iterate through list 1 and hash its node address.
            -Iterate through list 2 and search the hashed value in the hash table. If found, return node.
        Time Complexity - O(max(m , n))
        Space Complexity - O(min(m , n))
    */
    public static Node method2UsingHashing(Node h1 , Node h2){
        HashSet<Node> set = new HashSet<>();
        while(h1 != null){
            set.add(h1);
            h1 = h1.next;
        }

        while(h2 != null){
            if(set.contains(h2)){
                return h2;
            }
            h2 = h2.next;
        }
        return null;
    }

    /*
        Method-3 : Counting the difference in the length of arrays.
        Algo:
            -Firstly we calculate the length of both the list and calculate the difference in the length.
            -We move the head pointer of the larger list further by difference of lengths.
            -Now we simultaneously move further both the head pointer and when we find the intersection return the
             intersection node
            -if we reach the null pointer then return the null pointer
        Time Complexity - O(max(m , n))
        Space Complexity - O(1)
    */
    public static Node method3CountingLength(Node h1 , Node h2){
        if(h1 == null || h2 == null){
            return null;
        }
        Node temp1 = h1 , temp2 = h2;
        int count1 = 0 , count2 = 0;
        //Calculating the length of both the lists.
        while(temp1 != null || temp2 != null){
            if(temp1 != null){
                count1++;
                temp1 = temp1.next;
            }
            if(temp2 != null){
                count2++;
                temp2 = temp2.next;
            }
        }
        //Moving ahead the head of the larger list (difference of both list) times.
        int diff = Math.abs(count1 - count2);
        if(count1 > count2){
            while (diff-- > 0){
                h1 = h1.next;
            }
        }else{
            while(diff-- > 0){
                h2 = h2.next;
            }
        }
        //Traversing over both the lists and checking whether nodes of both the list intersect or not.
        while(h1 != null && h2 != null){
            if(h1 == h2){
                return h1;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }
    /*
        Method-4 : Optimal Solution
        Approach:---
        The difference of length method requires various steps to work on it. Using the same concept of difference of
        length, a different approach can be implemented. The process is as follows:-

        -Take two dummy nodes for each list. Point each to the head of the lists.
        -Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating
         until they collide
        Time Complexity - o(max(m , n))
        Space Complexity - O(1)
    */
    public static Node optimalSolution(Node h1 , Node h2){
        if(h1 == null || h2 == null){
            return null;
        }
        Node temp1 = h1;
        Node temp2 = h2;
        while(temp1 != temp2){
            temp1 = temp1 == null?h2 : temp1.next;
            temp2 = temp2 == null?h1 : temp2.next;
        }
        return temp1;
    }


    public static void main(String[] args) {
        LL list1 = new LL();
        LL list2 = new LL();

        list2.add(3);
        list2.add(2);
        list2.add(4);
        list1.add(1);
        list1.add(3);
        list1.add(1);
        list1.add(list2.head().next);

//        Node result = bruteApproach(list1.head() , list2.head());
//        Node result = method2UsingHashing(list1.head() , list2.head());
//        Node result = method3CountingLength(list1.head() , list2.head());
        Node result = optimalSolution(list1.head() , list2.head());

        //Print the list
        if(result == null){
            System.out.println("There is no intersection in both list.");
        }else{
            System.out.println("The both the list intersects at " + result.data);
        }
    }
}
