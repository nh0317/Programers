import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] str=Integer.toString(n).split("");
        for(String s : str)
            answer += Integer.parseInt(s);
        
        return answer;
    }
}

/*
COMMENT
자연수 n의 각 자리 수의 합을 구하는 문제이다. 
이는 n을 문자열로 바꾸고 문자단위로 자른 다음. 
작 문자를 int형으로 반환하여 더하면 쉽게 구할 수 있다. 

*/