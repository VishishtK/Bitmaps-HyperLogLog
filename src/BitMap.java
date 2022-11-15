import java.util.BitSet;

public class BitMap {
    BitSet bitMap;
    int size;
    HashFunctions hashFunctions;

    public BitMap(int size){
        bitMap = new BitSet(size);
        this.size = size;
        this.hashFunctions = new HashFunctions(1, size);
    }

    public void RecordFlows(int[] packets){
        for(int packet: packets){
            RecordFlow(packet);
        }
    }

    public void RecordFlow(int packet){
        bitMap.set(hashFunctions.Hash(packet));
    }

    public double Query(){
        return (-1)*size*Math.log(1.0-((double)bitMap.cardinality()/(double)size));
    }

    public void Clear(){
        bitMap.clear();
    }

}
