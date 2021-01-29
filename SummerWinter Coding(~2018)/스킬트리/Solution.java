import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Integer> check = new ArrayList<>();
        int index=0;
        for(int i=0;i<skill_trees.length;i++){
            for(int j=0; j<skill_trees[i].length();j++){
                if(skill.indexOf(skill_trees[i].charAt(j))>=0){
                    check.add(skill.indexOf(skill_trees[i].charAt(j)));
                }
            }
            for(Integer a : check){
                if (a==index)
                    index++;
            }
            if(index==check.size())
                answer++;
            check.clear();
            index=0;
        }
        
        return answer;
    }
}

/*
COMMENT

스킬간에 먼저 배워야하는 순서가 정해져있으며
이 순서가 skill이다. 
skill_trees배열 중 가능한 스킬트리의 수를 구해라 

우선 skill_trees의 각 문자열에 
skill의 문자가 몇 번째 인덱스에 있는지 확인하여 check ArrayList에 추가했다.
그리고 check 리스트가 0,1,2순으로 증가하는지 확인한다. 
0,1,2,순으로 증가했다면 answer의 수를 증가시키고
check리스트와 index를 초기화한다. 


그러나 이 문제는 정규식을 이용하면 더욱 간단하게 해결할 수 있다. 
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String st : skill_trees){
            String check=st.replaceAll("[^"+skill+"]","");
            if (skill.indexOf(check)==0)
                answer++;
        }
        return answer;
    }

이 풀이에서는 
skill_trees의 각 문자열에서 skill의 문자를 제외하고 모두 삭제한다. 
이 문자열이 skill 문자열에서 몇 번째 인덱스에 위치하는 지 검색한다. 
0번째 인덱스에 있다면 스킬순서로 스킬트리를 작성한 것이므로 
answer의 값을 증가한다. 


*/