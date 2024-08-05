package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 생일선물_12892 {
    static class Present {
        int price, value;

        Present(int p, int v) {
            this.price = p;
            this.value = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
        Present[] presents = new Present[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            presents[i] = new Present(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(presents, new Comparator<Present>() {

            @Override
            public int compare(Present o1, Present o2) {
                if(o1.price == o2.price) {
                    return o1.value - o2.value;
                }
                return o1.price - o2.price;
            }
            
        });

        long maxHappiness = 0;
        long currentHappiness = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            // 오른쪽 포인터의 선물 추가
            currentHappiness += presents[right].value;

            // 가격 차이가 D 이상이면 왼쪽 포인터를 이동
            while (presents[right].price - presents[left].price >= D) {
                currentHappiness -= presents[left].value;
                left++;
            }

            // 최대 만족도 갱신
            maxHappiness = Math.max(maxHappiness, currentHappiness);
        }

        System.out.println(maxHappiness);

    }
}
