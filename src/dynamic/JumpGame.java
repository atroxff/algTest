package dynamic;

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
public class JumpGame {

        public static boolean canJump(int[] A) {
            int n = A.length;   //数组a的长度为要跳越的目标距离
            boolean[] f = new boolean[n];  //f[] 记录每一个位置最终能否完成跳跃
            f[0] = true; // 成功标记，第一格默认成功

            //i,j记录位置，外循环1~n，记录跳到A[j]能否成功
            for (int j = 1; j < n; ++j) {
                f[j] = false;
                // 内循环，记录最近一次跳跃从i到j
                for (int i = 0; i < j; ++i) { //从位置0开始跳
                    if (f[i] && i + A[i] >= j) {// 能跳到i及i到j的距离小于最大步长
                        //只要有一个i能跳到j就置为ture并且break（无需判断后续i~j的位置能否跳到j）
                        f[j] = true;
                        break;
                    }
                }
            }
            return f[n - 1];
        }

    public static void main(String[] args) {
        int[] arr ={3,2,1,0,4};
        boolean b = JumpGame.canJump(arr);
        System.out.println(b);
    }
}
