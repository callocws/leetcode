package leetcode._138;


import leetcode.Node;

// 138. Copy List with Random Pointer
class Solution {
    public Node copyRandomList(Node head) {
        Node p, q, cl;
        for(p = head; p != null; ) {
            q = new Node(p.val);
            q.next = p.next;
            q.random = p.random;
            p.next = q;
            p = q.next;
        }
        for(p = head; p != null; ) {
            q = p.next;
            p = q.next;
            if(q.random != null) {
                q.random = q.random.next;
            }
        }
        for(p = head, cl = head == null ? null : head.next; p != null; ) {
            q = p.next;
            p.next = q.next;
            p = q.next;
            if(p != null) {
                q.next = p.next;
            }
        }

        return cl;
    }
    public static void main(String[] args) {
        // Create a linked list with random pointers
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        // Print the original list
        System.out.println("Original list:");
        printList(head);

        // Create a copy of the list
        Solution solution = new Solution();
        Node copiedList = solution.copyRandomList(head);

        // Print the copied list
        System.out.println("Copied list:");
        printList(copiedList);
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("Node value: " + temp.val);
            if (temp.random != null) {
                System.out.print(", Random points to: " + temp.random.val);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            temp = temp.next;
        }
    }

}