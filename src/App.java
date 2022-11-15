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
        
        BitMap bitMap = new BitMap(m);
        bitMap.RecordFlows(flow100);
        System.out.println(bitMap.Query());
        bitMap.Clear();
        
        bitMap.RecordFlows(flow1000);
        System.out.println(bitMap.Query());
        bitMap.Clear();

        bitMap.RecordFlows(flow10000);
        System.out.println(bitMap.Query());
        bitMap.Clear();

        bitMap.RecordFlows(flow100000);
        System.out.println(bitMap.Query());
        bitMap.Clear();

        bitMap.RecordFlows(flow1000000);
        System.out.println(bitMap.Query());
        bitMap.Clear();
    }
}
