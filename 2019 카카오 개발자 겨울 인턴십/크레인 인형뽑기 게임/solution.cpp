#include <string>
#include <vector>

using namespace std;

void check(vector<int>& basket, int& answer){
    if(basket.empty()|| basket.size()<2)
        return;
    if (basket[basket.size()-1]==basket[basket.size()-2]){
        basket.pop_back(); basket.pop_back();
        answer+=2;
        check(basket, answer);
    }
    else return;
}

int solution(vector<vector<int>> board, vector<int> moves) {
    vector<int> basket;
    int answer = 0;
    if(board.size() <5 || board.size() > 30)
        return 0;
    for(int i=0 ; i<moves.size(); i++){
        for(int j=0; j<board.size() ;j++){
            if(board[j][moves[i]-1]!=0){
                basket.push_back(board[j][moves[i]-1]);
                board[j][moves[i]-1]=0;
                check(basket,answer);
                break;
            }
        }
    }
    return answer;
}

/*
COMMENT

어려웠던 부분
1. board 이차원 배열에서 열과 행을 헷갈림. 행과 열을 확인할 것
2. 위와 유사하게 이차원 배열에서 인덱스를 헷갈려 board 배열의 끝부분부터 확인함
-> 모두 배열의 인덱스와 관련된 부분으로 기초적인 실수를 범하지 말것.

고민한 부분
1. 콤보
: 위에 2개가 같아서 지운 후, 다시 위에 2개가 같아지는 경우
  이를 판단하기 위해 check 함수를 작성함 (재귀적으로 문제를 해결하기 위해)
 그러나 지금 생각해보니 콤보가 발생할 일이 없다. 


*/