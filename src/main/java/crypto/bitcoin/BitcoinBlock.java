package crypto.bitcoin;

import java.util.Arrays;
import java.util.logging.Logger;

public class BitcoinBlock {

    static final Logger log = Logger.getLogger(BitcoinBlock.class.getName());

    private byte[] magicBytes;
    private String network;
    private long size;
    private BitcoinBlockHeader header;

    public byte[] getMagicBytes() {
        return magicBytes;
    }

    public void setMagicBytes(byte[] magicBytes) {
        this.magicBytes = magicBytes;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public BitcoinBlockHeader getHeader() {
        return header;
    }

    public void setHeader(BitcoinBlockHeader header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "BitcoinBlock{" +
                "magicBytes=" + Arrays.toString(magicBytes) +
                ", network='" + network + '\'' +
                ", size=" + size +
                ", header=" + header +
                '}';
    }
}
