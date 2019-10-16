import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BubbleSort1 {

	public static void main(String[] args) {
		int[] array = new int[] { 5, 8, 6, 3, 9, 2, 1, 7 };
		int[] array1 = new int[] { 5, 8, 6, 3, 9, 2, 1, 7 };
		int[] array2 = new int[] { 5, 8, 6, 3, 9, 2, 1, 7 };
		int[] array3 = new int[] { 5, 8, 6, 3, 9, 2, 1, 7 };
		int[] array4 = new int[] { 5, 8, 6, 3, 9, 2, 1, 7 };
		sort(array);
		System.out.println(Arrays.toString(array));
		sort1(array1);
		System.out.println(Arrays.toString(array1));
		sort2(array2);
		System.out.println(Arrays.toString(array2));
		String s = "av";
		int i = lengthOfLongestSubstring(s);
		System.out.println(i);
	}

	// 1.基本思路的冒泡排序
	private static void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				int temp = 0;
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}

			}
		}

	}

	// 2.有序标记的冒泡排序
	private static void sort1(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean isSorted = true;
			for (int j = 0; j < array.length - i - 1; j++) {
				int temp = 0;
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					isSorted = false;
				}

			}
			if (isSorted) {
				break;
			}
		}
	}

	// 3.有序标记的冒泡排序（不可行 ）
	private static void sort2(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean isSorted = true;
			int sortBorder = array.length-1;
			for (int j = 0; j < sortBorder; j++) {
				int temp = 0;
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					isSorted = false;
					sortBorder = j;
				}

			}
			if (isSorted) {
				break;
			}
		}
	}
	 public static int lengthOfLongestSubstring(String s) {
		  int maxLen = 0;
	        if(" ".equals(s)){
	            maxLen = 1;
	        }else{
	            char[] chr = s.toCharArray();
	            Set st = new HashSet<>();
		        for(int j =0;j<chr.length;j++) {
		        	for(int i=j;i<chr.length;i++){
		        		if(!st.add(chr[i])){
		        			int len = st.size();
		        			if(len > maxLen){
		        				maxLen = len;
		        				st = new HashSet<>();
		        				break;
		        			}
		        		}
		        	}
		        }
		        int len = st.size();
		        if(len > maxLen){
		        	maxLen = len;
		        }
	        }
		        return maxLen;
	    }
}
