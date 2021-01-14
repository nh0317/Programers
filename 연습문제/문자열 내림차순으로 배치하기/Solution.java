import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] list = s.split("");
        Arrays.sort(list, (a, b)->b.compareTo(a));
        answer=String.join("", list);
        
        return answer;
    }
}

/*
COMMENT

문제는 평이했으나
문자열에서 split 과 join 메소드를 쓰는 것이 익숙하지 않아 푸는데 오래 걸렸다. 

문자열의 메소드를 공부할 것. 
*/