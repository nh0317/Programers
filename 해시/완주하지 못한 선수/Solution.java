import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int count=0;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i<completion.length;i++){
            if(!completion[i].equals(participant[i]))
            return participant[i];
        }
        return participant[participant.length-1];

    }
}


/*
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String a : participant)
            map.put(a,map.getOrDefault(a,0)+1);
        for(String a : completion) 
            map.put(a,map.get(a)-1);
        
        for(String key : map.keySet()){
            if(map.get(key)!=0){
                answer=key;
            }
        }
        return answer;
    }
}

COMMENT

초반에는 Set에서 removeAll을 이용하려고 했다. 
이 경우 동명이인에 대한 처리가 어려웠다. 

다음으로 시도한 것은 단순히 배열을 정렬한 다음, 배열을 비교하는 방법이다. 
다행히 효율성 테스트에서 통과했지만 HashMap을 이용하는 것보다 효율성이 나쁘기 때문에
HashMap을 이용하는 방법을 익혀둘 것
특히 getOrDefault메소드를 이용하면 찾는 키의 값이 없는 경우 기본값을 반환할 수 있다. 

어려웠던 점:
1. 동명이인(중복)처리
2. 효율성에 대한 생각

*/