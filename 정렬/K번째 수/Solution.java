import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answer=new ArrayList<>();
        
        for(int i=0; i<commands.length;i++){
            for(int j=commands[i][0]-1; j<commands[i][1];j++){
                list.add(array[j]);
            }
            list.sort((a,b)->a-b);
            answer.add(list.get(commands[i][2]-1));
            list.clear();
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*
COMMENT 
문제 자체는 무난하게 풀었다.
그러나 Arrays의 copyOfRange 메소드를 이용하면 더 쉽게 풀 수 있었다. 
또한 시간의 효율성 측면에서 sort 메소드보다 삽입정렬이나 퀵정렬을 사용하는 것이 좋다.

아래는 이를 이용한 코드

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer= new int[commands.length];
        for(int i=0; i< commands.length;i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            sort(temp);
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
    public static int[] sort(int[] array){
        for(int i=1; i<array.length;i++){
            int temp=array[i];
            int j;
            for(j=i-1; j>=0 && temp<array[j];j--)
                array[j+1]=array[j];
            array[j+1]=temp;
        }
        return array;
    }
}


*/