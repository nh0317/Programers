
class Solution {
  public long solution(int a, int b) {
      long answer = 0;
      if(a > b) {
          int t = a;
          a = b;
          b = t;
      }
      for(int i=a; i<=b; i++) {
          answer += i;
      }
      return answer;
  }
}

/*
COMMENT

문제는 매우 간단하지만 등차 수열의 합 공식을 사용하면 더 간단하게 풀 수 있다. 

return (long) (b-a+1)*(a+b)/2;
*/