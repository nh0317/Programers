import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String,Integer> hash = new HashMap<>();
        
        //각 의상의 종류에 대해서 몇 개 있는지 파악하기 위해서 hash map에 저장
        for(int i=0 ; i<clothes.length;i++)
            hash.put(clothes[i][1],hash.getOrDefault(clothes[i][1],0)+1);
        
        int[] values = new int[hash.values().size()];
        int index=0;
        
        //서로 다른 n종류의 옷이 1개씩 있는 경우 
        if(Collections.max(hash.values())<=1){
            return (int)Math.pow(2,hash.values().size())-1;
        }
        
        //hash map의 value만 배열로 변환
        for(Integer v: hash.values()){
            values[index++]=v;
            answer+=v; // 한 가지 종류의 옷만 입는 경우 
        }
        
        
        ArrayList<Integer> result = new ArrayList<>(); //옷 조합을 담는 배열
        boolean[] visited = new boolean[values.length]; 
        
        for(int i=hash.keySet().size();i>1;i--){
            //n 종류의 옷을 i개 선택할 때 옷 조합의 수
            //예를 들어 서로 다른 3가지 종류의 옷이 각각 3,4,5개 있을 떄
            //3가지 중 2개를 선택하는 경우는 
            //[3,4] [3,5] [4,5]
            //각각의 경우에 대해서 입을 수 있는 옷의 조합은 12, 15, 20
            //이 12, 15, 20을 result에 담는다.
            com(values,visited, 0, values.length, i,result);    
            
            //result 배열에 있는 수를 answer에 모두 더하고
            //result를 초기화한다. 
            for(Integer N : result)
                answer+=N;
            result.clear();
        }
        return answer;
    }
    
    //조합을 구하는 함수
    static void com(int[] arr, boolean[] visited, int start, int n, int r, 
                    ArrayList<Integer>result) {
        if(r == 0) {   
            int mul=1;
            for(int i=0; i<n;i++)
                //각 조합의 요소를 곱한다. 
                if(visited[i]){
                    mul*=arr[i];
                }
            //곱한 값을 result에 담는다. 
            result.add(mul);
            return;
        } 
            
        for(int i=start; i<n; i++) {
            visited[i] = true;
            com(arr, visited, i + 1, n, r - 1,result);
            visited[i] = false;
        }
    }
}

/*
COMMENT

n 종류의 옷이 r개 있을 때 1가지 종류이상의 옷을 입는 경우의 수를 구하는 문제이다. 

조합 함수를 응용하여 각 조합으로 입을 수 있는 경우의 수를 구하고 이를 다시 answer에 더하는 방식으로 코드를 작성했다. 
예를 들어 a,b,c 종류의 옷이 있고 각각 3,4,5개 있는 경우 
1. 1종류의 옷만 입는 경우 
3+4+5=12 (value값을 배열로 변환할 때 answer에 더한다.)

2. 2종류의 옷을 입는 경우 
a, b를 조합하는 경우 3*4
a, c를 조합하는 경우 3*5
c, b를 조합하는 경우 4*5

com 함수를 통해 각 경우를 result에 담는다. 
result에 있는 모든 수를 answer에 더한다. (+12+15+20)

3. 3종류의 옷을 입는 경우 
a, b, c를 조합하는 경우 3*4*5 
com 함수를 통해 각 경우를 result에 담는다. 
마찬가지로 result의 수를 answer에 더한다.(+60)

따라서 총 119가지 경우의 수를 반환한다. 

그러나 이렇게 풀이하는 경우 n종류의 옷이 1개씩 있는 경우 시간초과가 발생한다. 
따라서 이 경우를 예외처리한다.
Collections.max()함수를 통해 value값 중에서 최대 값을 구한다. 
최대 값이 1인 경우 
2^n-1을 반환한다. 


이 문제는 옷을 안입는 경우를 포함하여 생각하면 더 쉽게 풀 수 있다. 
예를 들어 위와 동일하게 a,b,c 종류의 옷이 있고 각각 3,4,5개 있는 경우
이 옷으로 입을 수 있는 모든 경우의 수는 
(a옷 3가지를 입는 경우 + 안입는 경우)*(b옷 3가지를 입는 경우 + 안입는 경우)*(c옷 3가지를 입는 경우 + 안입는 경우) - 1(모든 옷을 입지 않는 경우)
=4*5*6-1

코드로 작성하면 hashmap에 저장한 다음

for(Integer N : hash.values()){
            answer*=(N+1);
        }
return answer-1;

을 작성하면 된다. 

이렇게 풀이하면 시간 복잡도도 줄어들고 코드도 간결해진다. 
수식을 어떻게 세우는 가가 매우 중요함을 배울 수 있었다. 

*/