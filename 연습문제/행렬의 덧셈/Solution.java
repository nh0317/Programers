class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                arr1[i][j]+=arr2[i][j];
            }
        }
        return arr1;
    }
}

/*
COMMENT
행렬의 덧셈을 구하는 문제이다
이중 for문을 통해 간단하게 구현할 수 있다. 
*/