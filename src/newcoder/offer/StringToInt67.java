package newcoder.offer;

public class StringToInt67 {
    public int StrToInt(String str) {
        if (str.length() == 0 || str==null) {
            return 0;
        }
        boolean isNegtive = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i ==0 &&(c == '+' || c == '-' )) {
                continue;
            }
            if (c > '9' || c < '0') {
                return 0;
            }
            ret = ret * 10 + (c-'0');
        }
        return  isNegtive ? -ret:ret;


    }
}
