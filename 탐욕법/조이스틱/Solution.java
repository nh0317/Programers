import java.util.*;
class Solution {        
    int i=0; //커서의 위치
    public int solution(String name) {
        int answer = 0;
        
        //이미 방문한 문자인지 확인하기 위해
        int[] visited=new int[name.length()];
        i=0;
        //조이스틱으로 문자열 변경 시작 
        while(true){
            //문자열이 'A'인 경우
            //방문하여 다음 변경할 문자열의 위치를 탐색한다. (상하로 문자열 변경X) 
            if(name.charAt(i)=='A'){
                visited[i]=1;
            }
            
            //문자열이 'N'보다 큰 경우 
            //문자열을 하키로 변경한다.
            else if(name.charAt(i)>'N'){
                answer=answer+'Z'-name.charAt(i)+1;
                visited[i]=1;
            }
            
            //문자열이 'N'보다 작거나 같은 경우 
            //문자열을 상키로 변경한다. 
            else if (name.charAt(i)<='N'){
                answer=answer+name.charAt(i)-'A';
                visited[i]=1;
            }
           
            //변경할 문자열의 위치는 다음과 같은 방법으로 탐색한다. 
            //1. 오른쪽으로 이동하여 첫번째로 'A'가 아닌 문자가 나오는 위치까지의 거리를 계산한다. 
            //2. 왼쪽방향으로도 같은 방법으로 거리를 계산한다.
            //3. 왼쪽과 오른쪽 경로 중에서 최소 거리를 찾는다. 
            //4. 만약 최소 거리의 문자열을 탐색했다면, 다른 방향으로 이동한다.           
            int distanceR=1; int distanceL=1;
            
            //오른쪽 거리 계산 
            for(int j=moveR(i,1,name.length());j!=i;j=moveR(j,1,name.length())){
                if(name.charAt(j)=='A'){
                    distanceR++;
                }else break;
            }
            
            //왼쪽 거리 계산 
            for(int j=moveL(i,1,name.length());j!=i;j=moveL(j,1,name.length())){
                if(name.charAt(j)=='A'){
                    distanceL++;
                }else break;
            }
            System.out.println();
            
            //최소 거리 탐색 
            int distance=calcDistance(distanceR, distanceL, visited);
            
            //문자열을 모두 변경한 경우 
            if(distance==0) break;
            
            //다음 문자열의 위치로 이동한다. 
            else answer+=distance;
        }
        return answer;
    }
    
    //오른쪽으로 step만큼 이동 
    public int moveR(int index,int step, int len){
        return (index+step)%len;
    }
    
    //왼쪽으로 step만큼 이동 
    public int moveL(int index,int step, int len){
        return (index-step+len)%len;
    }
    
    //최소 거리 계산 
    public int calcDistance(int R , int L, int[] visited){      
        //왼쪽 오른쪽 모두 방문하지 않은 경우 
        //최소 거리로 이동 
        if(visited[moveR(i,R,visited.length)]==0 
           && visited[moveL(i,L,visited.length)]==0){
            if(R<=L){
                i=moveR(i,R,visited.length);
                return R;
            }
            else{
                i=moveL(i,L,visited.length);
                return L;
            }
        }
        
        //왼쪽 또는 오른쪽에 방문한 경우
        //방문하지 않은 곳에 방문
        else if (visited[moveR(i,R,visited.length)]!=0 
           && visited[moveL(i,L,visited.length)]==0){
            i=moveL(i,L,visited.length);
            return L;
        }
        else if (visited[moveR(i,R,visited.length)]==0 
           && visited[moveL(i,L,visited.length)]!=0){
            i=moveR(i,R,visited.length);
            return R;
        }
        
        //둘 다 방문했다면 모든 문자열을 변경한 것이므로 0을 반환한다. 
        else return 0;
    }
}
/*
COMMENT
조이스틱으로 알파벳 이름을 만드는 경우 최소로 움직인 조이스틱의 조작 횟수를 구하는 문제

생각보다 어려웠다.

이 문제의 경우 우선 2가지를 판단해야한다. 
1. '상'와 '하' 중 어느 것으로 알파벳을 조작할 것인가?
2. '좌'와 '우' 중 어느 것으로 위치를 이동할 것인가. 

1번의 경우 간단하다.
A에서 시작하기 때문에 N키를 기준으로 판단하면 된다. 
A에서 '상'으로 N까지 조이스틱을 조작하는 횟수는 '하'로 조작했을 때와 동일하기 때문이다.
즉, N보다 작은 경우 '상'으로 이동, N보다 큰 경우 '하'로 이동 

2번의 경우가 약간 복잡하다.
우선 현재 위치에서 다음으로 조작할 알파벳의 위치를 구해야한다. 
이때 'A'이면 조작할 필요가 없으므로 다음 위치로 이동할 것이다. 
즉 'A'가 아닌 문자열까지의 거리를 오른쪽 방향과 왼쪽 방향을 계산한 다음
최소 거리를 구하여 해당 위치로 이동하면 된다. 

그러나 문제는 최소거리의 문자열을 이미 조작한 경우이다.

예를 들어 ABAAAABAAB의 경우 
1. AAAAAAAAAA 상태에서 커서만 1번째 인덱스로 움직인다. (+1)
2. ABAAAAAAAA 1번쨰 인덱스를 조작한다. (+1)
3. ABAAAAAAAA 에서 최소거리는 왼쪽으로 2번 움직인 경우이므로 9번째 인덱스로 움직인다. (+2)
4. ABAAAAAAAB 9번째 인덱스를 조작한다. (+1)
5. ABAAAAAAAB 에서 다음 위치를 탐색한다.
이때 최소 거리는 오른쪽으로 2번 움직인 것이지만, 이미 1번째 인덱스는 변경되었으므로 왼쪽으로 3번 움직여야 한다. 
즉  6번째 인덱스로 움직인다(+3)
6. ABAAAABAAB마지막으로 6번째 인덱스를 조작한다.(+1) 
결과적으로 총 9번 조작하여 목표로하는 문자열을 만들 수 있다. 

위의 예제에서 최소거리에 있는 문자열을 이미 조작했는지 판단해야한다.
이를 위해 visited 배열을 선언하여 사용했다. 
이 배열은 0으로 초기화되어 있으며, i번째 문자열을 변경한 경우 i번째 요소에 1을 대입한다.
이 배열을 통해 최소 거리의 문자열을 변경했는지 확인할 수 있다. 
만약 최소 거리의 문자열을 이미 조작했다면 
다른 방향의 문자열을 조작한다. 
만약 두 뱡향의 문자열을 모두 조작했다면 모든 문자열을 조작한 것이므로 문자열 조작을 종료하면 된다. 

위의 코드는 이를 바탕으로 프로그래밍한 것이다. 



*/