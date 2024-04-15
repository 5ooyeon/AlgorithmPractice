package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열돌리기3_16935 {
    static int N, M, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());

        while(st.hasMoreTokens()) {
            switch (st.nextToken()) {
                case "1":
                    move1();
                    break;
                case "2":
                    move2();
                    break;
                case "3":
                    move3();
                    break;
                case "4":
                    move4();
                    break;            
                case "5":
                    move5();
                    break;            
                case "6":
                    move6();
                    break;
                default:
                    break;
            }
        }
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void move1() {
        int[][] newArr = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++) {
            newArr[i] = arr[arr.length-1-i];
        }
        arr = newArr;
    }
    private static void move2() {
        int[][] newArr = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                newArr[i][j] = arr[i][arr[i].length-1-j];
            }
        }
        arr = newArr;
    }
    private static void move3() {
        int[][] newArr = new int[arr[0].length][arr.length];
        for(int i=0;i<newArr.length;i++) {
            for(int j=0;j<newArr[i].length;j++) {
                newArr[i][j] = arr[arr.length-1-j][i];
            }
        }
        arr = newArr;
    }
    private static void move4() {
        int[][] newArr = new int[arr[0].length][arr.length];
        for(int i=0;i<newArr.length;i++) {
            for(int j=0;j<newArr[i].length;j++) {
                newArr[i][j] = arr[j][arr[0].length-1-i];
            }
        }
        arr = newArr;
    }
    private static void move5() {
        int[][] newArr = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length/2;i++) {
            for(int j=0;j<arr[i].length/2;j++) {
                newArr[i][j] = arr[i+arr.length/2][j];
            }
            for(int j=arr[i].length/2;j<arr[i].length;j++) {
                newArr[i][j] = arr[i][j-arr[i].length/2];
            }
        }
        for(int i=arr.length/2;i<arr.length;i++) {
            for(int j=0;j<arr[i].length/2;j++) {
                newArr[i][j] = arr[i][j+arr[0].length/2];
            }
            for(int j=arr[i].length/2;j<arr[i].length;j++) {
                newArr[i][j] = arr[i-arr.length/2][j];
            }
        }
        arr = newArr;
    }
    private static void move6() {
        int[][] newArr = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length/2;i++) {
            for(int j=0;j<arr[i].length/2;j++) {
                newArr[i][j] = arr[i][j+arr[0].length/2];
            }
            for(int j=arr[i].length/2;j<arr[i].length;j++) {
                newArr[i][j] = arr[i+arr.length/2][j];
            }
        }
        for(int i=arr.length/2;i<arr.length;i++) {
            for(int j=0;j<arr[i].length/2;j++) {
                newArr[i][j] = arr[i-arr.length/2][j];
            }
            for(int j=arr[i].length/2;j<arr[i].length;j++) {
                newArr[i][j] = arr[i][j-arr[0].length/2];
            }
        }
        arr = newArr;
    }
}
