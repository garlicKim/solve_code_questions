 ## N과 M (4)  
 ### 문제설명
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.  

1부터 N까지 자연수 중에서 M개를 고른 수열  
같은 수를 여러 번 골라도 된다.  
고른 수열은 비내림차순이어야 한다.  
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.  

### 제한사항
* 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)   
* 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.   
* 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.   
* 수열은 사전 순으로 증가하는 순서로 출력해야 한다.  

 **입출력 예**  
 
|입력|출력|
|----|----|
|3 1 | 1  |
|    | 2  |
|    | 3  |

|입력|출력|
|----|------|
|4 2 | 1 1  |
|    | 1 2  |
|    | 1 3  |
|    | 1 4  |
|    | 2 2  |
|    | 2 3  |
|    | 2 4  |
|    | 3 3  |
|    | 3 4  |
|    | 4 4  |



------------
### 나의 풀이
~~~java
public class NandM4
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

            // 비오름차순으로 된 list만 재귀를 탄다. (비오름차순이 아닌건 탐색할 필요 x)
            if ( cnt == 0 )
            {
                solution(cnt + 1); // 반복횟수를 증가
            }
            else if ( list[cnt - 1] <= list[cnt] )
            {
                solution(cnt + 1); // 반복횟수를 증가
            }
        }

    }

}
~~~

출처 : 백준  https://www.acmicpc.net/problem/15652