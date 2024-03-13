import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

class UserSolution {
	
	static int H, W;
	static Deque<Character> frontDeque, backDeque;
	
	void init(int H, int W, char mStr[]) {
		this.H= H;
		this.W= W;
		frontDeque = new ArrayDeque<>();
		backDeque = new ArrayDeque<>();
		for(Character c : mStr) {
			backDeque.offer(c);
		}

	}

	void insert(char mChar) {
		frontDeque.offer(mChar);
	}

	char moveCursor(int mRow, int mCol) {
		int size = (mRow-1) * W + mCol-1;
		
		while(frontDeque.size()!=size) {
			if(frontDeque.size()<size) {
				frontDeque.offerLast(backDeque.pollFirst());
			} else if(frontDeque.size()>size) {
				backDeque.offerFirst(frontDeque.pollLast());
			}
		}
		if(backDeque.size()==0) {
			return '$';
		}
		return backDeque.peekFirst();
	}

	int countCharacter(char mChar) {
		int retNum = 0;
		Iterator<Character> itr = backDeque.iterator();
		while(itr.hasNext()) {
			if(itr.next() == mChar) {
				retNum++;
			}
		}
		return retNum;
	}
}