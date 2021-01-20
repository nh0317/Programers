import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        if (Math.sqrt(n) == Math.floor(Math.sqrt(n)))
            answer=(long)Math.pow(Math.sqrt(n)+1,2);
        else answer=-1;
        
        return answer;
    }
}

/*
COMMENT
n이 어떤 양의 정수의 제곱인지 판단하는 문제이다
간단하게 n의 제곱근이 n의 제곱근을 내림한 값과 같으면 
정수라고 판단했다.  
*/