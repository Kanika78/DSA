//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        Node temp = head;
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        int carry = 0;
        int i = 0;
        
        while(temp != null){
            int sum = carry;
            if(i == 0){
                sum += temp.data;
                sum += 1;
            }else{
                sum += temp.data;
            }
            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            
            curr.next = newNode;
            curr = curr.next;
            temp = temp.next;
            i++;
        }
        if(carry != 0){
            Node newNode = new Node(carry);
            curr.next = newNode;
        }
        Node list = reverse(dummy.next);
        return list;
        
        
    }
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
        
    }
}
