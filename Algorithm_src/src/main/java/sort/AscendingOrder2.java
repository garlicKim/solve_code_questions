package sort;

import java.io.*;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
// 요구시간복잡도 : nlogN
public class AscendingOrder2 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        IntStream.range(0, num)
                .forEach(i -> {
                    try {
                        queue.add(Integer.parseInt(br.readLine()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        IntStream.range(0, num)
                .forEach(i -> {
                    try {
                        bw.write(queue.poll() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        AscendingOrder2 sa = new AscendingOrder2();
        sa.solution();
    }

}
