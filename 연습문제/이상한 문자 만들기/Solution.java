class Solution {
    public String solution(String s) {
        String answer = "";
        s=s.toLowerCase();
        for(int i=0, index=0; i<s.length();i++,index++){
            if(s.charAt(i)==' '){
                answer+=' ';
                index=-1;
            }
            else
            answer+=(index%2==0? s.toUpperCase().charAt(i):s.charAt(i));
        }
        return answer;
    }
}

/*
COMMENT 
단어의 짝스번째 알파벳은 대문자로, 홀수번째 알파벳의 소문자로 바꾸는 문제이다. 
toLowerCase()와 toUpperCase()를 통해 쉽게 풀 수 있지만,
효율성도 생각해 보는 것이 좋다. 

아래와 같이 s를 문자 단위로 자르게 되면, 효율성이 좋아진다. 
(toUpperCase와 toLowerCase를 실행하는 문자열의 길이가 달라지므로)

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str=s.split("");
        int index=0;
        for(String ss:str){
            if(ss.equals(" ")) 
                index=-1;
            answer+=index%2==0? ss.toUpperCase() : ss.toLowerCase();
            index++;
        }
        return answer;
    }
}
*/