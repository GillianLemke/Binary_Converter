/*
    Gillian Lemke
    Project 1
    COSC221
    BinaryToDecimal Class converts binary strings to decimal values from signed magnitude, ones complement,
    twos complement, and excess-512.
 */
public class BinaryToDecimal {

    /**
     * Converts a binary string to an integer, unsigned
     *
     * @param n a binary string
     * @return decimal value of the binary string
     */
    public int toDecimal(String n) {
        int decimal = Integer.parseInt(n, 2);
        return decimal;
    }

    /**
     * Converts a binary string to an integer from signed magnitude
     *
     * @param n a binary string
     * @return decimal value of the signed magnitude binary string
     */
    public int fromSigned(String n) {
        int fromSignedMag = 0;

        BinaryToDecimal fromSigned = new BinaryToDecimal();

        if (n.substring(0, 1).equals("0")) {
            fromSignedMag = Integer.parseInt(n, 2);
            System.out.println(fromSignedMag);
        } else {
            String withoutSign = n.substring(1);
            fromSignedMag = ((-1) * fromSigned.toDecimal(withoutSign));
        }
        return fromSignedMag;
    }

    /**
     * Converts a binary string to an integer from ones complement
     *
     * @param n a binary string
     * @return decimal value of the ones complement binary string
     */
    public int fromOnesComplement(String n) {
        int fromOnesComp = 0;

        if (n.substring(0, 1).equals("0")) {
            fromOnesComp = Integer.parseInt(n, 2);
        } else {
            String flipBits = n.substring(1).replace('0', '2').replace('1', '0').replace('2', '1');
            fromOnesComp = (-1) * Integer.parseInt(flipBits, 2);
        }

        return fromOnesComp;
    }

    /**
     * Converts a binary string to an integer from twos complement
     *
     * @param n a binary string
     * @return decimal value of the twos complement binary string
     */
    public int fromTwosComplement(String n) {
        int fromTwosComp = 0;

        if (n.substring(0, 1).equals("0")) {
            fromTwosComp = Integer.parseInt(n, 2) - 1;
        } else {
            String flipBits = n.substring(1).replace('0', '2').replace('1', '0').replace('2', '1');
            fromTwosComp = ((-1) * Integer.parseInt(flipBits, 2)) - 1;
        }

        return fromTwosComp;
    }

    /**
     * Converts a binary string to an integer from excess-512 notation
     *
     * @param n a binary string
     * @return decimal value of the excess-512 binary string
     */
    public int fromExcess512(String n) {
        BinaryToDecimal fromExcess = new BinaryToDecimal();
        int fromExcess512 = fromExcess.toDecimal(n) - 512;
        return fromExcess512;
    }
}
