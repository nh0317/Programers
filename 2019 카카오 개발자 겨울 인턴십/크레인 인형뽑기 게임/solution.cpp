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

������� �κ�
1. board ������ �迭���� ���� ���� �򰥸�. ��� ���� Ȯ���� ��
2. ���� �����ϰ� ������ �迭���� �ε����� �򰥷� board �迭�� ���κк��� Ȯ����
-> ��� �迭�� �ε����� ���õ� �κ����� �������� �Ǽ��� ������ ����.

����� �κ�
1. �޺�
: ���� 2���� ���Ƽ� ���� ��, �ٽ� ���� 2���� �������� ���
  �̸� �Ǵ��ϱ� ���� check �Լ��� �ۼ��� (��������� ������ �ذ��ϱ� ����)
 �׷��� ���� �����غ��� �޺��� �߻��� ���� ����. 


*/