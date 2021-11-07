package P1_Ordenamiento;

public class HeapSort {

	public void heapSort(int a[]) {
		int n = a.length;
		for (int i = (n/2)-1; i >= 0; i--){
            heapify(a, n, i);
        }
		for (int i = n-1; i > 0; i--) {
			int aux = a[0];
			a[0] = a[i];
			a[i] = aux;
			heapify(a, i, 0);
		}
	}

	void heapify(int a[], int n, int i) {
		int largest = i; 
		int izq = 2 * i + 1; 
		int der = 2 * i + 2; 

		if (izq < n && a[izq] > a[largest])
			largest = izq;

		if (der < n && a[der] > a[largest])
			largest = der;

		if (largest != i) {
			int aux = a[i];
			a[i] = a[largest];
			a[largest] = aux;

			heapify(a, n, largest);
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

