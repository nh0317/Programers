class Solution {
    public int[] solution(int n) {
        int[][] arr =new  int[n][n];
        int[] answer = new int[n*(n+1)/2];
        int y=-1, x=0;
        int num=1;
        for(int i=0 ;i<arr.length; i++){
            for(int j=i;j<n;j++){
                //아래로 움직이는 경우 
                if(i%3==0)
                    y++;
                
                //오른쪽으로 움직이는 경우 
                else if(i%3==1)
                    x++;
                
                //대각선으로 움직이느 경우
                else{
                    x--; y--;
                }                
                arr[y][x]=num++;
            }
        }
        
        for(int i =0, cnt=0; i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]!=0){
                    answer[cnt]=arr[i][j];
                    cnt++;
                }
            }
        }
        
        return answer;
    }
}

/*
COMMENT
https://record-of-coding.tistory.com/8 참고 
*/