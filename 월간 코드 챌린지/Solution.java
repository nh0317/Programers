import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int count=0;
        TreeSet<Integer> set=new TreeSet<>();
        
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        Iterator it = set.iterator();
        for(int i=0; i<answer.length;i++){
            answer[i]=(int)it.next();
        }
        return answer;
    }
}

/*
COMMENT

코드 제출시엔 it.next().hashCode();
로 제출했지만 실제로 문제 풀이 중에 hashCode 메소드를 떠올리기 어려울 것 같아
(int)it.next();로 바꿈

어려웠던 부분
1. iterator가 반환하는 값이 Interger인데 이를 int로 변환하는 방법을 떠올리기 힘들었다. 
2. 처음에 TreeSet을 이용하지 않고 배열로만 풀려고 하니 더 어려웠다. 
(중복을 처리하기 어려웠음)
자료구조를 적절히 이용하자.
3. 그동안 인텔리 센스에 많이 의존하여 메소드가 바로 생각나지 않았다.

*/