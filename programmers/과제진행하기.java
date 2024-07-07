package programmers;

import java.util.*;

class 과제진행하기 {

    static class Plan {
        String name;
        int startTime;
        int playTime;

        Plan(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
    }

    //과제 리스트
    static PriorityQueue<Plan> planList = new PriorityQueue<>(new Comparator<Plan>() {

        @Override
        public int compare(Plan o1, Plan o2) {
            return o1.startTime - o2.startTime;
        }
        
    });

    //현재 focus 과제
    static Plan nowPlan = null, nextPlan = null;

    //대기 리스트
    static Stack<Plan> waitList = new Stack<>();

    //정답
    static String[] answer;

    static int ansIdx = 0;
    
    static public String[] solution(String[][] plans) {

        answer = new String[plans.length];

        //과제 리스트에 넣어주기
        for(String[] plan : plans) {
            int startTime = Integer.parseInt(plan[1].split(":")[0])*60 + Integer.parseInt(plan[1].split(":")[1]);
            Plan p = new Plan(plan[0], startTime, Integer.parseInt(plan[2]));
            planList.offer(p);
        }

        while(!planList.isEmpty()) {
            nowPlan = planList.poll();
            int endTime = nowPlan.startTime + nowPlan.playTime;

            //만약 남은 계획이 없다면
            if(planList.isEmpty()) {
                answer[ansIdx] = nowPlan.name;
                while(!waitList.isEmpty()) {
                    ansIdx++;
                    answer[ansIdx] = waitList.pop().name;
                }
                return answer;
            }
    
            //남은 계획이 있다면
            nextPlan = planList.peek();

            //끝나는 시간과 다음 계획 시간을 비교
            int leftTime = nextPlan.startTime - endTime;

            //endTime이 먼저 끝난다면
            if(leftTime >= 0) {
                answer[ansIdx++] = nowPlan.name;

                while(leftTime > 0 && !waitList.isEmpty()) {
                    Plan p = waitList.pop();

                    if(p.playTime <= leftTime) {
                        leftTime -= p.playTime;
                        answer[ansIdx++] = p.name;
                    } else {
                        p.playTime -= leftTime;
                        leftTime = 0;
                        waitList.push(p);
                    }
                }

            } else {
                nowPlan.playTime = - leftTime;
                waitList.push(nowPlan);
            }
            
        }
        return answer;
    }
}
