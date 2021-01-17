class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(n%i==0)
                answer+=i;
        }
        return answer;
    }
}

/*
COMMENT
약수의 합을 구하는 문제 

for문을 n번 실행하는 대신 n의 제곱근만큼 실행하여 
효율성을 높일 수 있다. 
이 경우 i로 나눈 몫도 함께 더해야하며, 제곱수에 대한 예외처리를 해야한다. 

import java.util.*;
class Solution {
  public int solution(int n) {
     int answer = 0;

        for(int i=1;i<=Math.sqrt(n);i++) {
            if(n%i==0){
                answer+=i;
                if(i==n/i)
                    continue;
                answer+=(n/i);
            }
        }
        return answer;
    }
}
*/