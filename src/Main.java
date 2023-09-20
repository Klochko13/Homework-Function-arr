import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int n = kb.nextInt();
        int[] arr = new int[n];
        Rand_arr(arr);
        Print_arr(arr);
        System.out.printf("Сумма элементов массива составляет: %d\n" +
                "Среднее значение элементов массива составляет: %.2f\n" +
                "Минимальное значение элемента массива составляет: %d\n" +
                "Максимальное значение элемента массива составляет: %d\n", Sum(arr), Avg(arr), MinValueIn(arr), MaxValueIn(arr));
        System.out.println("Введите значение на которое Вы хотите сдвинуть элементы массива влево: ");
        int left = kb.nextInt();
        System.out.println("Введите значение на которое Вы хотите сдвинуть элементы массива вправо: ");
        int right = kb.nextInt();
        ShiftLeft(arr, left);
        System.out.println();
        Shiftright(arr, right);

    }

    static void ShiftLeft(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int tmp = arr[0];
            for (int j = 0; j < arr.length - 1; j++)
                arr[j] = arr[j + 1];
            arr[arr.length - 1] = tmp;
        }
        System.out.printf("После сдивага элементов массива влево на %d значений - ", n);
        Print_arr(arr);
    }

    static void Shiftright(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int tmp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--)
                arr[j] = arr[j - 1];
            arr[0] = tmp;
        }
        System.out.printf("После сдивага элементов массива вправо на %d значений - ", n);
        Print_arr(arr);
    }

    static void Rand_arr(int[] arr) {
        Random rand = new Random(0);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
    }

    static int Sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static double Avg(int[] arr) {
        double avg = Sum(arr) / (double) arr.length;
        return avg;
    }

    static int MinValueIn(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static int MaxValueIn(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void Print_arr(int[] arr) {
        System.out.print("Значения элементов массива: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}