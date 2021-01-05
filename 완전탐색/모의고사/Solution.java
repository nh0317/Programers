import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] first={1,2,3,4,5};
        int[] second={2,1,2,3,2,4,2,5};
        int[] third={3,3,1,1,2,2,4,4,5,5};
        
        int[] count=new int[3];
        for(int i=0, index=0; i<answers.length;i++, index++){
            if(answers[i]==first[index%first.length])
               count[0]++;
            if(answers[i]==second[index%second.length])
               count[1]++;
            if(answers[i]==third[index%third.length])
               count[2]++;
        }
        
        int max=count[0];
        answer.add(1);
        for(int i=1; i<3; i++){
            if(max<count[i]){
                answer.set(0,i+1);
                max=count[i];
            }
            else if(max == count[i]){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*
수포자 3명이 정답을 찍는다. 이중 가장 점수가 높은 사람을 찾는 문제

제출시에는 1,2,3번째 사람의 점수를 따로 채점했는데 
한 번에 채점하는 것이 효율성이 높을 것 같아 코드를 수정했다.
또한 sort를 이용한 정렬이 굳이 필요없을 것 같아 이 역시 삭제했다. 
수정 전 (최소 3.3 ~ 8.8ms)
수정 후 (최소 1.92~10.07ms)

COMMENT

처음에 index를 main함수의 지역변수로 선언하여 사용했다.
코드의 복잡성을 주리기 위해 index를 for문에 포함했다. 
수정하는 과정에서 index++가 중복되어 결과값이 다르게 나왔다. 
코드를 수정할 떄 주의하자. 

어려웠던 점
1. Integer 배열을 int 배열로 바꾸는 방법이 어려웠다. 
stream에 대한 추가 학습이 필요하다.
*/