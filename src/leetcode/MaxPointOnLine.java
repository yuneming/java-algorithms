package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * leetcode 149
 */
public class MaxPointOnLine {
    static class  Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
    public static int maxPoints(Point[] points) {
        if (points.length == 1){
            return 1;
        }
        int max =0 ;

        for (int i = 0; i < points.length; i++){
            int res = 0;
            int same =0;
            // record中存储 点i 到所有其他点的距离出现的频次
            // 距离+频次
            HashMap<Double, Integer> record = new HashMap<Double, Integer>();
            HashMap<Integer, Integer> recordx = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> recordy = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++){
                if (j != i){
                    // 计算斜率时不进行开根运算, 以保证精度
                    if ((points[i].x-points[j].x) == 0 &&(points[i].y-points[j].y) != 0){

                        if (recordx.containsKey(points[i].x)){
                            recordx.put(points[i].x, recordx.get(points[i].x) + 1);
                        }
                        else {
                            recordx.put(points[i].x,2);
                        }
                    }
                    else if ((points[i].y-points[j].y) == 0 && (points[i].x-points[j].x) != 0){

                        if (recordy.containsKey(points[i].y)){
                            recordy.put(points[i].y, recordy.get(points[i].y) + 1);
                        }
                        else {
                            recordy.put(points[i].y,2);
                        }
                    }else if ((points[i].y-points[j].y) == 0 && (points[i].x-points[j].x) == 0){
                        same++;
                    }
                    else {
                        double slope = slope(points[i], points[j]);
                        if (record.containsKey(slope)){
                            record.put(slope, record.get(slope) + 1);
                        }
                        else {
                            record.put(slope,2);
                        }
                    }

                }
            }
            for(Double slope: record.keySet())
                if (record.get(slope) > res){
                    res = record.get(slope);
                }
            for(Integer slope: recordx.keySet())
                if (recordx.get(slope) > res){
                    res = recordx.get(slope);
                }
            for(Integer slope: recordy.keySet())
                if (recordy.get(slope) > res){
                    res = recordy.get(slope);
                }
            if (res == 0){
                max = ++same;
            }else
            {max = Math.max(max,res+same);}

        }
        return max;

    }

    /**
     * 使用斜率计算会出现精度问题
     * 系统会把94911150/94911151和94911152/94911151当成同一个数
     */
    public static int maxPointsII(Point[] points){
        if (points.length <= 1) {
            return points.length;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++){
            //过当前点的直线组成的哈希表，斜率为key
            HashMap<Double, Integer> lines = new HashMap<Double, Integer>();
            int vertical = 0, same = 1, currMax = 0;
            for (int j = i+1; j < points.length; j++){
                // 统计相同的点
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    same++;
                    continue;
                }
                // 统计斜率为无穷的点，他们都在一条直线上
                if(points[i].x == points[j].x){
                    vertical++;
                    continue;
                }
                // 计算连线的斜率
                double slope = ((double)points[i].y - (double)points[j].y) / ((double)points[i].x - (double)points[j].x);
                // 修正负0
                if(slope * slope == 0) slope = 0;
                lines.put(slope, lines.containsKey(slope) ? lines.get(slope) + 1 : 1);
                currMax = Math.max(currMax, lines.get(slope));
            }
            // 经过该点的直线上最多的点数，我们在无穷斜率和正常斜率中选较大的，还要加上相同的点数
            currMax = Math.max(vertical, currMax) + same;
            max = Math.max(currMax, max);
        }
        return max;
    }

    /**
     * 利用最大公约数解决精度问题
     */
    public static int maxPointsIII(Point[] points){
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Map<Integer, Integer>, Integer> m = new HashMap<>();
            int duplicate = 1;
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    ++duplicate; continue;
                }
                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                int d = gcd(dx, dy);
                Map<Integer, Integer> t = new HashMap<>();
                t.put(dx / d, dy / d);
                m.put(t, m.getOrDefault(t, 0) + 1);
            }
            res = Math.max(res, duplicate);
            for (Map.Entry<Map<Integer, Integer>, Integer> e : m.entrySet()) {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }

    /**
     * 使用时间复杂度为O(n^3)的解法
     * 其中判断三点共线三种方法，斜率法，面积法，周长法，其中面积法效率最高，才能遍历三遍AC
     * 而且比上面一种方法更快
     */
    public static int maxPointsIV(Point[] points){
        int res = 0, n = points.length;
        for (int i = 0; i < n; ++i) {
            int duplicate = 1;
            for (int j = i + 1; j < n; ++j) {
                int cnt = 0;
                long x1 = points[i].x, y1 = points[i].y;
                long x2 = points[j].x, y2 = points[j].y;
                if (x1 == x2 && y1 == y2) {++duplicate;continue;}
                for (int k = 0; k < n; ++k) {
                    int x3 = points[k].x, y3 = points[k].y;
                    if (x1*y2 + x2*y3 + x3*y1 - x3*y2 - x2*y1 - x1 * y3 == 0) {
                        ++cnt;
                    }
                }
                res = Math.max(res, cnt);
            }
            res = Math.max(res, duplicate);
        }
        return res;
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private static double slope(Point pa, Point pb){
        if ((pa.x - pb.x) > (pa.y - pb.y)){
            return (pa.x - pb.x)/(pa.y - pb.y);
        }
        else {
            return (pa.y - pb.y) / (pa.x - pb.x);
        }

    }

    public static void main(String[] args){
        Point a = new Point(0,0);
        Point b = new Point(94911151,94911150);
        Point c= new Point(94911152,94911151);
        Point d = new Point(9,-25);
        Point e = new Point(2,3);
        Point f = new Point(1,4);
        Point[] pp = {a,b,c};
        System.out.println(maxPointsII(pp));


    }

}
