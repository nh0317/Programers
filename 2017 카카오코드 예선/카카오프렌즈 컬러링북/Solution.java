import java.util.*;
class Solution {
    int[][] visited;
    int size=0;    
    
    public int bfs(int y, int x, int[][] picture){               
        int[] curserY = {0,1,-1,0};
        int[] curserX={1,0,0,-1};
        
        Queue<Integer> queX=new LinkedList<Integer>();
        Queue<Integer> queY=new LinkedList<Integer>();
        visited[y][x]=1;
        size=1;
        queX.add(x);
        queY.add(y);
        
        while(!queX.isEmpty()){
            x=queX.poll();
            y=queY.poll();
            
            for(int i=0; i<4;i++){
                int ny = y+curserY[i]; 
                int nx = x+curserX[i];
                if(ny >= 0 && ny<picture.length && nx>=0 && nx<picture[0].length){
                    if((picture[y][x]==picture[ny][nx]) && visited[ny][nx]==0){
                        visited[ny][nx]=1;
                        queX.add(nx);
                        queY.add(ny);
                        size++;
                    }
                }
            }
        }
        return size;
    }
    
    public int dfs(int y, int x, int[][] picture){
        
        int[] curserY = {0,1,-1,0};
        int[] curserX={1,0,0,-1};
        visited[y][x]=1;
        for(int i=0; i<4;i++){
                int ny = y+curserY[i]; 
                int nx = x+curserX[i];
                if(ny >= 0 && ny<picture.length && nx>=0 && nx<picture[0].length){
                    if((picture[y][x]==picture[ny][nx]) && visited[ny][nx]==0){
                        dfs(ny, nx, picture);
                        size++;
                    }
                }
            }
        
        return size;
        
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        size=1;
        ArrayList<Integer> list = new ArrayList<>();
        visited = new int[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
               
        for(int i=0; i< picture.length; i++){
             for(int j=0; j<picture[i].length;j++){
                 if(visited[i][j]==0 && picture[i][j]!=0){
                     list.add(dfs(i,j,picture));
                     size=1;
                     
                    //list.add(bfs(i,j,picture));
                 }
             }
        }
        maxSizeOfOneArea=list.get(0);
        for(int l : list){
            if(l>maxSizeOfOneArea)
                maxSizeOfOneArea=l;
        }
        numberOfArea=list.size();
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

/*
COMMENT
그림의 영역과 영역의 넓이를 계산하는 문제이다. 

처음에 그래프로 풀 생각을 못해서 상당히 오래 걸렸으며, 
처음으로 그래프를 이용하여 문제를 풀어 코드를 작성하기 어려웠다. 

0보다 큰 정수인 경우 bfs또는 dfs 알고리즘을 이용하여 인접한 영역을 탐색한다. 
이때 인접한 영역은 상,하,좌,우 영역 중에서 같은 정수로 채워진 영역이다. 
즉 한 영역을 방문했을 때 상하좌우 영역의 값을 비교하면 된다. 
한 영역을 방문할 때마다 size의 값을 증가시키고 이 값이 곧 영역의 넓이이다. 
탐색이 종료되면 list에 값을 추가하고 방문하지 않은 새로운 0이 아닌 졍수인 영역을 찾는다.
해당 영역에서 탐색을 다시 진행한다. 
이 과정이 끝나면 list에는 모든 영역의 넓이가 저장된다. 
즉 list의 크기는 영역의 개수이고, list에서 가장 큰 값이 가장 큰 영역의 넓이이다. 

이 문제에서는 연습을 위해 bfs와 dfs 알고리즘 모두를 구현해봤다. 

*/