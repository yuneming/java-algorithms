//package leetcode.Stack;
//
//
//import java.util.Stack;
//
//public class BackspaceStringCompare{
//    public boolean backspaceCompare(String S, String T) {
//        Stack<Character> sc = new Stack<Character>();
//        Stack<Character> tc = new Stack<Character>();
//       for(int i=0;i<S.length();i++){
//        Character ch = S.charAt(i);
//           if(ch=='#'){
//               if(sc.size()==0){
//                   return false;
//               }
//               else{
//                   sc.pop();
//               }
//
//           }
//           else{
//               sc.put(ch);
//           }
//        }
//         for(int i=0;i<T.length();i++){
//            Character ch = T.charAt(i);
//           if(ch=='#'){
//               if(tc.size()==0){
//                   return false;
//               }
//               else{
//                   tc.pop();
//               }
//
//           }
//           else{
//               tc.put(ch);
//           }
//        }
//        if(sc.size()!=tc.size()){
//            return false;
//        }
//        else{
//            for(int i=0;i<sc.size();i++){
//            Character ch_sc = sc.pop();
//            Character ch_tc = tc.pop();
//            if(ch_sc.equals(ch_tc)){
//                return false;
//            }
//        }
//
//        }
//        return true;
//
//
//
//
//    }
//}