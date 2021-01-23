class Solution {
    public int solution(int num) {
        int answer = 0;
        long n= (long)num;
        while (n!=1){
            if(answer>=500)
                return -1;
            if(n%2==0)
                n/=2;
            else{
                n=n*3+1;
            }
            answer++;
        }
        
        return answer;
    }
}

/*
COMMENT
공식을 이용하여 주어진 수가 1이 될때까지 반복한 작업의 횟수를 구하는 문제이다. 
단 500번 이상이면 -1을 반환한다. 

어려웠던 점
int형을 그대로 이용할 경우 오버플로우가 일어날 수 있기 때문에 
이 점을 고려해야 한다. 

*/