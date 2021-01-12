class Solution {
    public String solution(String s) {
        String answer = "";
        int index= s.length()/2;
        
        if(s.length()%2==0)
            answer=s.substring(index-1,index+1);
        else
            answer=s.substring(index,index+1);
        
        return answer;
    }
}

/*
COMMENT
string에 대한문제 
substring 메소드만 알면 쉽게 풀 수 있다. 
*/