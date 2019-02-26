package tree;

import java.util.Arrays;

public class Main {

    BSTree bst = new BSTree();

    public void test() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        recursive(arr);

        bst.print();
    }


    public void recursive(int[] arr) {
        int pickIndex = 0;

        if (arr.length == 1) {
            pickIndex = 0;
        } else {
            pickIndex = (arr.length - 1) / 2;
        }

        System.out.println(arr[pickIndex]);

        bst.insert(arr[pickIndex]);

        if (pickIndex != 0) {
            int arrLeft[] = Arrays.copyOfRange(arr, 0, pickIndex);
            recursive(arrLeft);
        }

        if (pickIndex != arr.length - 1) {
            int arrRight[] = Arrays.copyOfRange(arr, pickIndex + 1, arr.length);
            recursive(arrRight);
        }

    }

    public static void main(String[] args) {

        Main mt = new Main();
        mt.test();

    }

}
