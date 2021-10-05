package com.problem.coding.medium;

import com.problem.util.ListNode;

/**
 * @author ankurmundra
 * September 30, 2021
 */
public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        if(head==null)
            return listNodes;

        int len = getLength(head);
        if(len<k)
            k = len;
        int partSize = len/k;
        int reminder = len%k;
        int part;

        for (int i = 0; i < k; i++) {
            part = partSize;
            if(reminder>0)
            {
                reminder--;
                part++;
            }

            ListNode temp = head;
            ListNode prev = head;
            for (int j = 0; j < part; j++) {
                prev = head;
                head = head.next;
            }
            prev.next = null;
            listNodes[i] = temp;
        }
        return listNodes;
    }

    private int getLength(ListNode head)
    {
        ListNode temp = head;
        int len = 0;
        while (temp!=null)
        {
            len++;
            temp = temp.next;
        }
        return len;
    }
}
