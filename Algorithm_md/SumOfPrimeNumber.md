## 2부터 N까지의 모든 소수의 합을 구하시오.
* N이 7이라면 {2,3,5,7} = 17을 출력
* N의 범위는 2이상 10,000,000이하  

~~~java

public int sumOfPrimeNumber(int n) {

        int sum = 0;    // 소수의 합을 담을 변수

        for (int i = 2; i <= n; i++) {
            boolean isPrimeNumber = true;

            // 소수인지 판별
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            // 소수이면 sum 값에 합산
            if (isPrimeNumber) {
                sum += i;
            }
        }
        return sum;
    }
~~~    




출처 : 프로그래머스 https://programmers.co.kr/learn/courses/30/lessons/14406
