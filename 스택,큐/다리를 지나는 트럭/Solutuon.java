import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Bridge bridge = new Bridge(bridge_length, weight);
        Car[] car = new Car[truck_weights.length];
        
        for(int i=0; i<truck_weights.length; i++)
            car[i] = new Car(truck_weights[i]);
                
        //대기중인 차가 다리위에 올라가는 데 걸리는 시간
        for(int i=0; i<car.length;){
            answer++;          
            bridge.move();
            bridge.out();
            
            if(bridge.in(car[i]))
                i++;
        }
        
        //대기중이 트럭이 없고 
        //다리위의 모든 트럭이 다리를 건너는 데 걸리는 시간 
        while(!bridge.isEmpty()){
            answer++;
            bridge.move();
            bridge.out();
        }
        
        return answer;
    }
}

class Car {
    private int weight;
    private int move;
    Car(int w){
        this.weight=w; this.move=0;
    }
    public int getMove(){
        return move;
    }
    public void setMove(int move){
        this.move=move;
    }
    public int getWeight(){
        return weight;
    }
    public String toString(){
        return Integer.toString(weight);
    }
}

class Bridge {
    private Queue<Car> bridge = new LinkedList<Car>();
    private int length;
    private int sum;
    private int weight;
    Bridge(int length, int weight){
        this.length=length; sum=0; this.weight= weight;
    }
    public boolean in(Car car){
        if(car.getWeight()+sum<=weight){
            sum+=car.getWeight();
            bridge.add(car);
            return true;
        }
        else return false;
    }
    public void out(){
        if(bridge.isEmpty())
            return;
        if(bridge.peek().getMove()==length){       
            sum-=bridge.peek().getWeight();
            bridge.remove();
        }
    }
    public void move(){
        for (Car c : bridge)
            c.setMove(c.getMove()+1);
    }
    public boolean isEmpty(){
        if (bridge.isEmpty()) return true;
        else return false;
    }
    public String toString(){
        return bridge.toString();
    }
    
}

/*
COMMENT
트럭 여러 대가 다리를 건널 때 모든 트럭이 다리를 건너는 데 걸리는 시간을 구하는 문제이다.
단 트럭은 1초에 1만큼 움직이며, 다리는 무게 weight까지 견디고, 다리의 길이는 bridge_length이다. 

어려웠던점
1. 차가 움직이는 것을 어떻게 구현할 것인가
트럭이 1초에 1만큼 움직이기 때문에 모든 작동을 1초 단위로 생각해야 했다. 
처음에는 클래스를 따로 구현하지 않아, 차가 움직인 거리를 기억해둘 수가 없었다. 

트럭과 다리 클래스를 따로 구현하자 문제는 비교적 쉽게 풀렸지만,
문제를 풀기까지는 오랜 시간이 걸렸다. 

*/