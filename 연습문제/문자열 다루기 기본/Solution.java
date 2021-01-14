class Solution {
    public boolean solution(String s) {
        if(!(s.length() ==4 || s.length()==6))
            return false;
        
        try{
            Integer.parseInt(s);
            return true;
        } 
        catch(NumberFormatException e){
            return false;
        }
    }
}

/*
COMMENT
문자열이 모두 숫자로 이루어있지 않다면, 
String을 int로 변환할 경우 에러가 발생할 것이다. 
이를 이용하여 try catch문을 통해 문자열이 모두 숫자로 이루어져 있는지 확인할 수 있다. 

*/