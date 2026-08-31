class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int last = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = 0;

        int index = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {

            // Check if curr is a critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                // First critical point
                if (first == -1) {
                    first = index;
                } 
                else {
                    // Distance from previous critical point
                    minDistance = Math.min(minDistance, index - last);
                }

                // Current becomes last critical point
                last = index;

                // Maximum distance
                maxDistance = last - first;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Less than 2 critical points
        if (first == last) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}