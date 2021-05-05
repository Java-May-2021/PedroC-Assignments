import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    public static void main(String[] args) {
        // 1
        int[] arr1 = {3,5,1,2,7,9,8,13,25,32};
        System.out.println("1. Greater Than 10:");
        System.out.println(GreaterThanY(arr1, 10));
        System.out.println();
        // 2
        ArrayList<String> arr2 = new ArrayList<String>();
        arr2.add("Nancy");
        arr2.add("Jinichi");
        arr2.add("Fujibayashi");
        arr2.add("Momochi");
        arr2.add("Ishikawa");
        System.out.println("2. Shuffled And Longer Than 5 chars:");
        System.out.println(ShuffleAndLongerThan5(arr2));
        System.out.println();
        // 3
        System.out.println("3. Shuffled Alphabet:");
        Alphabet();
        System.out.println();
        // 4
        System.out.println("4. Ten Random Numbers:");
        System.out.println(TenRandomNumbers());
        System.out.println();
        // 5
        System.out.println("5. Ten Random Numbers Sorted:");
        TenRandomNumbersSorted();
        System.out.println();
        // 6
        System.out.println("6. Random String:");
        System.out.println(RandomString());
        System.out.println();
        // 7
        System.out.println("7. Ten Random Words:");
        System.out.println(TenRandomWords());
    }

    public static ArrayList<Integer> GreaterThanY(int[] arr, int y) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++) {
            if (arr[i] > y) {
                results.add(arr[i]);
            }
        }
        return results;
    }

    public static ArrayList<String> ShuffleAndLongerThan5(ArrayList<String> arr) {
        ArrayList<String> results = new ArrayList<String>();
        Collections.shuffle(arr);
        for(int i=0; i<arr.size(); i++) {
            if (arr.get(i).length() > 5) {
                results.add(arr.get(i));
            }
        }
        return results;
    }

    public static void Alphabet() {
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=65; i<(65+26); i++) {
            alphabet.add((char)i);
        }
        Collections.shuffle(alphabet);

        System.out.println("Last character:");
        System.out.println(alphabet.get(alphabet.size()-1));
        char firstChar = alphabet.get(0);
        String vowels = "AEIOU";
        System.out.println("First character:");
        System.out.println(firstChar);
        if (vowels.indexOf(firstChar) >= 0) {
            System.out.println("It's a vowel!");
        }
    }

    public static ArrayList<Integer> TenRandomNumbers() {
        ArrayList<Integer> results = new ArrayList<Integer>();
        Random r = new Random();
        for(int i=0; i<10; i++) {
            results.add(r.nextInt(100 - 55) + 55);
        }
        return results;
    }

    public static void TenRandomNumbersSorted() {
        ArrayList<Integer> results = TenRandomNumbers();
        Collections.sort(results);
        System.out.println(results);
        System.out.println(results.get(0));
        System.out.println(results.get(9));
    }

    public static String RandomString() {
        String word = "";
        Random r = new Random();
        for(int i=0; i<5; i++) {
            word = word + (char)(r.nextInt((65+26) - 65) + 65);
        }
        return word;
    }

    public static ArrayList<String> TenRandomWords() {
        ArrayList<String> results = new ArrayList<String>();
        for(int i=0; i<10; i++) {
            results.add(RandomString());
        }
        return results;
    }

}                
