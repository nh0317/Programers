import java.util.*;

class Hand{
    public final ArrayList<Integer> left = new ArrayList<Integer>(Arrays.asList(1,4,7));
    public String startL="3,0";
    
    public final ArrayList<Integer> right= new ArrayList<Integer>(Arrays.asList(3,6,9));
    public String startR="3,2";
    
    public String shorterDistance(String hand, String startL, String startR ,String location){
        int[] pointL= new int[2];
        pointL[0]=Integer.parseInt(startL.split(",")[0]);
        pointL[1]=Integer.parseInt(startL.split(",")[1]);
        
        int[] pointR= new int[2];
        pointR[0]=Integer.parseInt(startR.split(",")[0]);
        pointR[1]=Integer.parseInt(startR.split(",")[1]);
        
        int[] point= new int[2];
        point[0]=Integer.parseInt(location.split(",")[0]);
        point[1]=Integer.parseInt(location.split(",")[1]);
        
        int distanceL= Math.abs(pointL[0]-point[0]) + Math.abs(pointL[1]-point[1]);
        int distanceR= Math.abs(pointR[0]-point[0]) + Math.abs(pointR[1]-point[1]);
        
        if(distanceL > distanceR){
            this.startR=location;
            return "R";
        }
        else if (distanceL < distanceR){
            this.startL=location;
            return "L";
        }
        else {
            if(hand.equals("left")){
                this.startL=location;    
                return "L";
            }
            else{
                this.startR=location;
                return "R";}
        }
    }
    
}

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        HashMap<Integer,String> keypad=new HashMap<>();
        
        keypad.put(1,"0,0");keypad.put(4,"1,0");keypad.put(7,"2,0");
        keypad.put(2,"0,1");keypad.put(5,"1,1");keypad.put(8,"2,1");keypad.put(0,"3,1");
        keypad.put(3,"0,2");keypad.put(6,"1,2");keypad.put(9,"2,2");
        
        Hand handLocation = new Hand();
        
        System.out.println(keypad);
      
        for (int i=0; i<numbers.length;i++){
            if(handLocation.left.contains(numbers[i])){
                answer+="L";
                handLocation.startL=keypad.get(numbers[i]);
            }
            else if(handLocation.right.contains(numbers[i])){
                answer+="R";
                handLocation.startR=keypad.get(numbers[i]);
            }
            else answer+=handLocation.shorterDistance(hand, handLocation.startL, 
                                                      handLocation.startR, 
                                                      keypad.get(numbers[i]));
        }
        return answer;
    }
}

/*
COMMENT
손가락으로 키패드를 누르는 상황을 구현하는 문제이다.

어려웠던 점:
1. call by reference
java에서 call by reference 이용하려면 class 메소드로 class 변수를 바꿔야한다. 

2. 손가락에서 키패드까지의 거리 구하기 
단순히 직선 길이를 구하는 것이 아니다. 
손가락이 상하좌우로만 움직일 수 있다는 점을 이용하여 구해야 한다. 

처음에 class를 선언하여 문제를 풀 생각을 못했어서 오히려 시간이 더 많이 걸렸던 것같다.
class를 만들어 푸는 방법도 익혀둘 것 
*/