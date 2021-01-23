class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int n : arr)
            answer+=n;
        answer/=arr.length;
        return answer;
    }
}

/*
COMMENT

평균값을 구하는 문제이다.
for문을 이용하여 간단하게 구할 수 있다. 
*/