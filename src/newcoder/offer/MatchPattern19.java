package newcoder.offer;

public class MatchPattern19 {
    public boolean match(char[] str, char[] pattern)
    {
        int j = 0;
        if (str.length ==0 && pattern.length==0){
            return true;
        }
        if (str.length ==0 && pattern.toString() == ".") {
            return false;
        }
        if (str.length ==0 && pattern.toString() == ".*") {
            return true;
        }
        for (int i = 0; i < str.length; i++){
            if (str[i] == pattern[j]) {
                j++;
            }
            else if (pattern[j] == '.'){
                j++;
            }
            else if (pattern[j+1] == '*'){
                j+=2;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
