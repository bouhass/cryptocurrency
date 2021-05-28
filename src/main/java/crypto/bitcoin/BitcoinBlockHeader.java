package crypto.bitcoin;

import static crypto.util.CryptoUtils.readNumberFromLittleEndianHex;
import static crypto.util.CryptoUtils.swapEndians;

public class BitcoinBlockHeader {

    // 4 bytes little-endian
    long version;
    // 32 bytes little-endian
    String previousBlockHash;
    // 32 bytes little-endian
    String merkleRoot;
    // 4 bytes little-endian
    long time;
    // 4 bytes little-endian
    String bits;
    // 4 bytes little-endian
    long nonce;

    static BitcoinBlockHeader createFrom(String rawHeader) {
        BitcoinBlockHeader header = new BitcoinBlockHeader();
        header.version = readNumberFromLittleEndianHex(rawHeader.substring(0, 8));
        header.previousBlockHash = swapEndians(rawHeader.substring(8, 72));
        header.merkleRoot = swapEndians(rawHeader.substring(72, 136));
        header.time = readNumberFromLittleEndianHex(rawHeader.substring(136, 144));
        header.bits = swapEndians(rawHeader.substring(144, 152));
        header.nonce = readNumberFromLittleEndianHex(rawHeader.substring(152, 160));
        return header;
    }

    @Override
    public String toString() {
        return "BitcoinBlockHeader{" +
                "version='" + version + '\n' +
                ", previousBlockHash='" + previousBlockHash + '\n' +
                ", merkleRoot='" + merkleRoot + '\n' +
                ", time='" + time + '\n' +
                ", bits='" + bits + '\n' +
                ", nonce='" + nonce + '\n' +
                '}';
    }

}
