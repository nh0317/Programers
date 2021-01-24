class Solution {
    public String solution(String phone_number) {
        String answer = "";
        for(int i=0; i<phone_number.length()-4;i++)
            answer+="*";
        answer+=phone_number.substring(phone_number.length()-4,phone_number.length());
        return answer;
    }
}

/*
COMMENT
핸드폰 번호를 마지막 4자리를 제외한 나머지 숫자를 전부 "*"로 바꾸는 문제이다.
substring을 이용하여 간단하게 풀 수 있다. 
*/