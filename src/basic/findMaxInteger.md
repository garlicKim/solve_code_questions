## 자연수 n이 주어졌을 때, n의 다음 큰 숫자를 찾아라.
#### 문제 설명
* 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
* 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
* 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
* 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
* 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

~~~java
public int solution(int n) {

        String binaryOfN = Integer.toBinaryString(n);   // 주어진 n의 이진수 변환

        int countOfN = count(binaryOfN);    // 2진수 n의 1의 갯수

        while (true){

            if(count(Integer.toBinaryString(++n)) == countOfN){
                break;
            }

        }

       // int answer = 0;
        return n;
    }

    // 주어진 2진수 값의 1 갯수 counting
    private int count(String binaryOfN) {

        int num = 0;

        for(int i=0;i<binaryOfN.length(); i++){
            if(binaryOfN.charAt(i) == '1'){
                num++;
            }
        }

        return num;

    }
~~~    
