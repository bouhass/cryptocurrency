package crypto.bitcoin;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.IOException;

public class BitcoinMain {

    public static void main(String[] args) throws IOException, DecoderException {
//        byte[] bytes = BitcoinBlock.class.getResourceAsStream("blk00000.dat").readAllBytes();
//        String hexEncoded = new String(bytes);
//        BitcoinBlockReader.readBlockData(Hex.decodeHex(hexEncoded));\

        byte[] bytes = BitcoinBlock.class.getResourceAsStream("0000000000002917ed80650c6174aac8dfc46f5fe36480aaef682ff6cd83c3ca.dat").readAllBytes();
        String hexEncoded = new String(bytes);
        BitcoinBlock block = BitcoinBlockReader.readBlockData(Hex.decodeHex(hexEncoded));
        System.out.println(block);
    }

}
