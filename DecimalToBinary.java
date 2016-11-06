/*
    Gillian Lemke
    Project 1
    COSC221
    DecimalToBinary class converts decimal numbers to binary strings in signed magnitude, ones complement,
    twos complement, and excess-512 notation.
 */
public class DecimalToBinary {

    /**
     * Converts an integer to an unsigned binary string
     *
     * @param n integer value
     * @return 10-bit unsigned binary string
     */
    public String toBinary(int n) {
        return String.format("%010d", Integer.parseInt(Integer.toBinaryString(Math.abs(n))));
    }

    /**
     * Determines if the integer is positive or negative
     *
     * @param n integer value
     * @return sign of the integer, 0 for positive, 1 for negative
     */
    public String determineSign(int n) {
        String sign = "";
        if (n >= 0) {
            sign = "0";
        } else {
            sign = "1";
        }
        return sign;
    }

    /**
     * Converts an integer to a binary string in signed magnitude
     *
     * @param n integer value
     * @return signed magnitude representation of the integer
     */
    public String toSignedMagnitude(int n) {
        String signed = "";
        DecimalToBinary newNumber = new DecimalToBinary();
        signed = newNumber.determineSign(n) + newNumber.toBinary(n).substring(1);
        return signed;
    }

    /**
     * Converts an integer to a binary string in ones complement
     *
     * @param n integer value
     * @return ones complement representation of the integer
     */
    public String toOnesComplement(int n) {
        String ones = "";
        DecimalToBinary newNumber = new DecimalToBinary();
        if (newNumber.determineSign(n).equals("0")) {
            ones = newNumber.toBinary(n);
        } else {
            ones = newNumber.toBinary(n).replace('0', '2').replace('1', '0').replace('2', '1');
        }
        return ones;
    }

    /**
     * Converts an integer to a binary string in twos complement
     *
     * @param n integer value
     * @return twos complement representation of the integer
     */
    public String toTwosComplement(int n) {
        DecimalToBinary newNumber = new DecimalToBinary();
        return newNumber.toOnesComplement(n + 1);
    }

    /**
     * Converts an integer to a binary string in excess-512 notation
     *
     * @param n integer value
     * @return excess-512 representation of the integer
     */
    public String toExcess512(int n) {
        int excess = n + 512;
        DecimalToBinary newNumber = new DecimalToBinary();
        return newNumber.toBinary(excess);
    }
}
