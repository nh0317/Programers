import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> queue= new ArrayList<>();
        for(int a : priorities)
            queue.add(a);
        
        while(true){
            //프린트를 하는 경우 
            if(MaxIndex(queue)==0){
                answer++;
                if(location==MaxIndex(queue))
                    break;
            queue.remove(0);
            location=nextIndex(queue.size(), location);
            }
            //프린트를 안하는 경우 
            else{
                location=nextIndex(queue.size(), location);
                queue.add(queue.get(0));
                queue.remove(0);
                
            }
        }
        
        return answer;
    }
    public static int MaxIndex(ArrayList<Integer> priorities){
        int max=0;
        for(int i=1; i<priorities.size();i++){
            if(priorities.get(max)<priorities.get(i)){
                max=i;
            }
        }
        return max;
    }
    public static int nextIndex(int size, int location){
        if(location==0)
            location=size-1;
        else location--;
        return location;
    }
}

/*
COMMENT

중요도가 높은 문서를 먼저 인쇄하는 프린터가 있을때,
location 번째의 문서가 인쇄되는 순서를 구하는 문제이다. 

어려웠던 점
1. 반복문의 중단점 정하기 
처음에 location과 MaxIndex 함수를 잘못 구현해서 
계속 무한 루프에 빠지는 문제가 발생했었다. 

2. MaxIndex, location 구하기 
priorities 배열을 ArrayList로 바꿨기 때문에 
MaxIndex와 locaion을 모두 ArrayList로 구해야한다. 

*/