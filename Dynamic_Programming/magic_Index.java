import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int magicIndex(ArrayList<Integer> a, int n) {
        for(int index=0; index < a.size(); index++){
            if(a.get(index) == index)return index;
        }

        return -1;
    }

    public static int findIndex(ArrayList<Integer> arr, int start, int end){
        while(start < end){
            int mid = (start + end) /2;
            if(arr.get(mid) >= 0 && arr.get(mid) < end && arr.get(arr.get(mid)) == arr.get(mid))return arr.get(mid);
            if(arr.get(mid) == mid)return mid;
            if(arr.get(mid) > mid) end = mid;
            if(arr.get(mid) < mid)start = mid+1;
        }

        return -1;
    }

}
