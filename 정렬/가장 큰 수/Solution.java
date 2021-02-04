import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        String answer = "";
        for(int n : numbers)
            list.add(Integer.toString(n));
        
        list.sort((a,b)->(b+a).compareTo(a+b));
        if(list.get(0).equals("0"))
            return "0";
        
        answer=String.join("",list.toArray(new String[list.size()]));
        
        
        return answer;
    }
}

/*
COMMENT 
numbers 배열의 정수를 이어 붙여 만들 수 있는 가장 큰 수를 구하는 문제이다.

생각보다 어려웠던 문제였다. 

처음에는 정수의 맨 앞자리만 비교하는 방식을 이용했다. 
이 경우 자리수가 다른 경우는 예외로 생각해야 하며,
뒷자리는 비교할 수 없다는 문제가 있다. 
따라서 다른 방법을 통해 두 숫자를 비교해야했다.

이 문제에서 중요한 것은 정수를 이어 붙여 숫자를 만든다는 것이다. 
만약 두 숫자 a, b가 있을 때, ab로 조합한 수가 큰지 ba로 조합한 수가 큰지 비교한다면
이어 붙여 만들 수 있는 가장 큰 수를 구할 수 있을 것이다. 
즉 list.sort((a,b)->(b+a).compareTo(a+b))를 이용한다. 


*/