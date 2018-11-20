package leetcode;

import java.util.TreeMap;

/**
 * leetcode 290
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        int len = pattern.length();
        String[] arrOfStr = str.split(" ");
        if (len != arrOfStr.length){
            return false;
        }
        TreeMap<Character,String> patternToStr = new TreeMap<>();
        TreeMap<String,Character> strToPattern = new TreeMap<>();
        for (int i = 0; i < len; i++){
            char c = pattern.charAt(i);
            if (!patternToStr.containsKey(c) && !strToPattern.containsKey(arrOfStr[i])){
                patternToStr.put(c,arrOfStr[i]);
                strToPattern.put(arrOfStr[i],c);
            }else if (patternToStr.containsKey(c) && !arrOfStr[i].equals(patternToStr.get(c))){
                return false;
            }
            else  if (strToPattern.containsKey(arrOfStr[i]) && c != strToPattern.get(arrOfStr[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串和模式是一一映射的关系，利用Map这个数据结构
     * 比上面一种方法更加好，少用了一个map,代码更简练
     */
    public boolean wordPatternII(String pattern, String str) {
        char[] patterms = pattern.toCharArray();
        TreeMap<Character,String> maps = new TreeMap<>();
        String[] strs = str.split(" ");
        if (patterms.length != strs.length){
            return false;
        }
        for (int i = 0; i < patterms.length; i++){
            char ch = patterms[i];
            if (maps.containsKey(ch)){
                String value = maps.get(ch);
                if (!value.equals(strs[i])){
                    return false;
                }
            }
            else {
                if (maps.containsValue(strs[i])){
                    return false;
                }
                maps.put(ch,strs[i]);


            }
        }
        return true;
    }

}
