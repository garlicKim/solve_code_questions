package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
public class NandM3
{
    static int           N;
    static int           M;

    static int           list[];

    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stringLine = br.readLine();
        String[] split = stringLine.split("\\s");

        N = Integer.parseInt(split[0]); // 1부터 N까지
        M = Integer.parseInt(split[1]); // M개를 뽑아 모두 나열

        list = new int[9];

        solution(0);

        for ( String s : queue )
        {
            System.out.println(s);
        }

    }





    static void solution(int cnt)
    { // DFS메소드, 반복횟수를 인자로 받는다. 초기 0부터 시작

        if ( cnt == M )
        { // 0부터 M번까지 반복했으면 하나의 처리가 완성
            StringBuilder str = new StringBuilder();

            for ( int i = 0; i < M; i++ )
            {
                str.append(list[i])
                   .append(" ");
            }

            queue.add(str.toString());
            return; // DFS 종료
        }

        // N : 1 2 3 4
        // M : 3
        for ( int i = 1; i <= N; i++ )
        { // 수의 범위는 1부터 N까지이다.

            list[cnt] = i; // 현재 반복횟수에 해당하는 배열에 i값을 추가

            solution(cnt + 1); // 반복횟수를 증가
        }

    }

}
