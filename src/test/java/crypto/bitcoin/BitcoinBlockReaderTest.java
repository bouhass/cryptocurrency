package crypto.bitcoin;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

import static crypto.bitcoin.BitcoinBlockReader.readBlockData;
import static crypto.bitcoin.BitcoinBlockReader.readBlockSize;
import static org.junit.jupiter.api.Assertions.*;

class BitcoinBlockReaderTest {

    @Test
    void testReadBlockData() {
        BitcoinBlock block = readBlockData("f9beb4d91d0100000100000000000000000000000000000000000000000000000000000000000000000000003ba3edfd7a7b12b27ac72c3e67768f617fc81bc3888a51323a9fb8aa4b1e5e4a29ab5f49ffff001d1dac2b7c0101000000010000000000000000000000000000000000000000000000000000000000000000ffffffff4d04ffff001d0104455468652054696d65732030332f4a616e2f32303039204368616e63656c6c6f72206f6e206272696e6b206f66207365636f6e64206261696c6f757420666f722062616e6b73ffffffff0100f2052a01000000434104678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5fac00000000");
//        assertEquals("f9beb4d9", new String(Hex.encodeHex(block.getMagicBytes())));
//        assertEquals("Mainnet", block.getNetwork());
        assertEquals(285, block.getSize());
        BitcoinBlockHeader header = block.getHeader();
        assertEquals(1L, header.version);
    }

    @Test
    void testReadBlockSize() {
        assertEquals(285, readBlockSize(new byte[] { 29, 1, 0, 0 })); // 1d010000
        assertEquals(285, readBlockSize("1d010000")); //
//        assertEquals(8359, readBlockSize("9500c43a")); //
    }

}