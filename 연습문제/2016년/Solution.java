class Solution {
    public String solution(int a, int b) {
        String[] week= { "THU", "FRI","SAT","SUN", "MON", "TUE", "WED"};
        int day=0;
        String answer = "";
        
        if(a>=1) day+=b;
        if(a>=2) day+=31;
        if(a>=3) day+=29;
        if(a>=4) day+=31;
        if(a>=5) day+=30;
        if(a>=6) day+=31;
        if(a>=7) day+=30;
        if(a>=8) day+=31;
        if(a>=9) day+=31;
        if(a>=10) day+=30;
        if(a>=11) day+=31;
        if(a>=12) day+=30;
        
        answer=week[day%7];
        return answer;
    }
}

/*

COMMENT
week배열은 1월 7일이 목요일 이므로 목요일 부터 시작했다.

문제는 무난하게 풀었으나 
어떻게 하면 코드를 간결하고 가독성이 좋게 작성할 수 있을지 고민했다. 
처음에는 switch문을 이용하여 각 달별로 날짜를 더했다.
이 경우 코드가 피라미드처럼 점점 길어지므로 가독성을 헤친다고 생각하여 if 문을 이용하게 되었다.
그러나 매번 12번 비교해야 하므로 효율성은 떨어질 것이다. 

아래의 코드처럼 각 달의 날짜를 배열로 선언하고,
반복문으로 더한다면 효율성과 가독성이 더 좋아질 것이다. 

class Solution {
    public String solution(int a, int b) {
        String[] week= { "THU", "FRI","SAT","SUN", "MON", "TUE", "WED"};
        int[] day={31,29,31,30,31,30,31,31,30,31,30,31};
        int sumDay=0;
        String answer = "";
        for(int i=0; i<a-1;i++)
            sumDay+=day[i];
        sumDay+=b;
        
        answer=week[sumDay%7];
        return answer;
    }
}

*/