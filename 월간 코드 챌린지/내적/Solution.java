class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i<a.length;i++)
            answer+=a[i]*b[i];
            
        return answer;
    }
}

/*
COMMNET
내적을 구하는 문제
for문을 통해 간단하게 구할 수 있다. 
*/