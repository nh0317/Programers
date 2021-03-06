class Solution {
    public int solution(int n) {
        return fibonacci(n)%1234567;
    }
    public int fibonacci(int n){
        if(n==0)
            return 0;
        else if (n==1)
            return 1;
        
        int a0=0; //F(0)
        int a1=1; //F(1)
        int an=a0+a1; // F(2)
        
        //F(3)이상의 경우 
        for(int i=3; i<=n;i++){
            a0=a1;
            a1=an;
            an=(a0+a1)%1234567;
        }
        return an;
    }
}
/*
COMMENT
n번째 피보나치 수를 1234567로 나눈 나머지를 구하는 문제이다. 

처음에는 단순하게 피보나치 수열을 구하는 함수를 재귀로 작성했다. 
그러나 재귀로 피보나치 수열을 작성하는 경우 일부 문제에서 시간초과가 발생했다. 
피보나치 수열을 재귀로 작성하면 시간 복잡도가 O(2^n)으로 비효율적이기 때문에 발생하는 문제이다. 

따라서 반복을 통해 피보나치 수열을 구현해야 한다. 
반복을 이용하는 경우 
a0에 n-2번째 피보나치 수를 저장하고 
a1에 n-1번째 피보나치 수를 저장한다. 
an에 a0+a1의 값을 대입하면, F(n-1)+F(n-2) 값을 대입하는 것과 동일하다.

즉 이 과정을 반복하면, n번째 피보나치 수열을 구할 수 있다. 

이때 F(n)이 int의 범위를 넘어설 수 있으므로 a0+a1을 1234567로 나눈 나머지를 대입한다.
((a+b)%n == a%n + b%n)
 
*/