import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> check = new Stack<>();
        
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='(')
                check.push("(");
            else if (s.charAt(i)==')'){
                if(check.isEmpty())
                    return false;
                else check.pop();
                }
        }
        if(check.isEmpty())
            return true;
        else return false;
    }
}

/*
COMMENT 

괄호가 바르게 짝지어 있는지 검사하는 문제이다. 

만약 s문자열에 "("가 있으면 스택에 "("를 넣는다.
만약 ")"가 있으면 스택에서 "("를 뺀다. 

s문자열을 모두 탐색한 후에도 스택이 비어있지 않다면,
"("가 많아 괄호가 바르게 짝지어지지 않은 것이다. 

만약 s 문자열을 탐색하는 중에 stack underflow가 발생했다면, 
")"가 많은 경우 이다. 

즉 s문자열을 정상적으로 모두 탐색하고, 스택이 비어있는 경우에만 
괄호가 바르게 짝지어 있다고 판단할 수 있다. 

*/