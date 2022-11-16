import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        int[] flow100 = IntStream.generate(() -> new Random().nextInt()).limit(100).map(flowId -> Math.abs(flowId))
                .toArray();
        int[] flow1000 = IntStream.generate(() -> new Random().nextInt()).limit(1000).map(flowId -> Math.abs(flowId))
                .toArray();
        int[] flow10000 = IntStream.generate(() -> new Random().nextInt()).limit(10000).map(flowId -> Math.abs(flowId))
                .toArray();
        int[] flow100000 = IntStream.generate(() -> new Random().nextInt()).limit(100000)
                .map(flowId -> Math.abs(flowId)).toArray();
        int[] flow1000000 = IntStream.generate(() -> new Random().nextInt()).limit(1000000)
                .map(flowId -> Math.abs(flowId)).toArray();

        int m = 10000;

        System.out.println("\nBitmap");

        BitMap bitMap = new BitMap(m);

        bitMap.RecordPackets(flow100);
        System.out.println(bitMap.Query());
        bitMap.Clear();

        bitMap.RecordPackets(flow1000);
        System.out.println(bitMap.Query());
        bitMap.Clear();

        bitMap.RecordPackets(flow10000);
        System.out.println(bitMap.Query());
        bitMap.Clear();

        bitMap.RecordPackets(flow100000);
        System.out.println(bitMap.Query());
        bitMap.Clear();

        bitMap.RecordPackets(flow1000000);
        System.out.println(bitMap.Query());
        bitMap.Clear();

        System.out.println("\nProbability Bitmap");

        double p = 0.1;
        ProbBitMap probBitMap = new ProbBitMap(m, p);

        probBitMap.RecordPackets(flow100);
        System.out.println(probBitMap.Query());
        probBitMap.Clear();

        probBitMap.RecordPackets(flow1000);
        System.out.println(probBitMap.Query());
        probBitMap.Clear();

        probBitMap.RecordPackets(flow10000);
        System.out.println(probBitMap.Query());
        probBitMap.Clear();

        probBitMap.RecordPackets(flow100000);
        System.out.println(probBitMap.Query());
        probBitMap.Clear();

        probBitMap.RecordPackets(flow1000000);
        System.out.println(probBitMap.Query());
        probBitMap.Clear();

        System.out.println("\nHyper Log Log");

        int bits = 5;
        m = 256;

        HyperLogLog hll = new HyperLogLog(m,bits);

        hll.RecordPackets(flow1000);
        System.out.println(hll.Query());
        hll.Clear();

        hll.RecordPackets(flow10000);
        System.out.println(hll.Query());
        hll.Clear();

        hll.RecordPackets(flow100000);
        System.out.println(hll.Query());
        hll.Clear();

        hll.RecordPackets(flow1000000);
        System.out.println(hll.Query());
        hll.Clear();

    }
}
