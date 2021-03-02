import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int maxWidth = (int) (brown-2)/2;
        
        for(int i=3;i<=maxWidth;i++){
            for(int j=i; j<=maxWidth; j++){
                if(i+j == (brown+4)/2 && i*j== brown + yellow){
                    answer[0]=j;
                    answer[1]=i; break;
                }
            }
        }    
        return answer;
    }
}


/*
COMMENT
사각형의 테두리 1줄을 칠한 크기가 brown 이고 중앙의 크기가 yellow일때 격자 모양의 카펫의 가로, 세로 길이를 구하는 문제이다.
(단, 가로가 더 길다)

우선 가로의 길이를 x, 세로의 길이를 y라고 하자.
이때 테두리에 색칠된 격자의 개수 brown은 (x+y)*2 - 4이다.
즉 x+y = (brown+4)/2

또한 x*y = brown + yellow(전체 격자의 수)이다. 
이를 모두 만족하는 x와 y의 값을 찾으면 된다. 

이때, 최소한 중앙 1줄, 테두리 위, 아래 각각1줄이 필요하므로 세로의 길이는 3이상이다. 
또한, 가로의 길이의 최대값은 양 옆 테두리 각각 1칸을 제외한 값을 2로 나눈 값이다. 
즉 (brown -2)/2
이를 통해 x와 y의 범위를 설정할 수 있다. 

위의 코드는 이를 바탕으로 작성한 것이다.

그러나 이는 열립 방정식을 사용하면 더 쉽게 풀 수 있다. 
앞선 식에서 
x*y= yellow + brown = a
x+y= (brown+4)/2 =b라고 하자 

y=b-x,
x*(b-x)=a,
x^2 -a*x + b =0
근의 공식을 이용하면 x = (a+sqrt(a*a-4b))/2 또는 x = (a-sqrt(a*a-4b))/2이다. 
이때 가로의 길이가 더 크므로 x= (a+sqrt(a*a-4b))/2이고, y = (a-sqrt(a*a-4b))/2이다.
이를 이용하면 이중 for문을 사용하지 않기 때문에 코드의 효율성이 크게 상승한다. 

소요 시간: 약 41분
*/