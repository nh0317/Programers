import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1|| arr.length==0){
            int[] answer ={-1};
            return answer;
        }
        int min=arr[0];
        for(int i=1;i<arr.length;i++)
            if(arr[i]<min)
                min=arr[i];
        
        ArrayList<Integer> list= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==min)
                continue;
            list.add(arr[i]);
        }
        
        int[] answer=new int[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);
        
        return answer;
    }
}

/*
COMMENT

가장 작은 값을 제거한 배열을 반환하는 문제이다.

어려웠던 점
1. 반환되는 배열을 내림차순으로 정렬하면 안된다.
최소값을 찾는 알고리즘을 통해 배열의 순서를 바꾸지 않고 최소값을 구할 수 있다. 
 
2. 중복되는 값이 여러개일 경우 모두 삭제해야 한다.
list를 이용하여 최소값이 아닌 경우에만 list에 값을 추가했다. 

*/