package network.udp;

public class TextUnder128KB {
    final private int CAP = 1 << 8, SEG = 512;
    private short limit;
    private short has;
    private final boolean[] map;

    public TextUnder128KB() {
        limit = 0;
        has = 0;
        map = new boolean[CAP];
    }

    public void reset(short limit) {
        for (int i = 0; i < limit; i++) {
            map[i] = false;
        }
        has = 0;
        this.limit = limit;
    }

    public boolean shouldWrite(short at) {
        if (!map[at]) {
            map[at] = true;
            has++;
            return true;
        }
        return false;
    }

    public byte[] check() {
        short missed = (short) (limit - has);
        byte[] misIndex = new byte[missed];
        for (int i = 0, j = 0; i < limit; i++) {
            if (!map[i]) {
                misIndex[j++] = (byte) i;
            }
        }
        return misIndex;
    }

    public void textSize(int size) {
        if (limit == 0) {
            limit = (short) Math.ceil((size * 1.0) / SEG);
        } else {
            reset((short) size);
        }
    }

}
