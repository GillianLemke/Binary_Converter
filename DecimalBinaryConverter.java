/*
    Gillian Lemke
    Project 1
    COSC221
    Driver class that converts decimal values to binary strings and binary strings to decimal values.
 */
import java.util.Scanner;

public class DecimalBinaryConverter {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        while (true) {

            System.out.println("Enter 0 if you would like to convert a decimal value to a 10-bit binary string or " +
                    "1 if you would like to convert a 10-bit binary string to a decimal value. Enter 9 to quit.");

            int numberType = keyboard.nextInt();
            keyboard.nextLine();

            if (numberType == 0) {

                System.out.print("Enter a decimal number: ");
                int decimal = keyboard.nextInt();

                DecimalToBinary decimalToBinary = new DecimalToBinary();

                String signed = decimalToBinary.toSignedMagnitude(decimal);
                System.out.println("The signed magnitude representation is " + signed);

                String onesComplement = decimalToBinary.toOnesComplement(decimal);
                System.out.println("The one's complement representation is " + onesComplement);

                String twosComplement = decimalToBinary.toTwosComplement(decimal);
                System.out.println("The twos's complement representation is " + twosComplement);

                String excess512 = decimalToBinary.toExcess512(decimal);
                System.out.println("The excess-512 representation is " + excess512);

            } else if (numberType == 1) {

                System.out.println("Enter a 10-bit binary string: ");
                String binary = keyboard.nextLine();

                BinaryToDecimal binaryToDecimal = new BinaryToDecimal();

                int fromSignedMagnitude = binaryToDecimal.fromSigned(binary);
                System.out.println("The decimal representation from signed magnitude is " + fromSignedMagnitude);

                int fromOnesComplement = binaryToDecimal.fromOnesComplement(binary);
                System.out.println("The decimal representation from ones complement is " + fromOnesComplement);

                int fromTwosComplement = binaryToDecimal.fromTwosComplement(binary);
                System.out.println("The decimal representation from twos complement is " + fromTwosComplement);

                int fromExcess512 = binaryToDecimal.fromExcess512(binary);
                System.out.println("The decimal representation from excess-512 is " + fromExcess512);

            } else if(numberType == 9) {

                System.out.println("Exiting...");
                System.exit(0);

            } else {
                System.out.println("You did not enter an input type option. Please try again.");
            }
        }
    }
}
