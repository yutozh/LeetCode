package 数组;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ArrayIntersection {
    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{2, 2}, solution(new int[]{2, 2}, new int[]{1,2,2,1}));
        Assert.assertArrayEquals(new int[]{4,9}, solution(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
    }
    public int[] solution(int[] nums1, int[] nums2){
        return solution3(nums1, nums2);
    }
    public int[] solution1(int[] nums1, int[] nums2){
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<nums1.length; i++){
            for (int j=0;j<nums2.length; j++){
                if(nums2[j] == nums1[i]){
                    res.add(nums1[i]);
                    nums2[j] = -9999;
                    break;
                }
            }
        }
        Integer[] array = res.toArray(new Integer[res.size()]);//能正确运行
        System.out.println(res.toString());
        return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
    }
    public int[] solution2(int[] nums1, int[] nums2){
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        // 根据数组1构造map，键为数组的元素值（若有重复值则将键设置为k_n），值为0
        for (int i=0; i<nums1.length; i++){
            if(m.containsKey(String.valueOf(nums1[i]))){
                int cnt = 1;
                while (m.containsKey(String.valueOf(nums1[i]) + '_' + String.valueOf(cnt))){
                    cnt++;
                }
                m.put(String.valueOf(nums1[i]) + '_' + String.valueOf(cnt), 0);
            }
            m.put(String.valueOf(nums1[i]), 0);
        }
        //
        for (int j=0;j<nums2.length; j++){
            if(m.containsKey(String.valueOf(nums2[j]))){
                if(m.get(String.valueOf(nums2[j])) == 0){
                    m.put(String.valueOf(nums2[j]), 1);
                }else {
                    int cnt = 1;
                    while (true){
                        if(m.containsKey(String.valueOf(nums2[j]) + '_' + String.valueOf(cnt))){
                            if(m.get(String.valueOf(nums2[j]) + '_' + String.valueOf(cnt)) == 0){
                                m.put(String.valueOf(nums2[j]) + '_' + String.valueOf(cnt), 1);
                                break;
                            }else {
                                cnt++;
                                continue;
                            }
                        }else {
                            break;
                        }
                    }
                }
            }
        }

        for (String key : m.keySet()) {
            if (m.get(key) > 0){
                res.add(Integer.parseInt(key.split("_")[0]));
            }
        }

        Integer[] array = res.toArray(new Integer[res.size()]);
        System.out.println(res.toString());
        return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
    }
    public int[] solution3(int[] nums1, int[] nums2){
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        ArrayList<Integer> res = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j]){
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else {
                res.add(nums1[i]);
                i++;j++;
            }
        }

        int[] arr = new int[res.size()];
        for (int k=0; k<arr.length; k++){
            arr[k] = res.get(k);
        }
        return arr;
    }
}
