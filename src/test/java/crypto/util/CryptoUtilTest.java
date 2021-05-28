package crypto.util;

import org.junit.jupiter.api.Test;

import static crypto.util.CryptoUtils.decodeHex;
import static crypto.util.CryptoUtils.swapEndians;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CryptoUtilTest {

    @Test
    void testDecodeHex() {
        byte[] expected = new byte[] { 31, 45, 1, 35 };
        byte[] actual = decodeHex("1f2d0123");
        assertArrayEquals(expected, actual);
    }

    @Test
    void testToLittleEndians() {
        assertEquals("1a6a93b3", swapEndians("b3936a1a"));
    }

}
