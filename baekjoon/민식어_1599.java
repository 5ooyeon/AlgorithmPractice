package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 민식어_1599 {
    static class Word {
        String before, after;
        Word(String before) {
            this.before = before;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Word> arr = new ArrayList<>();

        for(int i=0;i<N;i++) {
            String input = bf.readLine();
            Word word = new Word(input);
            word.after = "";

            for(int j=0;j<input.length();j++) {
                if(input.charAt(j)=='g' && j != 0 && input.charAt(j-1)=='n') continue;
                if(input.charAt(j) == 'k') {
                    word.after += "c"; continue;
                } else if(input.charAt(j) >= 'n') {
                    if(input.charAt(j)=='n' && j < input.length()-1 && input.charAt(j+1)=='g') {
                        word.after += "o"; continue;
                    } else if(input.charAt(j)=='n') {
                        word.after += "n"; continue;
                    } else {
                        word.after += Character.toString((char)(input.charAt(j) + 1));
                    }
                } else {
                    word.after += Character.toString(input.charAt(j));
                }
            }
            arr.add(word);
        }

        Collections.sort(arr, new Comparator<Word>() {

            @Override
            public int compare(Word o1, Word o2) {
                return o1.after.compareTo(o2.after);
            }
            
        });
        for(Word w : arr) {
            System.out.println(w.before);
        }
    }
}
