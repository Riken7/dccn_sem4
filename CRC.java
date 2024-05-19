import java.util.Scanner;
public class CRC {
    public static void main(String[] args) {

        System.out.println("Enter the data bits: ");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        // String data = "10110011";
        System.out.println("Enter the divisor: ");
        String divisor = sc.nextLine();
        // String divisor = "10011";
        sc.close();
        for(int i=0 ; i<divisor.length()-1 ; i++) {
            data = data + "0";
        }
        // System.out.println(data);
        // System.out.println(divisor);
        
        String remainder = xor(data, divisor);
        System.out.println("CRC output : " +remainder);
    }
    public static String xor(String data, String divisor) {
        while(data.length() >= divisor.length()) {
            String temp = "";
            for(int i=0 ; i<divisor.length() ; i++) {
                temp += (data.charAt(i) ^ divisor.charAt(i));
            }
            data = temp + data.substring(divisor.length(), data.length());
            while(data.charAt(0) == '0' ) {
                data = data.substring(1);
            }
        }
        return data;
    }
}
