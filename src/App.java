import java.util.Random;
import java.util.stream.IntStream;

public class App {
        public static void main(String[] args) throws Exception {
                int[] flow100 = IntStream.generate(() -> new Random().nextInt()).limit(100)
                                .map(flowId -> Math.abs(flowId))
                                .toArray();
                int[] flow1000 = IntStream.generate(() -> new Random().nextInt()).limit(1000)
                                .map(flowId -> Math.abs(flowId))
                                .toArray();
                int[] flow10000 = IntStream.generate(() -> new Random().nextInt()).limit(10000)
                                .map(flowId -> Math.abs(flowId))
                                .toArray();
                int[] flow100000 = IntStream.generate(() -> new Random().nextInt()).limit(100000)
                                .map(flowId -> Math.abs(flowId)).toArray();
                int[] flow1000000 = IntStream.generate(() -> new Random().nextInt()).limit(1000000)
                                .map(flowId -> Math.abs(flowId)).toArray();

                int m = 10000;

                System.out.println("\nBitmap");

                BitMap bitMap = new BitMap(m);
                String outputBitmap = "";
                bitMap.RecordPackets(flow100);
                outputBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow100.length,
                                bitMap.Query());
                bitMap.Clear();

                bitMap.RecordPackets(flow1000);
                outputBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow1000.length,
                                bitMap.Query());
                bitMap.Clear();

                bitMap.RecordPackets(flow10000);
                outputBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow10000.length,
                                bitMap.Query());
                bitMap.Clear();

                bitMap.RecordPackets(flow100000);
                outputBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow100000.length,
                                bitMap.Query());
                bitMap.Clear();

                bitMap.RecordPackets(flow1000000);
                outputBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow1000000.length,
                                bitMap.Query());
                bitMap.Clear();

                System.out.println(outputBitmap);
                bitMap.Output(outputBitmap);

                System.out.println("\nProbability Bitmap");

                double p = 0.1;
                ProbBitMap probBitMap = new ProbBitMap(m, p);
                String outputProbBitmap = "";

                probBitMap.RecordPackets(flow100);
                outputProbBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow100.length,
                                probBitMap.Query());
                probBitMap.Clear();

                probBitMap.RecordPackets(flow1000);
                outputProbBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow1000.length,
                                probBitMap.Query());
                probBitMap.Clear();

                probBitMap.RecordPackets(flow10000);
                outputProbBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow10000.length,
                                probBitMap.Query());
                probBitMap.Clear();

                probBitMap.RecordPackets(flow100000);
                outputProbBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow100000.length,
                                probBitMap.Query());
                probBitMap.Clear();

                probBitMap.RecordPackets(flow1000000);
                outputProbBitmap += String.format("True Spread: %d, Estimated Spread: %f \n", flow1000000.length,
                                probBitMap.Query());
                probBitMap.Clear();

                System.out.println(outputProbBitmap);
                probBitMap.Output(outputProbBitmap);

                System.out.println("\nHyper Log Log");

                int bits = 5;
                m = 256;

                HyperLogLog hll = new HyperLogLog(m, bits);
                String outputHll = "";

                hll.RecordPackets(flow1000);
                outputHll += String.format("True Spread: %d, Estimated Spread: %f \n", flow1000.length, hll.Query());
                hll.Clear();

                hll.RecordPackets(flow10000);
                outputHll += String.format("True Spread: %d, Estimated Spread: %f \n", flow10000.length, hll.Query());
                hll.Clear();

                hll.RecordPackets(flow100000);
                outputHll += String.format("True Spread: %d, Estimated Spread: %f \n", flow100000.length, hll.Query());
                hll.Clear();

                hll.RecordPackets(flow1000000);
                outputHll += String.format("True Spread: %d, Estimated Spread: %f \n", flow1000000.length, hll.Query());
                hll.Clear();

                System.out.println(outputHll);
                hll.Output(outputHll);

        }
}
