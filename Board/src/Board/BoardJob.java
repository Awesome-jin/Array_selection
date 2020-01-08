package Board;

//게시판 작업을 위한 메소드
public class BoardJob {

	Board[] list = new Board[100];
	// Board 100개를 저장할 수 있는 공간을 100개 생성해서 이름을 list라고 붙인 것

	// 전체 목록이나 일부 목록을 리턴하는 메소드
	// 리턴 타입은 배열이나 List
	// 일부 목록을 가져올 때는 매개변수로 페이지 번호를 갖는 경우가 많음
	public Board[] getList() {
		return list; // 이러면 공간 100개를 다 준것!
	}

	// 페이지 번호에 해당하는 데이터를 가져오는 메소드
	// 만약 제목이나 내용으로 가져오고 싶다면 String title, String content 같은게 들어갈것
	public Board[] getList(int pageNo) { // 리스트의 매개변수로 페이지번호가 들어감
		// 한 페이지에 10개씩 있다고 가정하면?? 0~9, 10~19, 20~29...
		Board[] r = new Board[10];
		// pageNo가 1일때는 0과 9, 2일때는 10과 19
		int start = (int) 10 * (PageNo - 1);
		int end = (int) 10 * Pageno - 1;

		for (int i = 0; i < 10; i = i + 1) {
			r[i] = list[start + i];
		}
		return r;
	}

	// 글번호에 해당하는 데이터를 1개 가져오는 메소드 (=상세보기)
	// 기본키를 매개변수로 받아서 처리
	public Board getBoard(int num) { // getBoard는 이름. int num 매개변수는 글번호로 사용할 객체
		// list에서 num이라는 글번호를 가진 데이터를 찾아 리턴을 해줘야 함
		Board board = null; // 동일한 글 번호가 없으면 null이 계속 리턴되는 구조

		// list를 순회하면서 num과 같은 글번호를 가진 데이터를 찾아서 board에 대입
		for (Board temp : list) {
			if (temp != null) {
				if (temp.getNum() == num) { // 동일한 글번호를 찾으면 더 이상 반복문을 수행할 필요가 없으니 break
					board = temp;
					break;
				}
			}
		}
		return board;
	}

	// 글 쓰기를 처리하는 메소드 (데이터 삽입 처리)
	// 수행 결과를 알려주고 싶다면 boolean이나 int로 return
	// 수행 결과를 알려주지 않고자 할 때는 void (실패는 없다는 가정)

	// 현재 작성된 글의 개수를 저장하기 위한 변수 - List를 사용하게 되면 필요없음
	private int cnt;

	public boolean insertBoard(Board board) {
		list[cnt] = board;
		cnt = cnt + 1;
		return false;
	}

	// 글 수정을 처리하는 메소드
	// 리턴 타입은 삽입과 동일
	// 매개변수도 삽입과 동일
	// 수정을 할 때는 기본키(글번호)의 값이 자동으로 설정 되는 게 좀 다름!!
	public boolean updateBoard(Board board) {
		// 글 번호에 해당하는 데이터를 찾아서 데이터를 찾으면 board로 대체
		for (int i = 0; i < cnt; i = i + 1) {
			Board imsi = list[i];
			// 글 번호 비교
			if (imsi != null) {
				if (imsi.getNum() == board.getNum()) {
					list[i] = board;
					break;
				}
			}
		}
		return true;
	}

	// 삭제를 처리하는 메소드
	// 삭제할 때는 데이터 전체가 필요하지 않고 일반적으로 기본키만 필요함
	public boolean deleteBoard(int num) {
		// list에 모든 데이터를 순회해서 글번호가 num인 데이터를 찾고! 그 위치에 null을 대입하는 구조
		for (int i = 0; i < cnt; i = i + 1) {
			Board imsi = list[i];
			// 글 번호 비교
			if (imsi != null) {
				if (imsi.getNum() == num) {
					list[i] = null;
					break;
				}
			}
		}
		return true;
	}
}
