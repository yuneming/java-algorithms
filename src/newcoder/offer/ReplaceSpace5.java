package newcoder.offer;

public class ReplaceSpace5 {
    public String replaceSpace(StringBuffer str) {
        int p1 = str.length()-1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length()-1;
        while (p1 >=0 && p2 > p1) {
            if (str.charAt(p1) != ' ') {
                str.setCharAt(p2,str.charAt(p1));
                p2--;
                p1--;
            }else {
                str.setCharAt(p2,'0');
                p2--;
                str.setCharAt(p2,'2');
                p2--;
                str.setCharAt(p2,'%');
                p2--;
                p1--;

            }
        }
        return str.toString();

    }
}
