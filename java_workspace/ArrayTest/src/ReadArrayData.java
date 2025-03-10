import java.util.Arrays;

public class ReadArrayData {

	public static void main(String[] args) {
		int[] array=new int[] {3,4,5,6,7};
		System.out.println(array.length);
		
		System.out.print(array[0] + " ");
		System.out.print(array[1] + " ");
		System.out.print(array[2] + " ");
		System.out.print(array[3] + " ");
		System.out.print(array[4] + " ");
		System.out.println();
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
		for(int k: array) {
			System.out.print(k + " ");
		}
		System.out.println();
		
		System.out.println(Arrays.toString(array));
	}

}
