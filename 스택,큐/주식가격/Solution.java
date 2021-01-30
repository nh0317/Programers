import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        ArrayList<Integer> list = new ArrayList<>();
        int check=0;
        
        for(int i=0; i<prices.length;i++){
            check=0;
            for(int j=i+1; j<prices.length;j++){
                if(prices[i]<=prices[j])
                    check++;
                else {check++; break;}
            }
            list.add(check);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length;i++)
            answer[i]=list.get(i);
        return answer;
    }
}

/*
COMMENT

초 단위로 기록된 가경이 담긴 배열이 prices이다.
이때 가격이 떨어지지 않은 기간은 몇초인지 구하여라 

입출력 예
prices		return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]

입출력 예 설명
1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.


코드 설명 및 어려웠던 점
i번째 요소와 그 다음 요소들을 비교하여 
가격이 상승하거나 같으면 check를 증가시키고 
가격이 하락하면 break를 통해 반복문에서 빠져나온다. 

처음에는 이 break문을 걸지 않아, 
가격이 하락하고도 그 이후의 값과 i번째 요소를 비교하여 
원하지 않는 값이 반환되었다. 

스택/큐와 관련된 문제이므로 아래는 스택을 이용한 코드이다.
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int check=0;
        for(int i=0; i<prices.length;i++){
            check=0;
            for(int j=i+1; j<prices.length;j++){
                if(prices[i]<=prices[j])
                    check++;
                else {check++; break;}
            }
            stack.push(check);
        }
               
        int[] answer = new int[stack.size()];
        for(int i=answer.length-1; i>=0&&!stack.isEmpty();i--)
            answer[i]=stack.pop();
        
        return answer;
    }
}


*/