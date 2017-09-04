
public class Test {

    public static void main(String[] args) {
        getN(430);
        getM(890);
    }

    public static void getN(int n){
        if (n < 1) {
            return;
        }
        int a = n % 10;
        System.out.println(a);
        n /= 10;
        getN(n);
    }

    public static void getM(int n){
        char[] chars = Integer.toString(n).toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            System.out.println(chars[i]);
        }
    }



}
