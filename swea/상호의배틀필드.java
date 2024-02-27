package swea;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 상호의배틀필드
 */
public class 상호의배틀필드 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <=T ; tc++) {
            st = new StringTokenizer(bf.readLine());
            sb.append("#"+tc+" ");
            String[][] map = new String[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
            
            int x=0, y=0;

            for(int i=0;i<map.length;i++) {
                String input = bf.readLine();
                for(int j=0;j<map[i].length;j++) {
                    map[i][j] = Character.toString(input.charAt(j));
                    if(map[i][j].equals("^") || map[i][j].equals(">")|| map[i][j].equals("v")|| map[i][j].equals("<")) {
                        x=i; y=j;
                    }
                }
            }

            bf.readLine();
            String input = bf.readLine();
            int idx = 0;
            while(idx != input.length()) {
                switch (Character.toString(input.charAt(idx))) {
                    case "U":
                        map[x][y] = "^";
                        if(x-1>=0 && map[x-1][y].equals(".")) {
                            map[x][y] = ".";
                            x--;
                            map[x][y] = "^";
                        }
                        break;
                    case "R":
                        map[x][y] = ">";
                        if(y+1 < map[x].length && map[x][y+1].equals(".")) {
                            map[x][y] = ".";
                            y++;
                            map[x][y] = ">";
                        }
                        break;
                    case "D":
                        map[x][y] = "v";
                        if(x+1 < map.length && map[x+1][y].equals(".")) {
                            map[x][y] = ".";
                            x++;
                            map[x][y] = "v";
                        }
                        break;
                    case "L":
                        map[x][y] = "<";
                        if(y-1>=0 && map[x][y-1].equals(".")) {
                            map[x][y] = ".";
                            y--;
                            map[x][y] = "<";
                        }
                        break;
                    default:
                        switch (map[x][y]) {
                            case "^":
                                for(int i=x-1;i >=0; i--) {
                                    if(map[i][y].equals("*")) {
                                        map[i][y] = "."; break;
                                    } else if(map[i][y].equals("#")) {
                                        break;
                                    }
                                }
                                break;
                            case ">":
                                for(int i=y+1;i <map[x].length; i++) {
                                    if(map[x][i].equals("*")) {
                                        map[x][i] = "."; break;
                                    } else if(map[x][i].equals("#")) {
                                        break;
                                    }
                                }
                                break;
                            case "v":
                                for(int i=x+1;i < map.length; i++) {
                                    if(map[i][y].equals("*")) {
                                        map[i][y] = "."; break;
                                    } else if(map[i][y].equals("#")) {
                                        break;
                                    }
                                }
                                break;
                            default:
                                for(int i=y-1;i >= 0; i--) {
                                    if(map[x][i].equals("*")) {
                                        map[x][i] = "."; break;
                                    } else if(map[x][i].equals("#")) {
                                        break;
                                    }
                                }
                                break;
                        }
                        break;
                }
                idx++;
            }
            for(int i=0;i<map.length;i++) {
                for(int j=0;j<map[i].length;j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}