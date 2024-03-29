import java.io.BufferedWriter;
import java.io.FileWriter;

public class ProbBitMap extends BitMap {
    double prob;
    HashFunctions hashFunctionProb;

    public ProbBitMap(int size, double prob) {
        super(size);
        this.prob = prob;
        this.hashFunctionProb = new HashFunctions(1, size);
    }

    @Override
    public void RecordPacket(int packet) {
        if (hashFunctionProb.Hash(packet) < size * prob) {
            bitMap.set(hashFunction.Hash(packet));
        }
    }

    @Override
    public double Query() {
        return (-1) * size / prob * Math.log(1.0 - ((double) bitMap.cardinality() / (double) size));
    }

    public void Output(String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("ProbBitMap.txt"));
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
