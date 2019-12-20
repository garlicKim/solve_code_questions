 ## 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.  
 ### 문제설명
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.  
길이가 짧은 것부터  
길이가 같으면 사전 순으로  


### 제한사항
첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000)   
둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.  
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.  

 **입출력 예**  
 
|입력|출력|
|---|---|
|13         |            |
|but        | i          |
|i          | im         |
|wont       | it         |
|hesitate   | no         |
|no         | but        |
|more       | more       |
|no         | wait       |
|more       | wont       |
|it         | yours      |
|cannot     | cannot     |
|wait       | hesitate   |
|im         |            |
|yours      |            |


------------
### 나의 풀이
~~~java
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
~~~

출처 : 백준  https://www.acmicpc.net/problem/1181