package Board;
import org.junit.Test;

public class Boardtest {
	@Test
	public void testMethod() { //test를 위한 메소드를 별도로 만들어주기
	Board board = new Board();
	System.out.println(board);
	
	Board board1 = new Board();
	System.out.println(board1); // 생성자로 num잘 붙는지 확인하기
	}

}
