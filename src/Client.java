
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreOperation operation = (ScoreOperation)XMLUtil.getBean();
		int scores[] = {84,76,50,69,90,91,88,96};
		int result[];
		int score;
		System.out.println("result:");
		result = operation.sort(scores);
		
		for(int i: result){
			System.out.println(i + ",");
		}
		System.out.println();
		
		System.out.println("find 90?");
		score = operation.search(result, 90);
		if(score != -1){
			System.out.println("already find 90");
		}else{
			System.out.println("not find 90");
		}
	}

}
