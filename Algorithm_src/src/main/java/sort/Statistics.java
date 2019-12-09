package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다.
// 단, N은 홀수라고 가정하자.
//
// 산술평균 : N개의 수들의 합을 N으로 나눈 값
// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
// 최빈값 : N개의 수들 중 가장 많이 나타나는 값
// 범위 : N개의 수들 중 최댓값과 최솟값의 차이
// N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
public class Statistics
{

    public static void main(String[] args) throws IOException
    {
        Statistics stc = new Statistics();
        stc.solution();
    }





    private void solution() throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] nums = new int[num];

        IntStream.range(0, num)
                 .forEach(i -> {
                     try
                     {
                         nums[i] = Integer.parseInt(br.readLine());
                     }
                     catch ( IOException e )
                     {
                         e.printStackTrace();
                     }
                 });

        // 산술평균 : N개의 수들의 합을 N으로 나눈 값
        int average = getAverage(nums);
        System.out.println(average);

        // 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        int center = getCenter(nums);
        System.out.println(center);

        // 최빈값 : N개의 수들 중 가장 많이 나타나는 값, 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력
        int frequent = getFrequent(nums);
        System.out.println(frequent);

        // 범위 : N개의 수들 중 최댓값과 최솟값의 차이
        int differ = getDiffer(nums);
        System.out.println(differ);

    }





    // 산술 평균
    private int getAverage(int[] nums)
    {
        OptionalDouble average = Arrays.stream(nums)
                                       .average();
        return (int) Math.round(average.getAsDouble());
    }





    // 중앙값
    private int getCenter(int[] nums)
    {
        Arrays.sort(nums);
        int index = nums.length / 2;
        return nums[index];
    }





    // 최빈값
    private int getFrequent(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums)
              .forEach(i -> {
                  Integer value = map.get(i);
                  if ( value == null )
                  {
                      map.put(i, 1);
                  }
                  else
                  {
                      map.put(i, ++value);
                  }
              });

        // max value 구하기
        int maxValue = Arrays.stream(nums)
                             .map(key -> map.get(key))
                             .max()
                             .getAsInt();

        // max value를 가진 key를 collect
        List<Integer> collectKeys = Arrays.stream(nums)
                                          .filter(key -> map.get(key)
                                                            .equals(maxValue))
                                          .boxed()
                                          .distinct()
                                          .collect(Collectors.toList());

        if ( collectKeys.size() > 1 )
        {
            return collectKeys.get(1);
        }
        else
        {
            return collectKeys.get(0);
        }
    }





    // 범위
    private int getDiffer(int[] nums)
    {

        int max = Arrays.stream(nums)
                        .max()
                        .getAsInt();
        int min = Arrays.stream(nums)
                        .min()
                        .getAsInt();

        return max - min;
    }

}
