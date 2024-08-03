package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 졸업사진_23349
 */
public class 졸업사진_23349 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, Integer> indexMap = new HashMap<>();
        HashMap<String, String> placeMap = new HashMap<>();
        TreeMap<String, Integer> placeCount = new TreeMap<>();
        TreeMap<Integer, Integer> timePerPlace = new TreeMap<>();
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = null;
        int idx = 0;

        for(int time=0;time<N;time++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();

            if(indexMap.containsKey(name)) {
                continue;
            }
            String place = st.nextToken();
            int startTime = Integer.parseInt(st.nextToken()),
            endTime = Integer.parseInt(st.nextToken());

            indexMap.put(name, idx++);
            placeMap.put(name, place);
            placeCount.put(place, placeCount.getOrDefault(place, 0)+1);
            for(int t = startTime; t <= endTime; t++) {
                timePerPlace.put(t, timePerPlace.getOrDefault(t, 0)+1);
            }

        }

        

    }
}