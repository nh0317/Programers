class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] rate = new double[N+1];
        for(int i=0; i<stages.length; i++){
            rate[stages[i]-1]++;
        }
        
//실패율 계산 
        for(int i=0;i<=N;i++){
            double sum=0;
            for(int j=i; j<rate.length;j++)
                sum+=rate[j];
            if(sum==0){
                rate[i]=0.0; continue;
            }
            rate[i]/=sum;
        }
        
//실패율을 기준으로 스테이지 정렬 
        sort(rate,answer);
        
        for (int i=0;i<answer.length;i++){
            answer[i]++;
        }
        return answer;
    }
    
    public static double[] sort(double[] arr, int[] result){
        for(int i=1;i<arr.length-1;i++){
            double temp = arr[i];
            int j=i-1;
            for(;j>=0 && temp>arr[j] ;j--){
                arr[j+1]=arr[j];
                result[j+1]=result[j];
            }
            arr[j+1]=temp;
            result[j+1]=i;
        }
        return arr;
    }
}

/*
COMMENT

스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수로 
실패율을 계산하고,
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호를 정렬하는 문제이다. 

어려웠던 점
1. sum==0인 경우의 예외처리 
sum==0이면 나누기 연산을 할 경우 원치 않는 값(infinite or NaN)이 대입되므로 예외처리를 해야한다. 
이 경우 현재 스테이지에 있는 사람과 다음 스테이지로 넘어간 사람이 없다는 것을 의미하므로, 
실패율을 0으로 설정한다.

2. 실패율을 기준으로 스테이지를 내림차순으로 정렬
처음에는 단순히 실패율이 담긴 배열을 정렬했다. 
이 경우 당연하지만 스테이지 번호를 나타내는 배열의 인덱스가 정렬되지 않는다. 

따라서 다음의 2가지 방법을 생각할 수 있다. 
1. 실패율을 정렬할 때 배열의 인덱스(스테이지 번호-1)를 다른 배열에 함께 정렬한다. 
예를 들어 인덱스 1번의 값이 인덱스 3번으로 이동하게 된다면,
다른 배열의 인덱스 3번에 1을 저장하는 식이다. 
즉 배열의 인덱스가 움직이는 것을 다른 배열에 기록하는 것이다. 
이렇게 만들어진 배열의 모든 값에 1을 더하면( 배열의 인덱스 = 스테이지 번호-1)
실패율을 기준으로 스테이지 번호를 정렬하는 것과 같게 된다. 

2. 해시맵 이용
Key 값을 스테이지 번호 Value값을 실패율로 하는 HashMap을 이용한다.
각 스테이지의 실패율을 계산한 다음 Value값을 기준으로 Key값을 정렬한다. 
코드는 다음과 같다. 

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        HashMap<Integer, Double> rate = new HashMap<>();
        for(int i=0; i<stages.length; i++)
            rate.put(stages[i],rate.getOrDefault(stages[i],0.0)+1);
              
        //실패율 계산 
        for(int i=1;i<=N;i++){
            double sum=0;
            for(int j=i; j<=N+1;j++)
                sum+=rate.getOrDefault(j,0.0);
            
            if(sum==0){
                rate.put(i,rate.getOrDefault(i,0.0)); continue;
            }
            rate.put(i,rate.getOrDefault(i,0.0)/sum);
        }
        rate.remove(N+1);//정렬시 필요 없는 값 
        
        //실패율을 기준으로 스테이지 정렬 
        ArrayList<Integer> keySet = new ArrayList<Integer>(rate.keySet());
        keySet.sort((a,b)->(rate.get(b).compareTo(rate.get(a))));
        
        for(int i=0; i<answer.length;i++)
            answer[i]=keySet.get(i);
        
        return answer;
    }
}

해시맵을 이용하는 것이 구현하기 쉬울 것 같은데(사고하기 쉽다.)
시간이 오래걸린다. 


*/