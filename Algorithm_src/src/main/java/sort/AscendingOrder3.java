package sort;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
public class AscendingOrder3 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] nums = new int[num];

        IntStream.range(0, num)
                .forEach(i -> {
                    try {
                        nums[i] = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        int[] result = countingSort(nums);

        Arrays.stream(result)
                .forEach(value -> {
                            try {
                                bw.write(value + "\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );

        bw.flush();
        bw.close();
    }

    private int[] countingSort(int[] nums) {

        int[] newArr = new int[nums.length];

        // 최대값 구하기
        int max = 0;
        for (int i : nums) {
            if (i > max)
                max = i;
        }

        // 중복 원소 갯수 count
        int[] countedArray = new int[max + 1];
        for (int i : nums)
            countedArray[i]++;

        // 누적 개수 count
        for (int i = 1; i < countedArray.length; i++) {
            countedArray[i] = countedArray[i - 1] + countedArray[i];
        }

        // counting 정렬
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = nums[i];
            newArr[--countedArray[index]] = nums[i];
        }

        return newArr;
    }

    public static void main(String[] args) throws IOException {
        AscendingOrder3 sa = new AscendingOrder3();
        sa.solution();
    }

}
