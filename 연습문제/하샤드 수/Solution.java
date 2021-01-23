class Solution {
    public boolean solution(int x) {
        int n=x, sum=0;
        
        while(n!=0){
            sum+=(n%10);
            n/=10;
        }
        
        if(x%sum==0)
            return true;
        else return false;
    }
}

/*
COMMENT
x의 자릿수의 합으로 x가 나누어지는지 판단하는 문제이다. 
간단하게 while문으로 자릿수의 합을 구하고 
조건문을 통해 하샤드 수 인지 판단했다. 
*/