package basic;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 프로그래머스 카펫 문제
public class Carpet {

    public Integer[] result(int brown, int red) {

        if (brown < 8 || brown > 5001 || red < 1 || red > 2000000)
            throw new IllegalArgumentException();

        ArrayList<Integer> factorization = factorization(brown + red);

        Integer[] result = {1, 1};

        int pointer = factorization.size() / 2;

        if (factorization.size() % 2 == 0) {

            for (int i = 0; i <= pointer - 1; i++) {
                result[0] = result[0] * factorization.get(i);
            }

            for (int i = pointer; i < factorization.size(); i++) {
                result[1] = result[1] * factorization.get(i);
            }
        } else {
            for (int i = 0; i <= pointer; i++) {
                result[0] = result[0] * factorization.get(i);
            }

            for (int i = pointer + 1; i < factorization.size(); i++) {
                result[1] = result[1] * factorization.get(i);
            }
        }

        Arrays.sort(result, Collections.reverseOrder());

        return result;

    }


    private ArrayList<Integer> factorization(int arg) {
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            if (isSosu(arg)) {
                list.add(arg);
                break;
            }
            for (int i = 2; i < arg; i++) {
                if (arg % i == 0) {
                    list.add(i);
                    arg /= i;
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 입력된 숫자가 소수인지 아닌지를 구분해준다.
     *
     * @param x 소수인지 여부를 파악할 숫자
     * @return 소수라면 true를, 아니라면 false.
     */
    private boolean isSosu(long x) {
        boolean isSosu = true;
        if (x == 1 || x == 2)
            return true;
        for (long i = 2; i < x; i++) {
            if (x % i == 0) {
                isSosu = false;
                break;
            }
        }
        return isSosu;
    }


    @org.junit.Test
    public void tt() {
        Integer[] arr = new Integer[2];
        arr[0] = 4;
        arr[1] = 3;
        Assert.assertArrayEquals(arr, result(10, 2));

        arr[0] = 3;
        arr[1] = 3;
        Assert.assertArrayEquals(arr, result(8, 1));

        arr[0] = 7;
        arr[1] = 3;

        arr[0] = 7;
        arr[1] = 4;
        Assert.assertArrayEquals(arr, result(18, 10));

        arr[0] = 9;
        arr[1] = 5;
        Assert.assertArrayEquals(arr, result(24, 21));

        arr[0] = 8;
        arr[1] = 6;
        Assert.assertArrayEquals(arr, result(24, 24));


    }


}



