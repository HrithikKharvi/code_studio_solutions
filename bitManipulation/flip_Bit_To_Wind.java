import java.util.* ;
import java.io.*; 
public class Solution {
    public static int flipBit(int a) {
        int numberCount = findNumberCount(a);
        int[] zeroList = formZeroList(a);

        if(zeroList.length <= 1)return numberCount;
        int start = 0;
        int end = 0;

        int max = 0;

        for(int i=0; i < zeroList.length; i++){
            if(i == 0)start = 1;
            else start = zeroList[i-1] +1;
            if(i == zeroList.length-1)end = numberCount+1;
            else end = zeroList[i+1];

            max = Math.max(max, end-start);
        }

        return max;
    }

    public static int findNumberCount(int number){
        int count = 0;

        while(number != 0){
            count++;
            number = number >> 1;
        }

        return count;
    }

    public static int[] formZeroList(int number){
        int zeros = countZeros(number);
        int[] zeroList = new int[zeros];
        int index = 0;
        int counter = 1;

        while(number > 0){
            if((number | 1) != number)zeroList[index++] = counter;
            number = number >> 1;
            counter++;
        }

        return zeroList;

    }

    public static int countZeros(int number){
        
        int count = 0;
        while(number > 0){
            int shiftResult = number | 1;
            if(shiftResult != number)count++;

            number = number >> 1;
        }

        return count;
    }

}
