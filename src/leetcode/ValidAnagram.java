package leetcode;

import java.util.TreeMap;
import java.util.zip.Deflater;

/**
 * leetcode 242
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s==null || t==null || t.length() < s.length()){
            return false;
        }
        TreeMap<Character,Integer> record = new TreeMap<Character, Integer>();
        for (int i = 0; i < s.length();i++){
            if (!record.containsKey(s.charAt(i))){
                record.put(s.charAt(i),1);
            }
            else {
                record.put(s.charAt(i),record.get(s.charAt(i))+1);
            }
        }


        for (int i = 0; i < t.length(); i++){
            if (!record.containsKey(t.charAt(i)) ){
                return false;
            }
            else {
                record.put(t.charAt(i),record.get(t.charAt(i))-1);
            }
            if (record.get(t.charAt(i)) < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s = "aacc";
        String t = "ccac";
        boolean b = isAnagram(s,t);
        System.out.println(b);
    }
}
