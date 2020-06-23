package 课上;
/**
 * @ClassName: ArgsDemo 
 * @Description: 可变长参数示例
 * @author: Mr.T
 * @date: 2020年6月23日 上午11:14:30
 */
public class ArgsDemo {
	
	public static void main(String[] args) {
		int[] arr = new int[0];
		m(arr);
		
		n("123",1);
	}

	
	
	public static void  m(int[] m) {
		System.out.println(m.length);
	}
	
	public static void  n(String s,int... m) {
		System.out.println(m.length);
	}
}
