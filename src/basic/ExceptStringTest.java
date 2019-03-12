package basic;

import java.util.ArrayList;
import java.util.List;

public class ExceptStringTest {
    public static void main(String[] args) throws Exception {

        // 테스트 케이스
        String[] participant = {"eden", "kiki", "kiki", "leo"};
        String[] completion = {"kiki", "eden", "leo"};


        ExceptStringTest s = new ExceptStringTest();
        System.out.println(s.solution(participant, completion));


    }

    public String solution(String[] participant, String[] completion) {

        List<String> participantList = changeArray(participant);
        List<String> completionList = changeArray(completion);


        for(int i=0; i< completionList.size(); i++){
            participantList.remove(completionList.get(i));
        }

        String answer = participantList.get(0);
        return answer;
    }


    // array를 list로 변경
    public List changeArray(String[] strs) {
        List<String> strList = new ArrayList<String>();
        for (String s : strs) {
            strList.add(s);
        }

        return strList;
    }
}
