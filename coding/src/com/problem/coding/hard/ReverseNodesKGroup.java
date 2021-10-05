package com.problem.coding.hard;

import com.problem.util.ListNode;

/**
 * @author ankurmundra
 * September 30, 2021
 */
public class ReverseNodesKGroup {
//278840342979151
    public ListNode reverseKGroup(ListNode head, int k) {
    boolean flag = true;
    ListNode sentinel = new ListNode(0);
    ListNode sentinelCopy = sentinel;
    ListNode root;
    while (flag)
    {
        root = head;
        for (int i = 0; i < k; i++) {
            if(root!=null)
                root = root.next;
            else {
                flag = false;
                break;
            }
        }
        if(flag)
        {
            sentinelCopy.next = reverseList(head, root,k);
            for (int i = 0; i < k; i++)
                sentinelCopy = sentinelCopy.next;
            head = root;
        }
    }
    return sentinel.next;
}

    private ListNode reverseList(ListNode head, ListNode root, int k)
    {
        ListNode current;
        do{
            current = head;
            head = head.next;
            current.next = root;
            root = current;
            k--;
        }
        while (k > 0);
        return root;
    }
}
