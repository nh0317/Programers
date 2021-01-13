import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings,(a, b)-> {
            if(a.substring(n, n+1).compareTo(b.substring(n, n+1))==0)
                return a.compareTo(b);
            else return a.substring(n, n+1).compareTo(b.substring(n, n+1));
            });

        return strings;
    }
}

/*
COMMENT

문자열 배열에서 n번째 인덱스 글자를 기준으로 오름차순 정렬 하는 문제이다. 
단 n번째 인덱스가 같은 경우 전체 문자열을 기준으로 사전순으로 정렬한다. 

이 문제는 sort메소드와 람다식을 이용하여 간단하게 구현했다. 

*/