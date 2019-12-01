 ## N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오_02
 ### 문제설명
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.  
둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.  


### 제한사항
* 시간 복잡도가 O(nlogn)인 정렬 알고리즘으로 풀 수 있습니다. 예를 들면 병합 정렬, 힙 정렬 등이 있지만, 어려운 알고리즘이므로 지금은 언어에 내장된 정렬 함수를 쓰는 것을 추천드립니다.
* 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다. 

 **입출력 예**  
 
|입력|출력|
|---|---|
|5  |   |
|5  |1  |
|2  |2  |
|3  |3  |
|4  |4  |
|1	|5  |

------------
### 나의 풀이
~~~java
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
~~~

출처 : 백준  https://www.acmicpc.net/problem/2751