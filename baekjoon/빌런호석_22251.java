package baekjoon;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class 빌런호석_22251 {
//     static int input[], panel[][], cnt;
//     static String key;
//     public static void main(String[] args) throws IOException {
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(bf.readLine());

//         input = new int[4];

//         for(int i=0;i<4;i++) {
//             input[i] = Integer.parseInt(st.nextToken());
//         }

//         // i==0 -> 1층 ~ input[0]층까지 바꿀 수 있음
//         // i==1 -> 현재 패널 개수
//         // i==2 -> LED 바꿀 수 있는 개수
//         // i==3 -> 현재 층 수

//         //변경 패널 수를 저장해놓는 2차원배열
//         panel = new int[10][10];

//         panel[0][1] = 4; panel[1][0] = 4;
//         panel[0][2] = 3; panel[2][0] = 3;
//         panel[0][3] = 3; panel[3][0] = 3;
//         panel[0][4] = 4; panel[4][0] = 4;
//         panel[0][5] = 3; panel[5][0] = 3;
//         panel[0][6] = 2; panel[6][0] = 2;
//         panel[0][7] = 3; panel[7][0] = 3;
//         panel[0][8] = 1; panel[8][0] = 1;
//         panel[0][9] = 2; panel[9][0] = 2;

//         panel[1][2] = 5; panel[2][1] = 5;
//         panel[1][3] = 3; panel[3][1] = 3;
//         panel[1][4] = 2; panel[4][1] = 2;
//         panel[1][5] = 5; panel[5][1] = 5;
//         panel[1][6] = 6; panel[6][1] = 6;
//         panel[1][7] = 1; panel[7][1] = 1;
//         panel[1][8] = 5; panel[8][1] = 5;
//         panel[1][9] = 4; panel[9][1] = 4;

//         panel[2][3] = 2; panel[3][2] = 2;
//         panel[2][4] = 5; panel[4][2] = 5;
//         panel[2][5] = 4; panel[5][2] = 4;
//         panel[2][6] = 3; panel[6][2] = 3;
//         panel[2][7] = 5; panel[7][2] = 5;
//         panel[2][8] = 2; panel[8][2] = 2;
//         panel[2][9] = 3; panel[9][2] = 3;

//         panel[3][4] = 3; panel[4][3] = 3;
//         panel[3][5] = 2; panel[5][3] = 2;
//         panel[3][6] = 3; panel[6][3] = 3;
//         panel[3][7] = 3; panel[7][3] = 3;
//         panel[3][8] = 2; panel[8][3] = 2;
//         panel[3][9] = 1; panel[9][3] = 1;

//         panel[4][5] = 3; panel[5][4] = 3;
//         panel[4][6] = 4; panel[6][4] = 4;
//         panel[4][7] = 3; panel[7][4] = 3;
//         panel[4][8] = 3; panel[8][4] = 3;
//         panel[4][9] = 2; panel[9][4] = 2;

//         panel[5][6] = 1; panel[6][5] = 1;
//         panel[5][7] = 4; panel[7][5] = 4;
//         panel[5][8] = 2; panel[8][5] = 2;
//         panel[5][9] = 1; panel[9][5] = 1;

//         panel[6][7] = 5; panel[7][6] = 5;
//         panel[6][8] = 1; panel[8][6] = 1;
//         panel[6][9] = 2; panel[9][6] = 2;

//         panel[7][8] = 4; panel[8][7] = 4;
//         panel[7][9] = 3; panel[9][7] = 3;

//         panel[8][9] = 1; panel[9][8] = 1;



//         key = Integer.toString(input[3]);
//         if(key.length() != input[1]) {
//             String newKey = "";
//             for(int i=0;i<(input[1] - key.length());i++) {
//                 newKey += "0";
//             }
//             newKey += key;
//             key = newKey;
//         }

//         cnt = 0;

//         for(int i=0;i<=9;i++) {
//             int sum = panel[key.charAt(0) - '0'][i];

//             getCnt(1, sum, Integer.toString(i));
//         }

//         System.out.println(cnt);

//     }

//     static void getCnt(int idx, int sum, String cur) {
//         if(sum > input[2]) return;

//         if(idx == input[1]) {
//             if(sum == 0 || Integer.parseInt(cur)==0) return;
//             if(Integer.parseInt(cur) <= input[0]) {
//                 // System.out.print(cur+" ");
//                 cnt++; return;
//             } else {
//                 return;
//             }
            
//         }

//         for(int i=0;i<=9;i++) {
//             getCnt(idx+1, sum+panel[key.charAt(idx) - '0'][i], cur+Integer.toString(i));
//         }

//     }

// }
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빌런호석_22251 {
    static int N, K, P, X;
    static int[][] panel = new int[10][10];
    static int[] digit = new int[7];
    static int cnt;
    static String key;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        // Initialize panel differences
        initializePanel();
        
        // Convert X to a string with leading zeros
        key = String.format("%0" + K + "d", X);
        
        cnt = 0;
        
        // Check all possible floors
        for (int i = 1; i <= N; i++) {
            if (i == X) continue; // Skip the current floor
            
            String target = String.format("%0" + K + "d", i);
            int ledChanges = calculateLedChanges(key, target);
            if (ledChanges > 0 && ledChanges <= P) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
    
    static void initializePanel() {
        int[][] digitToLed = {
            {1, 1, 1, 1, 1, 1, 0}, // 0
            {0, 1, 1, 0, 0, 0, 0}, // 1
            {1, 1, 0, 1, 1, 0, 1}, // 2
            {1, 1, 1, 1, 0, 0, 1}, // 3
            {0, 1, 1, 0, 0, 1, 1}, // 4
            {1, 0, 1, 1, 0, 1, 1}, // 5
            {1, 0, 1, 1, 1, 1, 1}, // 6
            {1, 1, 1, 0, 0, 0, 0}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1}  // 9
        };
        
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                int changes = 0;
                for (int k = 0; k < 7; k++) {
                    if (digitToLed[i][k] != digitToLed[j][k]) {
                        changes++;
                    }
                }
                panel[i][j] = changes;
            }
        }
    }
    
    static int calculateLedChanges(String current, String target) {
        int totalChanges = 0;
        for (int i = 0; i < K; i++) {
            int curDigit = current.charAt(i) - '0';
            int targetDigit = target.charAt(i) - '0';
            totalChanges += panel[curDigit][targetDigit];
        }
        return totalChanges;
    }
}
