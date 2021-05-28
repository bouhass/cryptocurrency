package crypto.bitcoin;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.logging.Logger;

import static crypto.util.CryptoUtils.decodeHex;
import static crypto.util.CryptoUtils.readNumberFromLittleEndianHex;

public class BitcoinBlockReader {

    static final Logger log = Logger.getLogger(BitcoinBlockReader.class.getName());

    static final int MAGIC_BYTES_ARRAY_LENGTH = 4;
    static final int SIZE_ARRAY_LENGTH = 4;
    static final int BLOCK_HEADER_ARRAY_LENGTH = 80;

    final static byte[] mainnet_magic_bytes = decodeHex("f9beb4d9");
    final static byte[] testnet3_magic_bytes = decodeHex("0b110907");
    final static byte[] regtest_magic_bytes = decodeHex("fabfb5da");

    static BitcoinBlock readBlockData(String data) {
        BitcoinBlock block = new BitcoinBlock();
        block.setSize(readNumberFromLittleEndianHex(data.substring(8, 16)));
        block.setHeader(BitcoinBlockHeader.createFrom(data.substring(16, 176)));
        log.info("block data: \n" + block);
        return block;
    }

    static BitcoinBlock readBlockData(byte[] data) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(data);
        BitcoinBlock block = new BitcoinBlock();
        readMagicBytes(byteBuffer, block);
        readSize(byteBuffer, block);
        readBlockHeader(byteBuffer, block);
        log.info("block data: \n" + block);
        return block;
    }

    private static void readMagicBytes(ByteBuffer byteBuffer, BitcoinBlock block) {
        byte[] magicBytes = new byte[MAGIC_BYTES_ARRAY_LENGTH];
        byteBuffer.get(magicBytes);
        log.info("magic number: " + Arrays.toString(magicBytes));
        block.setMagicBytes(magicBytes);
        block.setNetwork(getNetwork(magicBytes));
    }

    static String getNetwork(byte[] magicBytes) {
        if (Arrays.equals(magicBytes, mainnet_magic_bytes)) {
            return "Mainnet";
        } else if (Arrays.equals(magicBytes, testnet3_magic_bytes)) {
            return "Testnet3";
        } else if (Arrays.equals(magicBytes, regtest_magic_bytes)) {
            return "Regtest";
        } else {
            return "";
        }
    }

    private static void readSize(ByteBuffer byteBuffer, BitcoinBlock block) {
        byte[] sizeBytes = new byte[SIZE_ARRAY_LENGTH];
        byteBuffer.get(sizeBytes);
        long size = readBlockSize(sizeBytes);
        log.info("size: " + size);
        block.setSize(size);
    }

    static long readBlockSize(String encodedSize) {
        if (encodedSize.length() != 8)
            throw new IllegalArgumentException("block size array should be of length " + SIZE_ARRAY_LENGTH);
        return readNumberFromLittleEndianHex(encodedSize);
    }

    static long readBlockSize(byte[] sizeArray) {
        if (sizeArray.length != SIZE_ARRAY_LENGTH)
            throw new IllegalArgumentException("block size array should be of length " + SIZE_ARRAY_LENGTH);
        long size = 0;
        int multiplicator = 1;
        for (int i = 0; i < 4; i++) {
            size += Byte.toUnsignedLong(sizeArray[i]) * multiplicator;
            multiplicator *= 256;
        }
        return size;
    }

    private static void readBlockHeader(ByteBuffer byteBuffer, BitcoinBlock block) {
        byte[] blockHeaderBytes = new byte[BLOCK_HEADER_ARRAY_LENGTH];
//        block.setHeader(BitcoinBlockHeader.createFrom());
    }

}
