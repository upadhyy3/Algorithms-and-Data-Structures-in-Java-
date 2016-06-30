package String;

import java.util.*;

public class removeInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        DFS(s,0,0,0,"",set,getPair(s));
        for(String t:set) {
            res.add(t);
        }
        return res;
    }
    public void DFS(String s, int i, int left, int right,String cur, Set<String> res, int maxPair) {
        if(i > s.length() || left > maxPair || right > left) {
            return;
        }
        if(i == s.length() ) {
            if(right == maxPair) {
                res.add(new String(cur));
            }
            return;
        }
        String c = s.substring(i,i+1);
        switch(c) {
            case "(":
                DFS(s,i+1,left+1,right,cur+c,res,maxPair);
                DFS(s,i+1,left,right,cur,res,maxPair);
                break;
            case ")":
                DFS(s,i+1,left,right+1,cur+c,res,maxPair);
                DFS(s,i+1,left,right,cur,res,maxPair);
                break;
            default:
                DFS(s,i+1,left,right,cur+c,res,maxPair);
        }
    }

    public int getPair(String s) {
        int left = 0;
        int res = 0;
        for(int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(':
                    left++;
                    break;
                case ')':
                    if(left > 0) {
                        left--;
                        res++;
                    }
                    break;
                default :
                    break;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "()())()";
		removeInvalidParentheses obj = new removeInvalidParentheses();

	}

}
