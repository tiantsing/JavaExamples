import java.util.Arrays;

public class QuickSortOne {

	public static void main(String[] args) {
		int arr[] = new int[] {4,4,6,5,3,2,8,1};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		if(startIndex>=endIndex) {
			return;
		}
		//得到基准元素的下标位置
		int pivotIndex = partition(arr,startIndex,endIndex);
		//分两部分进行递归
		quickSort(arr,startIndex,pivotIndex-1);
		quickSort(arr,pivotIndex+1,endIndex);
		
	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[startIndex];
		int mark = startIndex;
		for(int i= startIndex+1;i<=endIndex;i++) {
			if(arr[i]<pivot) {
				mark++;
				int p = arr[mark];
				arr[mark] = arr[i];
				arr[i] = p;
			}
		}
		arr[startIndex] = arr[mark];
		arr[mark] = pivot;
		return mark;
	}

}
