package Task1;

/**
 Change by places first and last letters in each second string of list or array"
 */
public class ChangeLetters {

    public static void main(String[] args) {
        String s = "Change by places first and last letters in each second string of list or array";
        System.out.println(s + " \n");

        String[] w = s.split(" ");

        for (int i = 0; i < w.length; i++) {
            if (i % 2 != 0) {
                String[] c = w[i].split("");
                String b = c[0];
                c[0] = c[c.length - 1];
                c[c.length - 1] = b;
                String temp = "";
                for (int j = 0; j < c.length; j++) {
                    temp += c[j];
                }
                w[i] = temp;
            }
        }
        for (String g : w) {
            System.out.print(g+" ");
        }
    }
}
