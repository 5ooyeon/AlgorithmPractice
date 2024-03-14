import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UserSolution {
	//부서 class 만들기
	static class Dept{
		int mId;
		int mNum;
		int parent;
		
		Dept(int mId, int mNum) {
			this.mId = mId;
			this.mNum = mNum;
			parent = -1;
		}
		
		Dept(int mId, int mNum, int parent) {
			this.mId = mId;
			this.mNum = mNum;
			this.parent = parent;
		}
	}
	//부모 부서를 key값으로 하고 자식 부서를 value의 ArrayList에 넣는 HashMap 만들기.
	static HashMap<Dept, ArrayList<Dept>> childMap;
	
	//자식 부서를 Key값으로 하고 부모 부서를 value로 하는 HashMap 만들기
	static HashMap<Dept, Integer> parentMap;
	
	//부서 저장할 HashMap
	static HashMap<Integer, Dept> Departure;
	
	//add 함수 실행 시 인원수 합 받을 int 메소드
	int sum;
	
	public void init(int N, int mId[], int mNum[]) {
		childMap = new HashMap<>();
		parentMap = new HashMap<>();
		Departure = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			Dept d = new Dept(mId[i], mNum[i]);
			//map에 Dept넣기
			childMap.put(d, new ArrayList<>());
			parentMap.put(d, -1);
			//map에 넣기
			Departure.put(d.mId, d);
		}
		return;
	}

	public int add(int mId, int mNum, int mParent) {
		Dept parentDept = Departure.get(mParent);
		Dept childDept = new Dept(mId, mNum, mParent);

		ArrayList<Dept> children = childMap.get(parentDept);
		
		//mParent부서에 이미 3개의 하위 부서가 존재한다면
		if(children!=null && children.size()==3) {
			//추가에 실패하고 -1을 반환.
			return -1;
		}
		//하위 부서에 추가
		parentMap.put(childDept, mParent);
		if(childMap.get(parentDept)==null) {
			childMap.put(parentDept, new ArrayList<>());
		}
		childMap.get(parentDept).add(childDept);
		
		//parentDept과 모든 하위 부서의 인원 수 합 반환
		
		//인원 수 받을 int 초기화
		sum = parentDept.mNum;
		getNumSum(parentDept, 0);
		return sum;
	}

	private void getNumSum(Dept parentDept, int delete) {
		//parentDept의 모든 자식 ArrayList 갖고오기
		if(childMap.get(parentDept)==null) {
			return;
		}
		for(Dept d : childMap.get(parentDept)) {
			sum += d.mNum;
			if(delete==1) {
				Departure.remove(d.mId);
			}
			getNumSum(d, delete);
		}
	}

	public int remove(int mId) {
		Dept dept = Departure.get(mId);
		
		//이미 삭제된 부서거나 존재하지 않는 부서일경우
		if(dept == null) {
			return -1;
		}
		
		//인원수 받을 int 초기화
		sum = dept.mNum;
		Departure.remove(dept);
		getNumSum(dept, 1);
		return sum;
	}

	public int distribute(int K) {
		return 0;
	}
}