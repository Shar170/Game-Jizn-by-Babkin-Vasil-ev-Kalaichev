
public class LogicMP {
	public LogicMP() {
		System.out.println("запущена логика мультиплеера");
	}
	
	public int IsLifeMP(int K, int L, int storona){
		// K => 1
		// L => 2
		if(K == L) return storona;
		
		if(K > L && storona == 2) return 0;
		if(K < L && storona == 2) return 2;		
		if(L > K && storona == 1) return 0;
		if(K > L && storona == 1) return 1;
		
		return 0;
	};
}
