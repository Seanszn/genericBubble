
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    public class Box<T>{
        final T x;
        Box(T x){
            this.x = x;
        }
    }
    static <T extends Comparable> void genBubble(T[] array){
        for (int i = 0; i < array.length - 1; i++)
        for (int j = 0; j < array.length - i - 1; j++)
            if (array[j].compareTo(array[j+1]) > 0) {
                T temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
    }
    public static <T extends Comparable> void mergeSort(T[] array) {
        int num = array.length;
        if (num < 2) {
            return;
        }
        int mid = num / 2;
        T[] leftHalf = (T[]) new Comparable[mid];
        T[] rightHalf = (T[]) new Comparable[num - mid];
    
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = array[i];
        }
        for (int i = mid; i < num; i++) {
            rightHalf[i - mid] = array[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
    
        mergeArray(array, leftHalf, rightHalf, mid, num - mid);
    }
    public static <T extends Comparable> void mergeArray(T[] a, T[] l, T[] r, int left, int right) {
       
          int i = 0, j = 0, k = 0;
          while (i < left && j < right) {
              if (l[i].compareTo(r[j]) > 0) {
                  a[k++] = l[i++];
              }
              else {
                  a[k++] = r[j++];
              }
          }
          while (i < left) {
              a[k++] = l[i++];
          }
          while (j < right) {
              a[k++] = r[j++];
          }
      }
}

