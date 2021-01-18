import java.util.*;
class Solution {
    public int[] solution(long n) {
        StringBuilder s = new StringBuilder(Long.toString(n));
        s=s.reverse();
        
        int[] answer=new int[s.length()];
        for(int i=0; i<answer.length;i++){
            answer[i]=s.charAt(i)-'0';
        }
        return answer;
    }
}

/*
COMMENT
문자열을 뒤집어 배열로 만드는 문제이다. 
이 문제는 2가지 방식으로 풀 수 있다. 
1. SringBuilder의 reverse()메소드를 이용하여 숫자를 뒤집는다.
이 문자열을 순서대로 answer배열에 대입한다. 
이때 char형 문자를 int로 바꾸기 위해 '0'의 아스키코드 값을 뺐다. 

2. 나머지 연산 이용
import java.util.*;

class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (n > 0) {
            arr.add((int)(n % 10));
            n /= 10;
        }

        int[] answer = new int[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}

나머지 연산을 이용하여 문자열을 뒤집어 list에 저장한고, 
list의 값을 순서대로 꺼내어 int형 배열에 대입한다. 

*/