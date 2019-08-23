package dynamic;

import java.util.Scanner;

/**
 * @description:
 * @auther: hefeng
 * @creatTime: 2019-7-26 13:55:42
 */
public class Route {
    public static void main(String[] args) {
        int n = 10;
        int[][] p = new int[n][2];
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            p[i][0] = s.nextInt();
            p[i][1] = s.nextInt();
        }
        //数据校验
        //isValid(p)

        System.out.println(p.length);
    }
}
