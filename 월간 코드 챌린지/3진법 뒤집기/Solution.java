import java.util.*;

class Calc{
    public static long base(int base, long number) {
        long result=0;
        while(number>0){
            result=result*10+number%base;
            number/=base;
        }
        return result;
    }
    
    public static int toDec(int base, long n){
        long result= 0;
        int index=0;
        while(n>0){
            result = result + n%10 * (long)Math.pow(base,index);
            index++;
            n/=10;
        }
        result+=n;
        return (int)result;
    }
}


class Solution {
    public int solution(int n) {
        int answer = 0;
        answer=Calc.toDec(3,Calc.base(3,n));
        return answer;
    }
}

/*
COMMENT

어려웠던 점
1. 문제의 함정
문제에서는 3진법으로 바꾼다음 앞뒤를 반전하라고 했지만, 
for문으로 진법을 구할 경우 반전된 결과가 나오기 때문에 2단계로 나누어 작성할 필요가 없다.
(처음 부터 뒤집힌 3진법을 구할 수 있음)

2. int형의 범위를 넘어서는 경우
10진법 -> 3진법의 과정에서 int의 법위를 넘어갈 수 있다. 
따라서 int형을 사용할 경우 원하는 결과값이 나오지 않는다. 
이를 방지하기 위해서는 
1) String 또는 Vector(C++)등을 이용한다. 
2) long형 또는 BigInteger를 이용한다. 
이 풀이에서는 long형을 이용하여 문제를 해결했지만, String을 이용하는 방법도 알아두자.

3. 10진법으로 변환
Math.pow메소드를 사용하지 않고 풀려고 했으나 실패했다. 
Math.pow메소드를 이용하자 쉽게 풀 수 있었다. 

*/