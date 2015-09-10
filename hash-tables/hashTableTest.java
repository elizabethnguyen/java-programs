import java.util.*;

public class hashTableTest
{
    public static void main(String[] args)
    {
        MyHashTable ht = new MyHashTable();

        for (int i = 0; i < 87; i++) {
            ht.put("" + i, 87-i);
        }
        System.out.println(ht);
        for (int i = 0; i < 87; i++) {
            ht.remove("" + i);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(ht);
    }
}
