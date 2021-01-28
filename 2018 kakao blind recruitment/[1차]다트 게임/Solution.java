import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3]; 
        String area ="SDT";
        String prize = "*#";
        int cnt =0;
        for(int i=1;i<dartResult.length();i++){
            if(area.contains(Character.toString(dartResult.charAt(i)))){
                int temp = 0;

              //0과 10을 구분하기 위해   
	if(i>=2 && dartResult.charAt(i-1)=='0' && dartResult.charAt(i-2)=='1')
                    temp=10;
                else temp=dartResult.charAt(i-1)-'0';
                        
	//점수 계산 
                switch(dartResult.charAt(i)){
                    case 'S':
                        score[cnt]=temp; break;
                    case 'D':
                        score[cnt]=(int)Math.pow(temp,2); break;
                    case 'T':
                        score[cnt]=(int)Math.pow(temp,3); break;
                }
                cnt++;
            }
            else if(prize.contains(Character.toString(dartResult.charAt(i)))){
                switch(dartResult.charAt(i)){
                    case '*':
                        if(cnt>=2){
                        score[cnt-2]*=2; score[cnt-1]*=2;
                        }
                        else score[cnt-1]*=2;
                        break;
                    case '#':
                        score[cnt-1]*=-1;
                        break;
                }
            }
        }
        
        for(int a : score)
            answer+=a;
        return answer;
    }
}

/*
COMMENT 

주어진 규칙에 따라 다트 게임의 점수를 계산하는 문제이다. 
1. 다트 게임은 총 3번의 기회로 구성된다.
2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
4. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
5. 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
6. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
7. 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
8. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
9. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.

어려웠던 점
1. 얻을 수 있는 점수는 0과 10점 구분 
처음에는 단순히 SDT 옆의 문자를 점수로 계산했으나 이 경우 0과 10을 구분할 수 없다. 
따라서 0과 10을 구분할 수 있는 알고리즘이 필요했다. 

2. 스타상과 아차상 계산 
스타상과 아차상의 경우 각각 점수를 계산하는 방법이 다르며,
특히 스타상의 경우 1번째에 스타상을 받은 경우를 예외 처리해야한다. 
*/