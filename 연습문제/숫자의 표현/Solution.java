class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 초항
        for(int i=1; i<=n; i++){
            int sum =0;

            //i부터 연속한 자연수의 합을 구한다. 
            for(int j=i; j<=n;j++){
                sum +=j;

                //합한 값이 n과 같으면 answer를 증가시키고 반복 종료
                if(sum==n){
                    answer++;
                    break;
                }

                //합한 값이 n보다 크면 반복 종료
                else if(sum>n)
                    break;
            }
        } 
        return answer;
    }
}

/*
COMMENT
연속한 자연수들로 n을 표현하는 방법의 개수를 구하는 문제이다.

이중 for문을 통해 매우 간단하게 풀 수 있다. 
우선 i를 초항으로 설정하고, i부터 연속한 자연수를 더한다.
더한 값이 n과 같으면 answer를 증가시키고 반복을 종료한다. 
이후 i의 값을 증가시켜 같은 과정을 반복한다. 
더한 값이 n보다 큰 경우에도 반복을 종료하고 같은 과정을 반복한다. 

*/