package B형대비.No4성적조회;

import java.util.ArrayList;
import java.util.TreeMap;

class UserSolution {
    static TreeMap<Integer, Student>[] map = new TreeMap[6];

    static class Student{
        int mId;
        int mGrade;
        char mGender;
        int mScore;

        Student() {

        }

        Student(int mId, int mGrade, char[] mGender, int mScore) {
            this.mId = mId;
            this.mGrade = mGrade;
            this.mGender = mGender[0];
            this.mScore = mScore;
        }

        public int getmScore() {
            return mScore;
        }

        public void setmScore(int mScore) {
            this.mScore = mScore;
        }

        
    }

	public void init() {
		return;
	}

	public int add(int mId, int mGrade, char mGender[], int mScore) {
        int idx = (mGrade-1)*2;
        if(mGender[0] == 'f') {
            idx++;
        }
        map[idx].put(mId, new Student(mId, mGrade, mGender, mScore));
        //mGrade학년의 mGender인 학생 중 성적 가장 높은 학생의 ID 출력
		return map[idx].lastKey();
	}

	public int remove(int mId) {
        for(int i=0;i<6;i++) {
            Student temp = map[i].get(mId);
            if(temp!=null) {
                if(temp.mScore == -1) {
                    return 0;
                } else {
                    temp.mScore = -1;
                    return map[i].firstKey();
                }
            }
        }
		return 0;
	}

	public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
		for(int a : mGrade) {
            int idx = (a-1)*2;
            for(int b=0;b < mGenderCnt;b++) {
                if(mGender[b][0] == 'f') {
                    idx++;
                }
                
            }
        }
        return 0;
	}
}