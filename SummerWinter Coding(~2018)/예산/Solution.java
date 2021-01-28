import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        while (answer<d.length && budget-d[answer]>=0  ){
            budget-=d[answer];
            answer++;
        }
        
        return answer;
    }
}

/*
COMMENT

주어진 예산으로 지원할 수 있는 최대 부서의 수를 구하는 문제이다. 
sort메소드를 이용하여 신청한 금액을 오름차순으로 정렬하고, 
예산이 모자르거나 모든 부서를 지원하기 전까지 
예산에서 지원한 금액을 뺐다.
이때 마지막으로 지원한 부서의 인덱스+1이 정답이다. 

*/