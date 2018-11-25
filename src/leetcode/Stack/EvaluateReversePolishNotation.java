package leetcode.Stack;

import java.util.Stack;

/**
 * leetcode 150
 */
public class  EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        int len;
        if ((len = tokens.length) == 0)
            return 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < len; i++) {
            try {
                int tmp = Integer.valueOf(tokens[i]);
                stk.push(tmp);
            } catch (Exception e) {
                // 栈的弹出顺序，先弹后面
                int sec = stk.pop();
                // 处理一个数字是负数的情况如{"3", "-" }
                // 或者 { "6", "3", "*", "-" }
                int fir = 0;
                if (!stk.isEmpty())
                    fir = stk.pop();
                int tmp = 0;
                if (tokens[i].equals("+"))
                    tmp = fir + sec;
                if (tokens[i].equals("-"))
                    tmp = fir - sec;
                if (tokens[i].equals("*"))
                    tmp = fir * sec;
                if (tokens[i].equals("/"))
                    tmp = fir / sec;
                stk.push(tmp);
            }
        }
        return stk.pop();

    }
    public static void main(String[] args){
        String[] tokes = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"};
        System.out.println(evalRPN(tokes));
    }
}
