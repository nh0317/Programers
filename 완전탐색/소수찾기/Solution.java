import java.util.*;

class Solution {
    public int solution(String numbers) {
        
        int answer = 0;
        
        //numbers의 문자열을 각각 숫자로 변환하여 int배열로 만든다.
        int[] nums = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        
        //N개의 숫자로 이루어진 nums 배열의 숫자를 1~N까지 순열로 뽑는다. 
        for(int i=1; i<=nums.length;i++){
            //순열의 결과를 저장하기 위한 Set(중복을 피하기 위해 Set 사용)
            HashSet<Integer> result = new HashSet<>();
            
            //순열로 i개를 뽑음
            nPr(nums, new int[i], new boolean[nums.length], 0, nums.length, i, result);
            
            //만든 숫자중에서 소수인 것을 판단한다. 
            for(Integer num : result){
                if(isPrime(num))
                    answer++;
            }
        }
        return answer;
    }
    
    //소수를 판단하는 함수 
    public boolean isPrime(int n){
        if(n==0)
            return false;
        else if(n==1)
            return false;
        else if(n==2)
            return true;
        else {
            for(int i=2; i<=Math.sqrt(n);i++){
                if(n%i==0)
                    return false;
            }
            return true;
        }
    }
    public void nPr(int arr[], int[] output, boolean[] visited, int depth, int n, int r, 
                    HashSet<Integer> result){
        if(depth==r){
            //앞자리가 0인 경우 
            if(output[0]==0)
                return;
            
            //순열로 뽑은 숫자들을 자연수로 만들어 result에 저장한다. 
            //예를 들어 1,2를 뽑은 경우 12을 저장
            int sum=0;
            for(int num : output)
                sum=sum*10+num;
            
            result.add(sum);
            return;
        }
        for(int i=0; i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                nPr(arr, output, visited, depth+1, n, r,result);
                visited[i]=false;
                output[depth]=0;
            }
        }
    }
}

/*
COMMENT

소요시간: 1:01:02.21

문자열의 각 숫자를 이용하여 만들 수 있는 소수의 갯수를 구하는 문제이다. 

문자열에서 숫자를 순열로 뽑아 숫자를 만들고, 만들어진 숫자가 소수인지 판단하여 문제를 풀었다. 

어떻게 풀지는 빠르게 정할 수 있었지만 
1. 순열 알고리즘이 익숙하지 않아 코드를 작성하는데 시간이 걸렸고 
2. 소수를 판단할 때 2를 소수가 아니라고 판단했으며 
3. "33"과 같이 한 자리수 숫자에 대한 종복값을 확인하지 않아 
전체 문제를 푸는데 시간이 예상보다 많이 걸렸다. 

*/