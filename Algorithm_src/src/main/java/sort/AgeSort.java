package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

// 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
//
// 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
// 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
// 입력은 가입한 순서로 주어진다.
public class AgeSort
{
    public static void main(String[] args) throws IOException
    {
        AgeSort as = new AgeSort();
        as.solution();
    }





    private void solution() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Map<Integer, List<String>> map = new TreeMap<>();

        IntStream.range(0, num)
                 .forEach(i -> {
                     try
                     {
                         String stringLine = br.readLine();
                         String[] split = stringLine.split("\\s");

                         Integer age = Integer.parseInt(split[0]);
                         String name = split[1];
                         List<String> list = map.get(age);

                         if ( null == list ) // 나이에 해당되는 배열이 비어있을 경우, 리스트를 새로 생성
                         {
                             List<String> newList = new ArrayList<>();
                             newList.add(name);
                             map.put(age, newList);
                         }
                         else // 나이에 해당되는 배열이 있을 경우, 해당 배열에 단어 추가
                         {
                             list.add(name);
                             map.put(age, list);
                         }

                     }
                     catch ( IOException e )
                     {
                         e.printStackTrace();
                     }
                 });

        map.forEach((age, names) -> names.stream()
                                         .forEach(word -> System.out.println(age + " " + word)));

    }
}
