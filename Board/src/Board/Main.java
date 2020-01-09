package Board;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// ★ 실행하기 전에 클래스의 메소드들이 제대로 작동하는지 보자
		final int 전체보기 = 1;
		final int 상세보기 = 2;
		final int 삽입 = 3;
		final int 수정 = 4;
		final int 삭제 = 5;
		final int 종료 = 6;

		// 키보드로부터 입력받기 위한 객체 생성
		Scanner sc = new Scanner(System.in);

		BoardJob boardjob = new BoardJob(); // 게시판 작업을 수행할 인스턴스를 바깥에서 작성

		while (true) {
			System.out.print("1. 전체보기 | 2. 상세보기 | 3. 삽입 | 4. 수정 | 5. 삭제 | 6. 종료 : ");
			int menu = sc.nextInt();

			// 메뉴에 따른 분기
			switch (menu) {

			case 전체보기:
				// BoardJob 클래스의 getList 메소드가 처리 할 수 있다면?????
				// 1. 옆에 까보니까 static이 아닌 메소드를 사용해야 하니 인스턴스가 먼저 필요
				// 2. BoardJob은 생성자 이름
				// BoardJob boardjob = new BoardJob();
				// getList()를 보니까 '매개변수는 필요없고 리턴이 Board[]네!' 파악하기
				Board[] boards = boardjob.getList();
				// 배열의 데이터를 출력하기
				for (Board board : boards) {
					if (board != null) {
						System.out.println(board);
					}
				}
				break;

			case 상세보기:
				// 글번호를 입력 받아서 상세보기 메소드 호출
				// 상세보기 글번호에 해당하는 데이터가 있으면 데이터 리턴 없으면 null

				// 글번호 입력
				System.out.print("상세보기 할 글 번호 : ");
				int num = sc.nextInt();

				Board board1 = boardjob.getBoard(num);
				if (board1 == null) {
					System.out.println("글 번호에 해당하는 데이터가 없습니다");
				} else {
					System.out.println(board1);
				}

				break;

			case 삽입: // BoardJob의 insertBoard가 처리한다~!
				// instance method > 매개변수는 Board > 리턴은 boolean
				// 1.instance method 만들기
				// BoardJob boardjob2 = new BoardJob(); :switch문 바깥으로! 동시에 하는 작업은 아니니까 굳이 이름 다르게
				// 2개 만들 필요가 없다.

				// 2. 매개변수 board가 필요함
				Board board = new Board();

				System.out.print("제목 입력: ");
				// 이전에 정수값으로 1~6을 고르게하고 엔터가 남아있는 상태기 때문에 이 라인이 엔터를 인력받고 넘어가버림
				sc.nextLine(); // 남아있는 엔터 넘기기 위한 코드
				String temp = sc.nextLine();
				board.setTitle(temp);

				System.out.print("내용 입력: ");
				temp = sc.nextLine();
				board.setContent(temp);

				// 3. return값을 받을 boolean
				boolean r = boardjob.insertBoard(board);

				break;
			case 수정:
				System.out.println("수정할 글 번호: ");
				int n = sc.nextInt();
				Board b = boardjob.getBoard(n);
				if (b == null) {
					System.out.println("글 번호에 해당하는 데이터가 없습니다.");
					continue;
				} else {
					System.out.print("수정할 제목:");
					sc.nextLine();
					b.setTitle(sc.nextLine());
					System.out.print("수정할 내용:");
					b.setContent(sc.nextLine());

					boardjob.updateBoard(b);
				}
				break;

			case 삭제:
				// 1. 삭제할 번호를 입력 받고
				// 2. 해당하는 데이터가 있는지 확인하고
				// 3. 정말로 삭제할 것인지 묻고 삭제하기
				System.out.println("삭제할 글 번호는?: "); // 1. 삭제할 번호를 입력 받고
				int x = sc.nextInt(); // 입력받은 글번호를 저장

				Board y = boardjob.getBoard(x); // 글을 찾아 오기
				if (y == null) {
					System.out.println("글 번호에 해당하는 글이 없습니다.");
					continue; // break로 내려가버리면 안되니까
				} else {
					System.out.print("정말로 삭제하시려면 1을 누르세요:");
					int delkey = sc.nextInt();
					if (delkey == 1) {
						boardjob.deleteBoard(x);
					}
					else
					{
						System.out.print("삭제를 취소했습니다.");
					}
				}
				break;
			case 종료:
				sc.close();
				System.out.println("종료합니다");
				System.exit(0);// 프로그램종료
				break;
			default:
				System.out.println("메뉴를 확인하세요");
				break;
			}
		}
	}
}