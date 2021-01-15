class Solution {
    public String solution(int n) {
        String answer = "";
        String[] str=new String[n];
        for(int i=0; i<n;i++){
            if((i+1)%2==1)
                str[i]="수";
            else str[i]="박";
        }
        answer=String.join("",str);
        return answer;
    }
}

/*
COMMENT

n개의 String 배열을 선언한 후,
"수"와 "박"을 번갈아 저장하고,
String 배열을 join 메소드를 통해 문자열을 합쳐서 반환했다. 
*/