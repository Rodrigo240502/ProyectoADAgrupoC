package P1_Ordenamiento;

class InsertionSort {

    public void insertionSort(int a[]) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int index = a[i];
			int j = i - 1;

			while (j >= 0 && a[j] > index) {
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = index;
		}
	}

	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i){
			System.out.print(arr[i] + ", ");
        }
		System.out.println();
	}
}