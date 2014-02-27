
import java.util.Arrays;

public class IntVector {

    public int[] myarray = new int[2];

    public void add(int x) {
        int index = 0;
        for (int i = 0; i < myarray.length; i++) {
            if (myarray[i] != 0) {
                index++;

            }

        }
        myarray[index] = x;

    }

    public void checkingArrayIfItIsFull() {

        if (myarray[myarray.length - 1] != 0) {

            int[] myarray1 = Arrays.copyOfRange(myarray, 0, myarray.length *2);
            myarray = null;
            // myarray = new int[myarray.length+100];
            //myarray = new int[myarray1.length];
            myarray = Arrays.copyOfRange(myarray1, 0, myarray1.length);
            myarray1 = null;
        }

           //if(element == 0);
        //System.out.println(element);
       // System.out.println(myarray.length);

    }

    public int get(int index) {
        return myarray[index];
    }

    public void printg() {
        System.out.println(myarray);
    }

    public static void main(String[] args) {
        IntVector intVector = new IntVector();
        for (int i = 1; i < 3000; i++) {
            intVector.checkingArrayIfItIsFull();
            intVector.add(i);
        }
        for (int i = 0; i < 3000; i++) {
            System.out.println(intVector.get(i));
            //System.out.println(i);
        }
        //intVector.printg();
    }
}
