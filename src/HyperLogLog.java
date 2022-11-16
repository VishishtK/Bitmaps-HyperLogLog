import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.Stream;

public class HyperLogLog {
    BitSet[] registers;
    int noOfRegisters;
    int bitsPerRegister;
    HashFunctions hashFunction;
    HashFunctions geometricHashFunction;

    public void HyperLogLog(int noOfRegisters, int bitsPerRegister) {
        this.noOfRegisters = noOfRegisters;
        this.bitsPerRegister = bitsPerRegister;
        this.hashFunction = new HashFunctions(1, noOfRegisters);
        this.geometricHashFunction = new HashFunctions(1, Integer.MAX_VALUE);

        registers = (BitSet[]) Stream.generate(() -> new BitSet(bitsPerRegister)).limit(noOfRegisters).toArray();
    }

    public void RecordPackets(int[] packets) {
        for (int packet : packets) {
            RecordPacket(packet);
        }
    }

    public void RecordPacket(int packet) {
        Integer.numberOfTrailingZeros(geometricHashFunction.Hash(packet));
    }

    public double Query() {
        
    }

    public void Clear() {
        for (BitSet bitSet : registers) {
            bitSet.clear();
        }
    }
}
