package linkedList;

//Given the heads of two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
//order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

public class SumTwoLinkedList extends LL {

    //Solution
    // Keep track of the carry using a variable and simulate digits-by-digits sum starting from the head of the list,
    // which contains the least significant digit.
    //Time Complexity - O(max(n , m))
    //Space Complexity - O(max(m , n))

    public static Node solution(Node h1 , Node h2){
        int currSum = 0 , carry = 0;
        Node dummyNode = new Node(0);
        Node temp = dummyNode;
        //Traverse over both list until both the list becomes null.
        while(h1 != null || h2 != null){
            currSum = 0;
            if(h1 != null){
                currSum += h1.data;
                h1 = h1.next;
            }
            if(h2 != null){
                currSum += h2.data;
                h2 = h2.next;
            }
            currSum += carry;
            //If sum of both element and carry becomes more than 10 then take its one's digit as currValue and ten's
            //value as the carry and iterate again.
            if(currSum >= 10){
                carry = currSum / 10;
                currSum = currSum % 10;
            }else{
                carry = 0;
            }
            temp.next = new Node(currSum);
            temp = temp.next;
        }
        //After we finish working with the both lists if there is any carry left then make a new node and add it in the
        //output/result linked list.
        if(carry > 0){
            temp.next = new Node(carry);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        LL list1 = new LL();
        LL list2 = new LL();
        //First List
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);
        //Second List
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);

        Node res = solution(list1.head() , list2.head());

        list1.printList(res);
    }
}
