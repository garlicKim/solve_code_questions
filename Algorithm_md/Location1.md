 ## 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오_01  
 ### 문제설명
2차원 평면 위의 점 N개가 주어진다.   
좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.  



### 제한사항
* 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.   
* 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.  
 (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.     
* 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.  

 **입출력 예**  

|입력|출력|
|---------|-------|
|5       |         |
|3  &nbsp;&nbsp;  4  | 1  &nbsp;&nbsp;  -1 |
|1  &nbsp;&nbsp;  1  | 1  &nbsp;&nbsp;  1  |
|1  &nbsp;&nbsp; -1  | 2  &nbsp;&nbsp;  2  |
|2  &nbsp;&nbsp;  2  | 3  &nbsp;&nbsp;  3  |
|3  &nbsp;&nbsp;  3  | 3  &nbsp;&nbsp;  4  |

------------
### 나의 풀이
~~~java
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
~~~

출처 : 백준  https://www.acmicpc.net/problem/11650