import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int[] day = new int[progresses.length];
        
        //각 개발이 완료되는데 걸리는 시간 
        for(int i=0; i<progresses.length;i++)
            day[i]=(int)Math.ceil((double)(100-progresses[i])/speeds[i]);            
        
        //배포되는 기능의 수 구하기 
        int max=day[0], release=1;
        for(int i=1;i<day.length;i++){
            if(max<day[i]){
                max=day[i];
                list.add(release);
                release=1;
            }
            else release++;
        }
        list.add(release);
        
        int[] answer= new int[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);
        return answer;
    }
}

/*
COMMENT

n개의 기능을 개선하고 있다고 가정하자. 
이때 각 기능의 개발의 진척 사항이 담긴 배열이 progresses이고 
하루의 작업 진도가 담긴 배열이 speeds이다. 
만약 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 경우 
뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포된다. 
각 배포마다 몇 개의 기능이 배포되는지 구해라

코드 설명 
각 기능의 개발이 완료되는 데 걸리는 시간을 구하여 day 배열에 저장한다. 
배포되는 기능의 수는 day의 원소의 값을 비교하여 구했다. 

우선 첫 번째 원소의 값을 max에 저장하고 다음 원소와 max의 값을 비교한다. 
만약 앞의 기능 개발이 완료되는 데 걸리는 값(max)보다 
다음 기능 개발이 완료되는 데 걸리는 기간(dy[i])이 더 오래 걸린다면, 
지금 시점에서 개발이 완료된 기능이 모두 배포된다. 
따라서 배포될 기능이 수인 release를 list에 추가하고 release의 값을 1로 설정한다.

만약 뒤의 기능 개발 시간보다
앞의 기능 개발 시간보다 더 오래걸린다면, 
뒤의 기능은 앞의 기능 개발이 완료되는 시점에 배포되어야하므로 
배포될 기능의 수를 의미하는 release값을 1증가한다. 

list에 마지막으로 배포되는 기능의 수를 추가하면,
각 배포시에 배포되는 기능을 구할 수 있다. 
*/