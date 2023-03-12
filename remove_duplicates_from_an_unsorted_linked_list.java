import java.util.* ;
import java.io.*; 

/************************************************************

    Following is the linked list node structure
    
    class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

************************************************************/


public class Solution {
	
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {

        // LinkedListNode<Integer> current = head;

        // while(current != null){
        //     LinkedListNode<Integer> runner = current;

        //     while(runner.next != null){
        //         if(runner.next.data == current.data){
        //             runner.next = runner.next.next;
        //         }else{
        //             runner = runner.next;
        //         }
        //     }
            
        //     current = current.next;
        // }

        // return head;

        HashMap<Integer, Boolean> map = new HashMap<>();

        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> prev = null;

        while(current != null){
            int data = current.data;
            if(map.containsKey(data)){
                prev.next = current.next;
            }else{
                map.put(data, true);
                prev = current;
            }
            current = current.next;
        }

        return head;
	}

}
