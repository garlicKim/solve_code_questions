package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

// 2차원 평면 위의 점 N개가 주어진다.
// 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

// 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
public class Location1
{
    public static void main(String[] args) throws IOException
    {
        Location1 location1 = new Location1();
        location1.solution();
    }





    private void solution() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        // value를 TreeSet으로 가지는 TreeMap 생성
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

        IntStream.range(0, num)
                 .forEach(i -> {
                     try
                     {
                         String line = br.readLine();
                         String[] strings = line.split("\\s"); // space를 기준으로 split

                         int firstOfString = Integer.parseInt(strings[0]);
                         int secondOfString = Integer.parseInt(strings[1]);

                         TreeSet<Integer> set;
                         if ( null == map.get(firstOfString) ) // value가 비어있으면 TreeSet 생성
                         {
                             set = new TreeSet<>();
                         }
                         else
                         {
                             set = map.get(firstOfString); // value가 있으면 set 변수 꺼내오기
                         }

                         set.add(secondOfString); // treeSet에 add
                         map.put(firstOfString, set); // treeMap에 put
                     }
                     catch ( IOException e )
                     {
                         e.printStackTrace();
                     }
                 });

        for ( Integer i : map.keySet() )
        {
            TreeSet<Integer> integers = map.get(i);
            integers.forEach(value -> System.out.println(i + " " + value));
        }

    }
}
