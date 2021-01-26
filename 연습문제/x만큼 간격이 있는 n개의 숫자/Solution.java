class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long a = (long) x;
        
        for(int i=0; i<n;i++)
            answer[i] =  (long) a+i*a;
        
        return answer;
    }
}

/*
COMMENT

x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴하는 문제이다. 
int 형으로 계산하는 경우 오버플로우의 위험이 있으므로 
long형으로 바꿔 계산해야한다. 
*/