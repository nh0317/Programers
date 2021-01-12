import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<arr.length;i++)
            if(arr[i-1] != arr[i])
                answer.add(arr[i]);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}


/*

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for(int i=1; i<arr.length;i++)
            if(arr[i-1] != arr[i])
                temp.add(arr[i]);
    
        int[] answer = new int[temp.size()];
        for(int i=0; i<answer.length;i++){
            answer[i]=temp.get(i).intValue();
            
        }
        return answer;

COMMENT
stream()을 이용하면 코드는 간단하지만, 효율성이 낮다. 
따라서 그냥 for문을 통해 Integer배열을 int배열로 바꾸는 것이 나을 수 있다. 

*/