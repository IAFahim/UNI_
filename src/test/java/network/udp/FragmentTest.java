package network.udp;

import junit.framework.TestCase;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class FragmentTest {
    Fragment fragment=new Fragment();
    @Test
    public void fragmentBasic(){
        ByteBuffer buffer=ByteBuffer.allocateDirect(512).order(ByteOrder.BIG_ENDIAN);
        Fragment.format(buffer,"UUOxxxxxxxdddddddddddddddddddsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddaaaaaaaaaaaaaddddddddddddddddddddddddddddddddddddddddddddddddddddddsadasdasdasdasdasdsad21as21d55515asd5as5d51asd12as1ddddxxxd","Fahim","password","fahimmanowarj5@gmail.com");
        for (int i = 0; i < buffer.position(); i++) {
            int s=buffer.get(i++) & 0xff;
            if(s==0)break;
            for (int j = 0; j < s && i< buffer.position(); j++) {
                System.out.print(Character.valueOf((char) buffer.get(i++)));
            }
            i--;
        }


    }
}