package algoritmos;

public  class MergeSort {
    public void sort(int arr[], int left, int right) {
        if (left < right) {
            //Encuentra el punto medio del vector
            int middle = (left + right) / 2;

            //Divide la primera y la segunda mitad de form recursiva
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            //une las dos mitades
            merge(arr, left, middle,  right);
        }
    }
    public void merge(int arr[], int left, int middle, int right) {
        //Encuentra el tamaño de los sub-vectores para unirlos
        int n1 = middle - left + 1;
        int n2 = right - middle;

        //Vectores temporales
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        //Copia los datos a los arrays temporales.
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }
        //une los vectores.
        /*
         * iniciales del primer vector
         * y del sub-vector
         */
        int i = 0, j = 0;

        //iniciales del sub-vector
        int k = left;

        //ordenamiento
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
            //Fin del bucle
        }
        /*
         * si quedan elementos por ordenar
         * copiar elementos restates
         */
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        //Copiar elementos en rightArray[]
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public  void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.println(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        int arr [] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = arr.length;

        System.out.println("Array original:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Array ordenado:");
        mergeSort.sort(arr,0, n - 1);
        mergeSort.printArray(arr);
    }
}
