import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        
        while(n>0){
            tmp.add((int)(n%10));
            n/=10;
        }
        
        tmp.sort((a,b)->b-a);
        
        for(Integer a : tmp)
            answer= answer*10+a;
        return answer;
    }
}

/*
COMMENT

정수를 내림차순으로 정렬하는 문제이다. 
푸는 방법은 매우 다양하지만
간단하게 각 자릿수를 list에 넣고 list를 내림차순으로 정렬한 다음 
다시 long형 정수로 변환했다. 
*/