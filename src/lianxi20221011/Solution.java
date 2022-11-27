package lianxi20221011;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    int res = 0;
    public int triangleNumber(int[] nums) {
        boolean[] isvisted = new boolean[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        backtrace(isvisted, nums, list, res);
        return res;
    }

    private void backtrace(boolean[] isvisted, int[] nums, ArrayList<Integer> list, int res) {
        if (list.size() == 3) {
            if (isvalid(list)) {
                res++;
                System.out.println(res);
            }
        }
        for (int i = 0; i < isvisted.length; i++) {
            if (isvisted[i] == false) {
                isvisted[i] = true;
                list.add(nums[i]);
                backtrace(isvisted,nums,list,res);
                list.remove(list.size()-1);
                isvisted[i]=false;
            }
        }
    }

    private boolean isvalid(ArrayList<Integer> list) {
        System.out.println(list);
        if(list.get(0)+list.get(1)>list.get(2)&&
                list.get(0)+list.get(2)>list.get(1)&&
                list.get(1)+list.get(2)>list.get(0)&&
                list.get(0)-list.get(1)<list.get(2)&&
                list.get(0)-list.get(2)<list.get(1)&&
                list.get(1)-list.get(2)<list.get(0)){
            System.out.println("kk");
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().triangleNumber(new int[]{2,2,3,4}));
    }
}