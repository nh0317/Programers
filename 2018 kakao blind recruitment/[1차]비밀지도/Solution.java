class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] map1=new String[n];
        String[] map2=new String[n];
        String[][] total =  new String[n][n];
        for(int i=0;i<n;i++){
            map1[i]=Integer.toBinaryString(arr1[i]);
            map2[i]=Integer.toBinaryString(arr2[i]);
            if(map1[i].length()<n){
                StringBuilder temp = new StringBuilder(map1[i]);
                for(int j=0;j<n-map1[i].length();j++){
                    temp.insert(j,"0");
                }
                map1[i]=temp.toString();
            }
            if(map2[i].length()<n){
                StringBuilder temp = new StringBuilder(map2[i]);
                for(int j=0;j<n-map2[i].length();j++){
                    temp.insert(j,"0");
                }
                map2[i]=temp.toString();
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map1[i].charAt(j)=='1'|| map2[i].charAt(j)=='1')
                    total[i][j]="#";
                else if(map1[i].charAt(j)=='0'&& map2[i].charAt(j)=='0')
                    total[i][j]=" ";
            }
        }
        
        for(int i=0;i<n;i++){
            answer[i]=String.join("",total[i]);
        }
        System.out.println();
        return answer;
    }
}

/*
COMMENT
생각보다 쉬운 문제 였는데 어렵게 풀었다. 

아래는 조금 더 쉽게 풀 수 있는 방법이다. 
이진수로 바꿀 때 '|'연산을 이용하는 것이 핵심이다. 
다만 속도는 느리다. 
class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
*/

