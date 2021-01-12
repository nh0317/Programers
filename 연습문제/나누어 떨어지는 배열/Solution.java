import java.util.*;

class Sort{
    public static void insertionSort(int[] array){
        for(int i=1; i<array.length;i++){
            int temp=array[i];
            int j=i-1;
            for(;j>=0&&temp<array[j];j--){
                array[j+1]=array[j];
            }
            array[j+1]=temp;
        }
    }
}

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int a : arr)
            if( a % divisor == 0 )
                list.add(a);
        
        if(list.isEmpty()){
            int[] answer = {-1};
            return answer;
        }
        else{
            int[] answer = new int[list.size()];
            for(int i=0; i<answer.length;i++){
                answer[i]=list.get(i).intValue();
            }
            Sort.insertionSort(answer);
            return answer;
        }
    }
}

/*
COMMENT

stream과 filter를 사용하면 더 간단하게 풀이할 수 있다. 
int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();

stream과 filter를 사용하는 방법을 알아 둘 것. 

정렬은 Arrays.sort를 이용하면 쉽지만 알고리즘 연습을 위해 insertionSort를 구현했다. 


*/
