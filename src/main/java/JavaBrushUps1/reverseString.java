package JavaBrushUps1;

public class reverseString {
    public static void main(String[] args) {
        String goal = "Here on we start to learn 3hrs a day";
        // step 1 use for loop

        String reversedString = "";
        for (int i = goal.length() - 1; i >= 0; i--) {

            reversedString = reversedString + goal.charAt(i);
        }
        System.out.println(reversedString);
    }
}