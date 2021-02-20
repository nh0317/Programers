import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQue= new PriorityQueue<>();
        
        for(int i: scoville){
            pQue.add(i);
        }
        
        while(pQue.size()>=2 && pQue.peek()<K){
            int newSco = pQue.poll() + pQue.poll()*2;
            pQue.add(newSco);
            answer++;
        }
        if(pQue.peek() >=K){
            return answer;
        }else return -1;
    }
}

/*
COMMENT

가장 작은 수와 2번째로 작은 수의 2배를 배열의 모든 요소가 K이상이 될 때까지 반복하는 문제이다.
이 문제의 경우 Heap을 사용하면 더 효율적으로 풀 수 있다.

자바에서 우선순위 큐는 Min Heap 으로 구현되어 있으므로 이를 이용하면 쉽게 문제를 해결할 수 있다. 
처음에는 heap을 직접 구현하여 문제를 해결하려고 했는데 remove()함수를 잘못 작성하여 문제를 푸는 데 시간이 오래 걸렸다. 

아래는 Min Heap을 직접 구현하여 문제를 해결한 코드이다. 
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        MinHeap heap = new MinHeap();
        for(int i=0; i<scoville.length;i++){
            heap.insert(scoville[i]);
        }
        while(heap.size()>=2){        
            int f,s;
            if(heap.scoville()>=K)
                break;
            f=heap.remove();
            s=heap.remove()*2;
            heap.insert(f+s);
            answer++;
        }
        
        if(heap.scoville()>=K)
             return answer;
        else return -1;
    }
    
}

class MinHeap{
    ArrayList<Integer> heap;
    MinHeap(){
        heap= new ArrayList<>();
        heap.add(-1);
    }
    
    public void insert(int entry){
        heap.add(entry);
        int index = size();
        while(index >0){
            if (heap.get(index/2)>heap.get(index)){
                int temp = heap.get(index);
                heap.set(index, heap.get(index/2));
                heap.set(index/2, temp);
                index=index/2;
                }
            else break;
        }
        
    }
    public int remove(){
        int item = heap.get(1);
        if(heap.size()-1==0)
            return 0;
        
        heap.set(1,heap.get(this.size()));
        int p =1;
        while(p*2+1<=this.size()){
            if(heap.get(p*2)>heap.get(p)&&heap.get(p*2 +1)>heap.get(p))
            break;
            else if (heap.get(p*2)<heap.get(p*2+1)){
                int temp=heap.get(p);
                heap.set(p,heap.get(p*2));
                heap.set(p*2,temp);
                p*=2;
                }    
            else{
                int temp=heap.get(p);
                heap.set(p,heap.get(p*2+1));
                heap.set(p*2+1,temp);
                p=p*2+1;
                }
            } 
        
        heap.remove(this.size());
        return item; 
    }
    
    public int size(){
        return heap.size()-1;
    }
    
    public int scoville(){
        return heap.get(1);
    }
    
    public void show(){
        System.out.println(heap);
    }
}


*/