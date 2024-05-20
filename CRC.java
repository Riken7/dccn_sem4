import java.util.Scanner;
public class CRC {
    public static void main(String[] args) {

        System.out.println("Enter the data bits: ");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String data2 = data;
        System.out.println("Enter the divisor: ");
        String divisor = sc.nextLine();
        sc.close();
        for(int i=0 ; i<divisor.length()-1 ; i++) {
            data = data + "0";
        }
        String remainder = xor(data, divisor);
        System.out.println("CRC output : " +remainder);
        String transmittedData = data2 + remainder;
        System.out.println(transmittedData);
        receiver(transmittedData, divisor);
    }
    public static String xor(String data, String divisor) {
        while(data.length() >= divisor.length()) {
            String temp = "";
            for(int i=0 ; i<divisor.length() ; i++) {
                temp += (data.charAt(i) ^ divisor.charAt(i));
            }
            data = temp + data.substring(divisor.length(), data.length());
            if(data.charAt(0) == '0' ) {
                data = data.substring(1);
            }
        }
        return data;
    }
    public static void receiver(String transmittedData, String divisor) {

        String remainder = xor(transmittedData, divisor);
        System.out.println(remainder);
        if (Integer.parseInt(remainder) == 0) {
            System.out.println("Data is received without any error.");
        } else {
            System.out.println("Data is received with errors.");
        }
    }

}
