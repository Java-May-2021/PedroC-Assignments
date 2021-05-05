public class StringManipulatorTesting {
    public static void main(String[] args) {
        StringManipulator sm = new StringManipulator();
        System.out.println(sm.trimAndConcat(" Hello ", " World "));
        System.out.println(sm.getIndexOrNull("HelloWorld", 'o'));
        System.out.println(sm.concatSubstring("Hello", 1, 2, "world"));
    }
}
