package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

// 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
//
// 길이가 짧은 것부터
// 길이가 같으면 사전 순으로
public class WordSort
{

    public static void main(String[] args) throws IOException
    {
        WordSort ws = new WordSort();
        ws.solution();
    }





    private void solution() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        // key가 단어의 길이, value가 길이에 해당되는 단어들
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        IntStream.range(0, num)
                 .forEach(i -> {
                     try
                     {
                         String word = br.readLine();
                         int length = word.length();

                         List<String> strings = map.get(length);

                         if ( null == strings ) // 단어의 길이에 해당되는 배열이 비어있을 경우, 리스트를 새로 생성
                         {
                             List<String> newList = new ArrayList<>();
                             newList.add(word);
                             map.put(length, newList);
                         }
                         else // 단어의 길이에 해당되는 배열이 있을 경우, 해당 배열에 단어 추가
                         {
                             strings.add(word);
                             map.put(length, strings);
                         }
                     }
                     catch ( IOException e )
                     {
                         e.printStackTrace();
                     }
                 });

        // i, wont, hesitate, no, more, no, it
        // 1 -> [i]
        // 2 -> [no, no, it]
        // 4 -> [wont, more]
        // 8 -> [hesitate]

        map.forEach((integer, strings) -> strings.stream()
                                                 .distinct()
                                                 .sorted()
                                                 .forEach(word -> System.out.println(word)));
    }

}
