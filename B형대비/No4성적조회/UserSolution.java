package B형대비.No4성적조회;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

class UserSolution {
    static TreeSet<Student>[] set = new TreeSet[6];
    static HashMap<Integer, Student> map = new HashMap<>();

    static Comparator<Student> comparator = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            if(o1.mScore==o2.mScore) {
                return o1.mId - o2.mId;
            }
            return o1.mScore - o2.mScore;
        }
        
    };


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
        map.put(mId, new Student(mId, mGrade, mGender, mScore));
        set[idx].add(map.get(mId));

        //mGrade학년의 mGender인 학생 중 성적 가장 높은 학생의 ID 출력
		return set[idx].last().mId;
	}

	public int remove(int mId) {
        Student s = map.get(mId);
        for(int i=0;i<6;i++) {
            if(set[i].remove(s)) {
                if(s.getmScore()==-1) {
                    return 0;
                } else {
                    s.mScore = -1;
                    map.put(mId, s);
                    return set[i].first().mId;
                }
            }
        }
		return 0;
	}

	public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        int returnInt = Integer.MAX_VALUE;
		for(int a : mGrade) {
            int idx = (a-1)*2;
            for(int b=0;b < mGenderCnt;b++) {
                if(mGender[b][0] == 'f') {
                    idx++;
                }
                set[idx].ceiling(null);
            }
        }
        return 0;
	}
}