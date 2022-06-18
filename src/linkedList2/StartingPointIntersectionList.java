package linkedList2;
import linkedList.LL;

//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

public class StartingPointIntersectionList extends LL {

    /*
        Solution: ---
            -Using Two pointer fast and slow pointing to head
            -Incrementing fast pointer to two place and slow pointer to single place if they collide
            -Assign head to the fast pointer and again traverse for slow and fast pointer but increment both single time
            -and when both collide return the node where both collides
        Time Complexity - O(n)
        Space Complexity - O(1)

    */
    public static Node solution(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){ return null; }

        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
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


        Node result = solution(list.head());

        if(result == null){
            System.out.println("There is no cycle in the list.");
        }else{
            System.out.println("The cycle in following linked list start at " + result.data);
        }

    }
}
