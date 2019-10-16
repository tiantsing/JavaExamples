import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayDel {

	public static void main(String[] args) {
		/*
		 * int array[] = {1,2,3,3,4,5,5,6,7,8}; IntStream instream =
		 * Arrays.stream(array).filter(x->x%2!=0); int[] array2 = instream.toArray();
		 * for(int i :array2) {
		 * 
		 * System.out.println(i); }
		 */
		
		List list = Arrays.asList("one two three four five six siven".split(" "));
		System.out.println(list);
		List subList = Arrays.asList("three four five six".split(" "));
		System.out.println(Collections.indexOfSubList(list, subList));
		System.out.println(Collections.lastIndexOfSubList(list, subList));
	}

}
