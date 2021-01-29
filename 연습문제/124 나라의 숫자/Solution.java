class Solution {
    public String solution(int n) {
        long result=0;
        while(n!=0){
            if(n%3!=0){
            result = (long)(result*10) + n%3;
            n/=3;
            }
            else {
                result=(long)(result*10) + 4;
                n=n/3-1;
            }
        }
        StringBuilder answer = new StringBuilder(Long.toString(result));
        return answer.reverse().toString();
    }
}

/*
COMMENT

10진법 자연수를 124만 이용하여 표현하는 문제이다. 

예를 들어 
10진법 	124
1	1
2	2
3	4
4	11
9	24
13	111

이 문제는 규칙성을 파악하는 것이 핵심이다. 

우선 3의 배수를 제외한 숫자는 3진법으로 나타낸다. 

3의 배수인 경우에는 몫에 1을 빼고, 나머지를 4를 더한다.
만약 몫에 1을 뺀 값이 3의 배수가 아니라면 다시 3진법으로 나타내고,
몫이 3의 매수인 경우에는 이 과정을 반복한다.

이와 같은 방법으로 result를 구할 수 있다. 
단 result을 한 번 뒤집어야 원하는 값을 얻을 수 있다. 

*/