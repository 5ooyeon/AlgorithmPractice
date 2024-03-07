package B형대비.No4성적조회;

import java.util.ArrayList;

class UserSolution {

    Student[] mIdSort = new Student[1000000000];
    ArrayList<Student>[] gradeSort = new ArrayList[3];

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
        for(int i=0;i<3;i++) {
            gradeSort[i] = new ArrayList<>();
        }
		return;
	}

	public int add(int mId, int mGrade, char mGender[], int mScore) {
        mIdSort[mId-1] = new Student(mId, mGrade, mGender, mScore);
        //mGrade학년의 mGender인 학생 중 성적 가장 높은 학생의 ID 출력
		return 0;
	}

	public int remove(int mId) {
        
		return 0;
	}

	public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
		return 0;
	}
}