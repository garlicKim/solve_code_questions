 ## N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오_01
 ### 문제설명
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.  
이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.  


### 제한사항
* 시간 복잡도가 O(n²)인 정렬 알고리즘으로 풀 수 있습니다. 예를 들면 삽입 정렬, 거품 정렬 등이 있습니다.
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
~~~

출처 : 백준  https://www.acmicpc.net/problem/2750