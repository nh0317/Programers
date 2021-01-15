import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if (isPrime(i))
                answer++;
        }
        return answer;
    }
    
    public boolean isPrime(int n){
        if (n==1)
            return false;
        else if (n==2)
            return true;
        else{
            for(int i=2; i<=(int) Math.sqrt(n);i++)
                if(n%i==0)
                    return false;
            return true;
        }
    }
}

/*
COMMENT 
처음에는 에라토스테네스의 체 알고리즘을 이용하지 않아 시간 초과로 실패했다.
에라토스테네스의 체는 숫자의 공약수가 대칭으로 이루어져있다는 사실(예. 2*4=4*2)을 통해 
특정한 숫자의 제곱근까지만 약수인지 확인하면 된다는 알고리즘이다. 
어떻게 해야 코드의 효율성을 높일 수 있는지 고민해볼 수 있는 문제였다. 


*/