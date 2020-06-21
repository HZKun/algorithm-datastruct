package vip.qmwk;

import org.junit.Test;
import vip.qmwk.datastruct.array.MyArray;

/**
 * Unit test for simple App.
 */
public class TestMyArray
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testMyArray() {
        MyArray<Integer> arr = new MyArray<>(10);
        for (int i = 0; i < 10; i++) {
            arr.add(i,i + 1);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);


    }
}
