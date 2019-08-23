package dynamic;

import java.util.Arrays;

/**
 * @description:
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。　　　
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　
 * 判断你是否能到达数组的最后一个位置。
 *
 *
 * @auther: hefeng
 * @creatTime: 2019-7-25 21:34:13
 */
public class JumpGame2 {


    public static int jumpNum(int[] A) {
        if( A==null || A.length<1){
            return -1;
        }
        int n = A.length;
        int[] jump = new int[n];//跳的步数
        int[] cur=new int[n];//cur[j]表示跳jump步能到的最远位置
        int[] next=new int[n];//next[j]表示再跳一步能到的最远位置，即跳j+1步能到的最远位置
        jump[0] = 0;
        cur[0] = 0;
        next[0] = 3;

        //遍历数组的位置
        for (int i = 1; i < n; i++) {
            if (cur[i - 1] < i) {//跳jump[i-1]步到不了位置i
                jump[i] = jump[i - 1] + 1;
                cur[i] = next[i - 1];
            } else {//跳jump[i-1]步能到i
                jump[i] = jump[i - 1];
                cur[i] = cur[i - 1];
            }
            next[i] = Math.max(next[i-1], i + A[i]);
        }

        System.out.println("jump===" + Arrays.toString(jump));
        System.out.println("cur ===" + Arrays.toString(cur));
        System.out.println("next===" + Arrays.toString(next));
        return jump[n-1];
    }

    public static int jumpNum2(int[] A) {
        if( A==null || A.length<1){
            return -1;
        }
        int jump=0;
        int cur=0;
        int next=0;
        for(int i=0;i< A.length;i++){
            if(cur<i){
                jump++;
                cur=next;
            }
            next=Math.max(next, i+ A[i]);
        }
        return jump;
    }
    public static void main(String[] args) {
        int[] arr ={3,2,3,1,1,4,2};
        int b = JumpGame2.jumpNum(arr);
        System.out.println(b);
    }
}
