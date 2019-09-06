package com.net;

public class LevensteinDistance {

    public static void main(String[] args){
        String inputStr1 = "ivan1";
        String inputStr2 = "ivan2";
        int[][] distance = new int[6][6];
        for(int i = 0;i < 6;i++){
            distance[0][i] = i;
            distance[i][0] = i;

        }
        distance = singleDistance(distance, inputStr1, inputStr2);
        for(int m = 0;m < 6;m++){
            for(int n = 0;n < 6;n++){
                System.out.print(distance[m][n] + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] singleDistance(int[][] input,String x,String y){
        //int len = input.length
        int a = 0;
        int b = 0;
        int c = 0;
        int temp = 0;
        int min = 0;

        for(int j = 1;j < 6;j++){
            for(int k = 1;k < 6;k++){
                if(x.charAt(k - 1)==y.charAt(k - 1)){
                    temp = 0;
                }
                else{
                    temp = 1;
                }
                a = input[j - 1][k] + 1;
                b = input[j][k - 1] + 1;
                c = input[j - 1][k - 1] + temp;
                temp = Math.min(a, b);
                min = Math.min(temp,c );
                input[j][k] = min;
            }


        }
        return input;
    }

    public static class EditDistance {

        /**
         * @author Qunzer
         * @since 2013/12/16
         */

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            String strA = "lucen";
            String strB = "lcan";
            System.out.println("Edit distance is :" + getEditDistance(strA, strB));

        }

        // 求解编辑距离的静态方法
        public static int getEditDistance(String strA, String strB) {
            int lenA = strA.length();
            int lenB = strB.length();
            int[][] dp = new int[lenA + 1][lenB + 1];
            int i, j;
            for (i = 0; i < lenA; i++) {
                dp[i][0] = i;
            }
            for (j = 0; j < lenB; ++j) {
                dp[0][j] = j;
            }
            for (i = 0; i < lenA; ++i) {
                char c1 = strA.charAt(i);
                for (j = 0; j < lenB; ++j) {
                    char c2 = strB.charAt(j);
                    if (c1 == c2)
                        dp[i + 1][j + 1] = dp[i][j];
                    else {
                        int replaceTemp = dp[i][j] + 1;
                        int insertTemp = dp[i + 1][j] + 1;
                        int deleteTemp = dp[i][j + 1] + 1;
                        dp[i + 1][j + 1] = getMin(replaceTemp, insertTemp,
                                deleteTemp);
                    }
                }
            }
            return dp[lenA][lenB];
        }

        // 得到三个中的最小值
        public static int getMin(int a, int b, int c) {
            int min = a > b ? b : a;
            return (c > min ? min : c);
        }
    }

}
