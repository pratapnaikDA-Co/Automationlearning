package JavaBrushUps1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearningArrayList {
    public static void main(String[] args) {
        //generic way of creating class

        int[] array1 = new int[5];
        array1[0] = 2;
        array1[1] = 3;
        array1[2] = 24;
        array1[3] = 25;
        array1[4] = 26;

//        for (int i : array1) {
//            System.out.println(array1[i]);
//        }
//
//        //this array is fixed length and takes so much lines to reduce
//
//        int[] array2 = {32, 32, 43, 32, 324, 5, 2};
//        for (int j : array2) {
//            System.out.println(array2[j]);
//        }

        // now we cant go the data dynamically we come to array list

//        ArrayList<int> array3 = new ArrayList<int>();
//        array3.add(13);
//        array3.add(31);
//        array3.add(3131);
//
//        array3.remove(2); // we give the index here to remove the exact value
//        array3.get(1); // extract value from the array list

//        for (int i = 0; i < array3.size(); i++) {
//            int newval = array3.get(i);
//            if (array3.contains(31)) {
//                System.out.println("true");
//            }
//            System.out.println(newval);
//        }

        //converting array to array list
//        List<int[]> array2list = Arrays.asList(array2);


        System.out.println(array1.length);
    }
}
