import java.util.ArrayList;

public class BasicJava {
    public static void main(String[] args) {
        Print1to255();
        PrintOddsFrom1to255();
        PrintSum();
        int[] arr1 = {1,3,5,7,9,13};
        IteratingThroughAnArray(arr1);
        int[] arr2 = {-3, -5, -7};
        FindMax(arr2);
        int[] arr3 = {2, 10, 3};
        GetAverage(arr3);
        ArrayWithOddNumbers();
        int[] arr4 = {1, 3, 5, 7};
        GreaterThanY(arr4, 3);
        int[] arr5 = {1, 5, 10, -2};
        SquareTheValues(arr5);
        int[] arr6 = {1, 5, 10, -2};
        EliminateNegativeNumbers(arr6);
        int[] arr7 = {1, 5, 10, -2};
        MaxMinAndAverage(arr7);
        int[] arr8 = {1, 5, 10, 7, -2};
        ShiftingTheValuesInTheArray(arr8);
    }

    public static void Print1to255() {
        for(int i=1; i<=255; i++) {
            System.out.println(i);
        }
    }

    public static void PrintOddsFrom1to255() {
        for(int i=1; i<=255; i++) {
            if (i%2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void PrintSum() {
        int sum = 0;
        for(int i=0; i<=255; i++) {
            sum = sum + i;
            System.out.println("New number: "+i+" Sum: "+sum);
        }
    }
    
    public static void IteratingThroughAnArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public static void FindMax(int[] arr) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public static void GetAverage(int[] arr) {
        int avg = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println(sum / arr.length);
    }
    
    public static void ArrayWithOddNumbers() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i=1; i<=255; i++) {
            if (i%2 != 0) {
                y.add(i);
            }
        }
        System.out.println(y);
    }

    public static void GreaterThanY(int[] arr, int y) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] > y) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void SquareTheValues(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
    }
    
    public static void EliminateNegativeNumbers(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
    }
    
    public static ArrayList<Double> MaxMinAndAverage(int[] arr) {
        ArrayList<Double> results = new ArrayList<Double>();
        double max = arr[0];
        double min = arr[0];
        double sum = 0.0;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            sum = sum + arr[i];
        }
        results.add(max);
        results.add(min);
        results.add(sum / arr.length);
        return results;
    }

    public static void ShiftingTheValuesInTheArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = 0;
            } else {
                arr[i] = arr[i+1];
            }
        }
    }

}
