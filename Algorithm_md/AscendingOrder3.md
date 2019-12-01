 ## N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오_03
 ### 문제설명
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다.
둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.


### 제한사항
* 수의 범위가 작다면 카운팅 정렬을 사용하여 더욱 빠르게 정렬할 수 있습니다.  
* 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다. 

 **입출력 예**  
 
|입력|출력|
|---|---|
|10 |   |
|5  |1  |
|2  |1  |
|3  |2  |
|1  |2  |
|4	|3  |
|2  |3  |
|3  |4  |
|5  |5  |
|1  |5  |
|7  |7  |


------------
### 나의 풀이
~~~java
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
~~~

출처 : 백준  https://www.acmicpc.net/problem/10989