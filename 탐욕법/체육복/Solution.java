import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students=new int[n+1];
        for(int i=0; i<reserve.length;i++)
            students[reserve[i]]++;
        
        for(int i=0; i<lost.length;i++)
            students[lost[i]]--;
        
        for(int i=0; i<lost.length;i++){
            if(students[lost[i]]<0){
                if(students[lost[i]-1] > 0 ){
                    students[lost[i]-1]--;
                    students[lost[i]]++;
                }
                else if(lost[i]<n && students[lost[i]+1] > 0 ){
                        students[lost[i]+1]--;
                        students[lost[i]]++;
                }
            }
        }
        
        answer=n;
        for(int i=0; i<students.length;i++){
            if(students[i]<0){
                answer--;
            }
        }
        return answer;
    }
}


/*
COMMENT

문제를 잘못 읽어서 체육복을 입을 수 있는 최대 학생의 인덱스를 반환했었다. 
문제를 잘 읽도록 하자

쉽게 사고하기 위해서 배열을 n+1개 선언했다. 
(인덱스를 1부터 사용)

어려웠던 점
1. 마지막 학생이 체육복을 빌리는 경우 
(뒷 번호 학생에게 체육복을 빌릴 수 없음)

2. 여벌을 가져온 학생이 도난 당하는 경우
(우선 도난 당한 학생의 체육복이 있는지 없는지 판단해야 한다.)

고민했던 점
hashmap을 사용할지 말지 고민했다. 
전체 학생수가 30명 이하이고 인덱스가 정수이므로 일단 배열로 구현했다. 


*/