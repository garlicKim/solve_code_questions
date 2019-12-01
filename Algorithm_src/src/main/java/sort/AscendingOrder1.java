package sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
// 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
public class AscendingOrder1 {

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];

        IntStream.range(0, num)
                .forEach(i -> nums[i] = sc.nextInt());

        Arrays.sort(nums);
        Arrays.stream(nums)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        AscendingOrder1 sa =  new AscendingOrder1();
        sa.solution();
    }

}
