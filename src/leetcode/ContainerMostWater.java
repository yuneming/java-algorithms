package leetcode;

/**
 * leetcode 11
 */
public class ContainerMostWater {
    public static int maxArea(int[] height){
        int left = 0, right = height.length-1;
        int maxArea = 0;
        while (left <= right){
            int area = (right-left)*Math.min(height[left],height[right]);
            if (area > maxArea){
                maxArea = area;
            }
            if (height[left] <= height[right]){
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = maxArea(height);
        System.out.println(area);
    }
}
