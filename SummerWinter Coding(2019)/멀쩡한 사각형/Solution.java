import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long total=(long)w*h;
        int n=0;
        
        //최대 공약수 n 구하기 
        for(int i=1;i<=Math.min(w,h);i++){
            if(w%i==0 && h%i==0){
                n=i;    
            }
        }
        
        //w*h을 같은 비율로 최대한 축소한 직사각형에서 
        //대각선이 지나는 블록의 수 
        long minRemove= w/n + h/n -1;
        
        return total-(long)minRemove*n;
    }
}

/*
COMMENT
동일한 폴더의 COMEMNT.hwp 참고 
(표를 첨부하기 위해 한글로 작성함)

*/