package crypto.bitcoin;

import org.junit.jupiter.api.Test;

import static crypto.bitcoin.BitcoinBlockHeader.createFrom;
import static org.junit.jupiter.api.Assertions.*;

class BitcoinBlockHeaderTest {

    @Test
    void testCreateFrom() {
        String block = "010000009500c43a25c624520b5100adf82cb9f9da72fd2447a496bc600b0000000000006cd862370395dedf1da2841ccda0fc489e3039de5f1ccddef0e834991a65600ea6c8cb4db3936a1ae3143991";
        String rawHeader = block.substring(0, 160);
        BitcoinBlockHeader header = createFrom(rawHeader);
        assertEquals(1L, header.version);
        assertEquals("0000000000000b60bc96a44724fd72daf9b92cf8ad00510b5224c6253ac40095", header.previousBlockHash);
        assertEquals("0e60651a9934e8f0decd1c5fde39309e48fca0cd1c84a21ddfde95033762d86c", header.merkleRoot);
        assertEquals(1305200806L, header.time);
        assertEquals("1a6a93b3", header.bits);
        assertEquals(2436437219L, header.nonce);
    }
}