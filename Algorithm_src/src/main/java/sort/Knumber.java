package sort;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Arrays.*;

public class Knumber {

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = stream(commands).map(ints -> {
            int[] newArr = copyOf(array, array.length);
            newArr = copyOfRange(newArr, ints[0] - 1, ints[1]);

            sort(newArr);

            return newArr[ints[2] - 1];
        }).mapToInt(i -> i).toArray();
        return answer;
    }

    @Test
    public void test1() {

        int origin[] = {1, 5, 2, 6, 3, 7, 4};
        int arr[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int answer[] = {5, 6, 3};

        Assert.assertEquals(answer[0], solution(origin, arr)[0]);
    }
}
