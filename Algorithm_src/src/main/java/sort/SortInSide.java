package sort;

import java.io.*;
import java.util.Arrays;

// 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
// 첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
public class SortInSide
{

    public static void main(String[] args) throws IOException
    {
        SortInSide si = new SortInSide();
        si.solution();
    }





    private void solution() throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        String stringNumver = br.readLine();

        int length = stringNumver.length();

        // 입력된 수의 길이만큼 배열 생성성
        char[] chars = new char[length];

        // 한자리씩 get해서 char 배열에 set
        for ( int index = 0; index < length; index++ )
        {
            chars[index] = stringNumver.charAt(index);
        }

        // 오름차순 정렬
        Arrays.sort(chars);

        // 오름차순 정렬된 배열에서 뒤에서부터 값을 get
        for ( int index = length - 1; index >= 0; index-- )
        {
            bw.write(chars[index]);
        }

        bw.flush();
        bw.close();
    }
}
