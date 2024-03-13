import java.util.*;

class UserSolution {

    static TreeSet<Player>[] leagues;
    //0, 2, 4, 6, 8 이렇게 같은 리그...

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
        leagues = new TreeSet[2*L];
        for (int i = 0; i < 2*L; i++) {
        	leagues[i] = new TreeSet<>(C);
        	int[] leagueArray;
        	//짝수일 때는 앞 리그이므로, N/2*L 담기
        	if(i%2==0) {
                leagueArray = Arrays.copyOfRange(mAbility, idx, idx + N / (2*L));        		
        	} else {
        		//홀수일 때는 뒤 리그이므로, (N/(2*L)) +1 담기
        		leagueArray = Arrays.copyOfRange(mAbility, idx, idx + (N/(2*L)) +1);
        	}


            for(int j=0;j<leagueArray.length;j++) {
            	leagues[i].add(new Player(idx+j, leagueArray[j]));
            }
            
            idx += N / (2*L);
            
            if(i%2==1) {
            	idx++;
            }
        }
        sortPlayers();
        //출력 확인용
//        for(int i=0;i<leagues.length-1;i+=2) {
//        	Iterator<Player> itr = leagues[i].iterator();
//        	while(itr.hasNext()) {
//        		Player p = itr.next();
//        		System.out.print(p.ability+"(id: "+p.id+"), ");
//        	}
//        	System.out.print(" and ");
//        	itr = leagues[i+1].iterator();
//        	while(itr.hasNext()) {
//        		Player p = itr.next();
//        		System.out.print(p.ability+"(id: "+p.id+"), ");
//        	}
//        	System.out.println();
//        }

    }

    int move() {
        int sum = 0;
        for (int i = 0; i < leagues.length-3 ; i+=2) {
            Player highLeague = leagues[i+1].pollLast();
            Player lowLeague = leagues[i+2].pollFirst();
            
            leagues[i+1].add(lowLeague);
            leagues[i+2].add(highLeague);
            
            sum += (highLeague.id + lowLeague.id);
        }
        //앞리그 뒷리그 수 정렬해주는 매소드 실행
        sortPlayers();
        
        return sum;
    }

    int trade() {
        int sum = 0;
        for (int i = 0; i < leagues.length-3; i+=2) {
        	Player highLeague = leagues[i+1].pollFirst();
        	Player lowLeague = leagues[i+2].pollFirst();
        	
        	leagues[i+1].add(lowLeague);
        	leagues[i+2].add(highLeague);
        	
        	sum += (highLeague.id + lowLeague.id);
        }
        //앞리그 뒷리그 수 정렬해주는 매소드 실행
        sortPlayers();
        return sum;
    }
    
    private void sortPlayers() {
    	for (int i = 0; i < leagues.length-1; i+=2) {
    		//앞 리그 leagues[i], 뒷 리그 leagues[i+1]
    		
    		while(leagues[i].last().ability < leagues[i+1].first().ability) {
    			leagues[i].add(leagues[i+1].pollFirst());
    			leagues[i+1].add(leagues[i].pollLast());
    		}
    		while(leagues[i].last().ability == leagues[i+1].first().ability && leagues[i].last().id > leagues[i+1].first().id) {
    			leagues[i].add(leagues[i+1].pollFirst());
    			leagues[i+1].add(leagues[i].pollLast());
    		}
    		Player first = leagues[i].last(), last = leagues[i+1].first();
    		//
    	}
    }
    
    
}
