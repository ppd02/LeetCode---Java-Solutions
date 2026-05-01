/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null){
            return head;
        }
        if(left == right){
            return head;
        }

        ListNode temp = head;
        List<Integer> arr = new ArrayList<>();
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        // System.out.println(arr);
        
        while(left<=right){
            int i = arr.get(left-1);
            arr.set(left-1, arr.get(right-1)); 
            arr.set(right-1, i);
            right--;
            left++;
        }
        // System.out.println(arr);
        temp = head;
        int i = 0;
        while(temp != null){
            temp.val = arr.get(i++);
            temp = temp.next;
        }
        return head;
    }
}