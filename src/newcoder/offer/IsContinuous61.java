package newcoder.offer;

import java.util.Arrays;

public class IsContinuous61 {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        // 统计癞子数量
        int cnt = 0;
        for (int num : numbers){
            if (num == 0) cnt++;
        }
        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < numbers.length-1; i++) {
            if (numbers[i+1] == numbers[i]) {
                return false;
            }
            cnt -= numbers[i+1] - numbers[i] -1;
        }
        return cnt >=0;
    }
}
