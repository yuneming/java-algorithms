package newcoder.leetcodeCS.sort;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    // 找到倒数第k大的元素
    public int findKthLargest(int[] nums, int k) {
        // 优先队列默认为小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
