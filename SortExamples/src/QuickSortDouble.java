import java.util.Arrays;

public class QuickSortDouble {

	public static void main(String[] args) {
		int arr[] = new int[] {4,4,6,5,3,2,8,1};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		if(startIndex>=endIndex) {
			return;
		}
		//�õ���׼Ԫ�ص��±�λ��
		int pivotIndex = partition(arr,startIndex,endIndex);
		//�������ֽ��еݹ�
		quickSort(arr,startIndex,pivotIndex-1);
		quickSort(arr,pivotIndex+1,endIndex);
	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		while(left != right) {
			while(left<right&& arr[right]>pivot) {
				right--;
			}
			while(left<right&& arr[left]<=pivot) {
				left++;
			}
			if(left<right) {
				int p = arr[left];
				arr[left] = arr[right];
				arr[right] = p;
			}
		}
		arr[startIndex] = arr[left];
		arr[left] = pivot;
		return left;
	}

}
