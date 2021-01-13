class Solution {
    boolean solution(String s) {
        int countP=0, countY=0;
        
        for(int i=0; i<s.length(); i++){
            if(s.toLowerCase().charAt(i)=='p') 
                countP++;
            
            else if(s.toLowerCase().charAt(i)=='y') 
                countY++;
        }
        
        return countY==countP;
    }
}

/*
COMMENT 

대문자와 소문자가 섞여있눈 문자열에서 'p'와 'y'의 개수를 배교해 
같으면 true, 다르면 false를 반환하는 문제이다.

문제는 평이하여 string의 메소드만 알면 풀 수 있다. 
그러나 filter와 람다식을 이용하면 더 간단하게 풀 수 있다. 
filter를 공부할 것.

return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();

*/