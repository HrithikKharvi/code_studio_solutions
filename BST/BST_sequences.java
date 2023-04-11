import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode {
       public:
        T data;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T data) {
            this->data = data;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> BSTSequence(TreeNode<Integer> node)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(node == null){
            result.add(new ArrayList());
            return result;
        }

        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(node.data);
        ArrayList<ArrayList<Integer>> leftBST = BSTSequence(node.left);
        ArrayList<ArrayList<Integer>> rightBST = BSTSequence(node.right);

        for(ArrayList<Integer> left : leftBST){
            for(ArrayList<Integer> right : rightBST){
                ArrayList<ArrayList<Integer>> weaved = new ArrayList<>();
                weave(left, right, prefix, weaved);
                result.addAll(weaved);
            }
        }

        return result;
    }

    public static void weave(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> prefix,
                            ArrayList<ArrayList<Integer>> result){
        if(left.isEmpty() || right.isEmpty()){
            ArrayList<Integer> res =  (ArrayList<Integer>) prefix.clone();
            res.addAll(left);
            res.addAll(right);
            result.add(res);
            return;
        }

        int ele = left.remove(0);
        prefix.add(ele);
        weave(left, right, prefix, result);
        prefix.remove(prefix.size()-1);
        left.add(0,ele);


        int ele2 = right.remove(0);
        prefix.add(ele2);
        weave(left, right, prefix, result);
        prefix.remove(prefix.size()-1);
        right.add(0,ele2);
    }

}
