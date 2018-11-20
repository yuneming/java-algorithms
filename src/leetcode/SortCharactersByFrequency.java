package leetcode;

import java.util.HashMap;

/**
 * leetcode 451
 */
public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        if (s == null || s.length() <= 2){
            return s;
        }
        int length = s.length();
        // 统计各个字符出现的次数
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++){
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else {
                map.put(ch,1);
            }
        }
        // 求出各种频率的字符
        StringBuilder[] sb = new StringBuilder[length+1];
        int max = 0;
        for (char c:map.keySet()){
            int fre = map.get(c);
            if (sb[fre] == null){
                sb[fre] = new StringBuilder();
            }
            if (fre > max){
                max = fre;
            }
            for (int i = 0; i < fre; i++){
                sb[fre].append(c);
            }
        }
        //最后ret把各种频率的字符由高到低连接起来
        StringBuilder ret=new StringBuilder();
        for(int i=max;i>0;i--){
            if(sb[i]!=null)
                ret.append(sb[i]);
        }
        return ret.toString();
    }
    public static void main(String[] args){
        String s = "eeeee";
        System.out.println(frequencySort(s));
    }
}
