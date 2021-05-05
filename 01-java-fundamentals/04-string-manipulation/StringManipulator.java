public class StringManipulator {
    public String trimAndConcat(String stringA, String stringB) {
        return stringA.trim() + stringB.trim();
    }

    public Integer getIndexOrNull(String stringA, char charA) {
        return stringA.indexOf(charA);
    }

    public String concatSubstring(String stringA, int start, int end, String stringB) {
        return stringA.substring(start, end) + stringB;
    }
}