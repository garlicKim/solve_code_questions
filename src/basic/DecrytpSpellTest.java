package basic;

public class DecrytpSpellTest {

    public String decryptSpell(String str) {

        StringBuilder sb = new StringBuilder(str);

        int length = sb.length();

        if (length < 3) {
            return str;
        } else {
            for (int i = 3; i <= length; i = i + 3) {
                int asciiNum = (int) sb.charAt(i - 1);

                // 소문자이면
                if (asciiNum > 96 && asciiNum < 123) {
                    sb.setCharAt(i - 1, (char) (asciiNum - 32));
                } else {
                    sb.setCharAt(i - 1, '!');
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        DecrytpSpellTest spt = new DecrytpSpellTest();

        String result = spt.decryptSpell("aaaaAAAA000000aaaaaaa");

        System.out.println(result);

    }
}
