package Board;

public class Board {
	// 1. 저장할 항목을 private 변수로 생성한다.
	private int num = 1; // 글번호
	private String title; // 글 제목
	private String content; // 글 내용
	
	//4. 일련번호 생성을 위한 static 변수 생성하기
	private static int seq;
	
	//5.생성자를 만들어줌 클래스 이름과 동일하게
	public Board() { //static 변수는 이전에 수정한 내용을 가지고 있기 때문에 1씩 증가
		num = seq+1;
		num = seq; //num은 instance변수라서 생성자를 호출할 때마다 매번 새로 생성
		//새로 생성되는 num에 seq의 값을 대입하면 일련번호가 됨
	}
	
	
	// 2. Source에서 setter,getter 만들기
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	//3. 디버깅을 위한 메소드 만들어주기 source >> generate to string()
		// 출력하는 메소드에 인스턴스를 대입할 때, 호출되는 메소드
		// Java는 인스턴스를 출력하는 메소드에 대입하면 toString이라는 메소드가 호출됨
		// 인스턴스 변수 값을 전부 확인하고자 할 때, 매번 get 메소드를 부르는 건 코드의 낭비
		// 이런 경우는 toString()을 호출해서 한번에 확인 가능.
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", content=" + content + "]";
	}
	

}
