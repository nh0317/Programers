import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        
		int[] answer = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
                
        //최대 공약수 구하기 
        for(int i=2; i<=Math.max(n,m);i++)
            if(m%i==0&&n%i==0)
                list.add(i);
        
        if(list.isEmpty()) //서로소인 경우 
            answer[0]=1;
        else {
        int max=list.get(0);
        for(Integer a: list)
            if(max<a)
                max=a;
        answer[0]=max;
        }
        
        //최소 공배수 구하기
        if(list.isEmpty()) //서로소인 경우 
            answer[1]=m*n;
        else{
            int n1=m/answer[0];
            int n2=n/answer[0];
            answer[1]=n1*n2*answer[0];
        }        
        return answer;
    }
}

/*
COMMENT
최대 공약수와 최소공배수를 구하는 문제이다

최대 공약수는 두 수의 공약수를 list에 넣은 후, 
최댓값을 구했다. 

최소 공배수는 두 수를 최대 공약수로 나눈 몫을 구하고,
두 몫과 최대 공약수를 곱하는 방법으로 구했다. 

최대 공약수는 쉽게 구할 수 있었지만 최소공배수를 구하는 방법이 다소 어려웠다. 
*/