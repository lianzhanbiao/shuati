package basic;

import java.util.BitSet;

public class Pbitset {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(10);
        bitSet.set(2);
        System.out.println(bitSet);
        System.out.println(bitSet.get(2));
        System.out.println(bitSet.get(1));
    }
}
