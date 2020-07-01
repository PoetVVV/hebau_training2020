package myTest;

//可变长参数示例
public class ArgsDemo {
    public static void main(String[] args) {
        int[] arr = new int[0];
        m(arr);

        n("lzw", arr);
    }

    public static void m(int[] m){
        System.out.println(m.length);
    }

    public static void n(String s, int... m){
        System.out.println(m.length);
    }


}
