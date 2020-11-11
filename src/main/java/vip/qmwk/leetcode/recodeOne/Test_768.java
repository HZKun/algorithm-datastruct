package vip.qmwk.leetcode.recodeOne;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/11/13:59
 * @Description:
 */
public class Test_768 {

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,4};
        System.out.println(maxChunksToSorted(arr));
    }


    public static int maxChunksToSorted(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        int result = 0;
        // 成为块的必要条件：区间外的最小元素都比区间内的最大元素大
        int blockBeginIndex = 0;
        int blockEndIndex = 0;
        int blockMax = 0;
        while(blockBeginIndex < arr.length){
            boolean needAdd = true;
            // 获取当前block中最大值
            for (int i = blockBeginIndex; i <= blockEndIndex; i++) {
                int tmpMax = arr[i];
                if(blockMax < tmpMax){
                    blockMax = tmpMax;
                }
            }
            // 判断当前块的最大值一直小于块区间外的元素
            for (int j = blockEndIndex + 1; j < arr.length; j++) {
                int tmp = arr[j];
                if(blockMax > tmp){
                    // 扩充块范围,重来
                    blockEndIndex = j;
                    needAdd = false;
                    break;
                }
            }
            if(needAdd){
                result++;
                blockBeginIndex = blockEndIndex + 1;
                blockEndIndex = blockBeginIndex;
            }
        }
        return result;
    }

}
