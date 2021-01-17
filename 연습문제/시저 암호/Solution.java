class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' '){
                answer+=' ';
                continue;
            }
            else if(ch >='a' && ch <= 'z')
                answer+=(char)( 'a' + ((ch - 'a'+ n) % 26) );
            else if(ch >='A' && ch <= 'Z')
                answer+=(char)( 'A' + ((ch -'A' + n) % 26) );
        }
        return answer;
    }
}

/*
COMMENT
시저암호 만들기

어려웠던 점
1. 대문자의 범위와 소문자의 범위를 나누어 생각해야함
대문자의 범위가 65~90이고, 소문자의 범위가 97~122이므로,
단순히 더하는 경우 대문자가 소문자가 될 가능성이 있다. 

2. z를 벗어나면 a로 돌아와야 한다. 
이 경우는 
1)'z'또는 'Z'값을 벗어나는 경우로 나누어 생각한다. 
2) (ch - 'a'+ n) % 26를 'a'에 더한다. 

*/