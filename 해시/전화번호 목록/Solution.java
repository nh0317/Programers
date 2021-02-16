import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=0; j<phone_book.length;j++){
                if (phone_book[i].indexOf(phone_book[j])==0 && i!=j){
                    return false;
                }
            }
        }
        return answer;
    }
}

/*
COMMENT
이 문제는 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는 지 확인하는 문제이다.
이 문제는 자신이 아닌 배열의 요소가 자신의 접두어인지 판단하면 된다. 
즉 전화번호부 중에서 2개를 뽑아 순열을 만들고, 순열의 두 번째 요소가 첫 번째 요소의 접두어인지 확인하면 된다. 
이 문제는 뽑는 개수가 2개로 매우 적으므로 조합을 for문으로 간단하게 만들 수 있다. 

즉 i번째 인덱스와 다른 j번째 인덱스를 비교하고 j번째 인덱스가 접두어이면 false를 반환한다. 
그렇지 않으면 다음 인덱스와 비교한다. 

vistied나 swap을 이용한 일반적인 조합을 만드는 함수를 사용해도 정확도 테스트는 통과할 수 있다. 
그러나 무조건 nP2개의 배열을 만들고 이를 비교해야하므로 효율성 테스트는 통과하지 못한다. 

아래는 vistied를 이용하여 조합을 만드는 함수를 이용한 코드이다. 
비록 효율성 테스트에서 통과하지 못했지만, 조합 함수를 알아두자. 
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        boolean[] visited=new boolean[phone_book.length];
        String[] output = new String[2];
        ArrayList<Boolean> answerList = new ArrayList<>();
        
        perm(phone_book,output, visited, 0, phone_book.length,2,answerList);
        for(boolean check:answerList){
            if(check == false)
                return false;
        }
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=0; j<phone_book.length;j++){
                if (phone_book[i].indexOf(phone_book[j])==0 && i!=j){
                    return false;
                }
            }
        }
        return answer;
    }
    static void perm(String[] arr, String[] output, boolean[] visited, int depth, int n, int r, ArrayList<Boolean> answerList) {
    if (depth == r) {
        if(output[0].indexOf(output[1])==0)
            answerList.add(false);
        return;
    }
 
    for (int i=0; i<n; i++) {
        if (visited[i] != true) {
            visited[i] = true;
            output[depth] = arr[i];
            perm(arr, output, visited, depth + 1, n, r, answerList);  
            visited[i] = false;
        }
    }
}
}



*/