package crypto.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class CryptoUtils {

    public static byte[] decodeHex(String hex) {
        try {
            return Hex.decodeHex(hex);
        } catch (DecoderException e) {
            throw new RuntimeException(e);
        }
    }

    public static String swapEndians(String hex) {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException("input size must be even!");
        }
        StringBuilder swapped = new StringBuilder();
        for (int i = hex.length(); i > 0; i = i - 2) {
            swapped.append(hex, i - 2, i);
        }
        return swapped.toString();
    }

    public static long readNumberFromLittleEndianHex(String hex) {
        return Long.parseLong(swapEndians(hex), 16);
    }

}
