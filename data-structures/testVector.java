public class testVector
{
    public static void main(String[] args)
    {
        Vector vDefault = new Vector();
        System.out.println(vDefault.size());
        assert vDefault.size() == 64:"Incorrect Default Size (64)";

        for (int i = 0; i < 64; i++) {
            vDefault.put(i, "cat " + (64-i));
        }
        /*
        for (int i = 0; i < vDefault.size(); i++) {
            System.out.println(vDefault.at(i));
        }

        vDefault.clear();

        for (int i = 0; i < vDefault.size(); i++) {
            System.out.println(vDefault.at(i) == null);
        }
        */

        for (Object str : vDefault) {
            System.out.println((String) str);
        }

    }
}
