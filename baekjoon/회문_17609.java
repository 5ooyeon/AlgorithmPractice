package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문_17609 {
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int tc =0; tc < t; tc++) {
            char[] inputs = bf.readLine().toCharArray();
            int p1 = 0, p2 = inputs.length-1;
            boolean isPalin = true, pseudo = false;
            while(isPalin && p1 <= p2) {
                if(inputs[p1] == inputs[p2]) {
                    p1++; p2--;
                    continue;
                } else {
                    if(!pseudo) {
                        pseudo = true;
                        if(inputs[p1+1] != inputs[p2] && inputs[p1] != inputs[p2-1]) {
                            isPalin = false;
                            break;
                        }
                        check= false;
                        checkPalin(p1+1, p2, inputs);
                        if(check) {
                            checkPalin(p1, p2-1, inputs);
                            if(check) {
                                isPalin = false;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        isPalin = false;
                        break;
                    }
                }
            }
            if(!isPalin) {
                System.out.println(2);
            } else if(pseudo) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    static void checkPalin(int p1, int p2, char[] inputs) {
        if(p1 >= p2) {
            check= false;
            return;
        }
        if(inputs[p1] != inputs[p2]) {
            check = true;
            return;
        }
        checkPalin(p1+1, p2-1, inputs);
    }
}
