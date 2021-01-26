import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i=0;i<b;i++){
            for(int j=0; j<a;j++)
                System.out.print("*");
            System.out.println();
        }
    }
}

/*
COMMENT
axb인 직사각형을 "*"을 이용하여 출력하는 문제이다. 
이중 for문으로 간단하게 구현할 수 있다. 
*/