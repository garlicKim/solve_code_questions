package basic;

import java.util.ArrayList;
import java.util.List;

public class FullScaleTest {

    public static void main(String[] args) throws Exception {

        FullScaleTest s = new FullScaleTest();

        int[] marks = {8,9,10};

        System.out.println(s.solution(marks));

    }


    public int solution(int[] marks){

        List<Integer> list = changeArray(marks);

        int min = 0;

        double deviceMark =  devideMarks(list);

        while (deviceMark < 9.5){
            list.add(10);
            deviceMark = devideMarks(list);
            min++;
        }

        return min;

    }

    // 점수들을 합산하여 평균을 구함
    public double devideMarks(List<Integer> marks){
        double sum = 0;


        for(int mark : marks)
        {
            sum += mark;
        }


        return sum/marks.size();

    }

    // array를 list로 변경
    public List changeArray(int[] ints){
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : ints)
        {
            intList.add(i);
        }

        return intList;
    }
}
