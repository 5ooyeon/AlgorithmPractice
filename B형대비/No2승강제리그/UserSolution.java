import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

class UserSolution {

    static LinkedList<Player>[] tempLeagues;
    static TreeSet<Player>[] leagues;

    class Player{
    	int id;
    	int ability;
    	
    	Player(int id, int ability) {
    		this.id = id;
    		this.ability = ability;
    	}
    }
    
    Comparator<Player> C = new Comparator<Player>() {
		
		@Override
		public int compare(Player o1, Player o2) {
			if(o1.ability == o2.ability) {
				return o1.id - o2.id;
			}
			return o2.ability - o1.ability;
		}
	};
    
    
    void init(int N, int L, int mAbility[]) {
//        leagues = new Player[L][N / L];
        int idx = 0;
        for (int i = 0; i < L; i++) {
        	leagues[i] = new TreeSet<>(C);
            int[] leagueArray = Arrays.copyOfRange(mAbility, idx, idx + N / L);

            for(int j=0;j<leagueArray.length;j++) {
            	leagues[i].add(new Player(idx+j, leagueArray[j]));
            }
            idx += N / L;
        }
        sortPlayers();
    }

    int move() {
        int sum = 0;
        for (int i = 0; i < leagues.length-1 ; i++) {
            Player lowPlayer = leagues[i].pollLast();
            Player highPlayer = leagues[i+1].pollFirst();
            tempLeagues[i].add(highPlayer);
            tempLeagues[i+1].add(lowPlayer);
            sum += lowPlayer.id + highPlayer.id;
        }
        sortPlayers();

        return sum;
    }

    int trade() {
        int sum = 0;
        for (int i = 0; i < leagues.length-1; i++) {
            Player middlePlayer = leagues[i].
            Player highPlayer = leagues[i+1].pollFirst();
            leagues[toLeague][0] = middlePlayer;
            leagues[fromLeague][(leagues[fromLeague].length)/2] = highPlayer;
        }
        sortPlayers();
        return sum;
    }

    private int movePlayer(int fromLeague, int toLeague) {
        Player lowPlayer = leagues[fromLeague].last();
        Player highPlayer = leagues[toLeague].first();
        leagues[toLeague][ = lowPlayer;
        leagues[fromLeague][leagues[fromLeague].length-1] = highPlayer;
        return highPlayer.id + lowPlayer.id;
    }

    private int tradePlayer(int fromLeague, int toLeague) {
        Player middlePlayer = leagues[fromLeague][(leagues[fromLeague].length)/2];
        Player highPlayer = leagues[toLeague][0];
        leagues[toLeague][0] = middlePlayer;
        leagues[fromLeague][(leagues[fromLeague].length)/2] = highPlayer;
        return highPlayer.id + middlePlayer.id;
    }
    
    private void sortPlayers() {
    	for (int i = 0; i < leagues.length; i++) {
    	    Arrays.sort(leagues[i], (o1, o2) -> {
    	        int abilityComparison = Integer.compare(o2.ability, o1.ability);
    	        if (abilityComparison == 0) {
    	            return Integer.compare(o1.id, o2.id);
    	        }
    	        return abilityComparison;
    	    });
    	}
    }
    
    
}
