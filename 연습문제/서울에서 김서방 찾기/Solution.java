class Solution {
 public String solution(String[] seoul) {
              String answer = "";
              int num = 0;
              for(int i=0;i<=seoul.length;i++){
                  if(seoul[i].equals("Kim")) {
                      num=i;
                      break;
                  }
              }

              answer = "김서방은 "+num+"에 있다";
              return answer;
          }
}

/*
COMMENT

문제는 평이했으나 어떻게 하면 더 간단하게 구현할 수 있을지 고민해보는 것이 좋다. 
문제를 풀때는 AsList메소드가 기억나지 않아 위와 같은 방법으로 구현했다. 
아래는 AsList를 이용하는 경우 

return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") +"에 있다";
로 간단하게 구현할 수 있다. 

*/