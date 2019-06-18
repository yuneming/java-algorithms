package newcoder.offer;

import java.util.LinkedList;
import java.util.List;

public class LastRemainingCicle62 {
    // 用环形链表模拟圆圈
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 要删除元素的位置
        int idx = 0;
        // 开始计数的位置
        int start = 0;
        while (list.size() > 1) {
            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                idx = (idx + 1) % list.size();
            }
            list.remove(idx);

        }
        return list.get(0);

    }
    public int LastRemaining_Solution1(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution1(n-1, m) + m) % n;
    }


}
