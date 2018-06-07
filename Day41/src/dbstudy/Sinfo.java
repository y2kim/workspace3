package dbstudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//String 특이한 놈 ,   오브젝트로 부터 상속받았을때 오버라이드 됨
// 인스턴스 변수 값 호출 ㅎ할때 toString 이 숨어져 있다.  마음대로 조절 

public class Sinfo {
	public static void main(String[] args) {
		DBCollect dba = new DBCollect();
		List select = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println(" << == 학생 관리 프로그램 == >>");
			System.out.println(" 1. 신규 정보 입력");
			System.out.println(" 2. 학생 목록 출력");
			System.out.println(" 3. 학생 정보 삭제");
			System.out.println(" 4. 학생 정보 수정");
			System.out.println(" 5. 프로 그램 종료");
			System.out.println(" >> ");
			String menu = sc. nextLine();
			if(menu.equals("1")) {
				System.out.println(">> === 신규 정보를 등록합니다."); //학번,이름,점수 
				System.out.println("이 름 : ");
				String name = sc.nextLine();
				System.out.println("점 수 : ");
				int score = Integer.parseInt(sc.nextLine());
				
				TypeStudent ts = new TypeStudent();
				ts.setName(name);
				ts.setScore(score);
				
				try {
					int ab = dba.insertData(ts);
					if(ab>0) {
						System.out.println("성공을 하였습니다.");
					}else {
						System.out.println("입력에 실패하였씁니다");
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("DB연결에 실패하였습니다.");
				}

			}else if(menu.equals("2")) {  //rank() OVER (ORDER BY SALARY DESC)

				try {
					//select.addAll(dba.selectData());
					List<TypeStudent> result = dba.selectData();
//				    List result = dba.selectData();  // <자료명>  <- 제너릭
//					for(String str:select) {  //(:collection)
//						System.out.println(str);
//					}
//					for(Object str:select) { 
//						System.out.println(str);
//					}
					for(TypeStudent str:result) { 
					 //System.out.println(str.getId()+" "+str.getName()+" "+str.getScore());
						System.out.println(str);
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("학생정보를 불러오는데 실패");
				}

			}else if(menu.equals("3")) {

				System.out.println(">> === 삭제할 학생의 ID를 넣어주세요 0 입력시 메뉴.");
				System.out.println("학생 ID : ");
				String stuid = sc.nextLine();
				if(stuid.equals("0")) {
					continue;
				}
				try {
					int ab = dba.deleteData(stuid);
					if(ab>0) {
						System.out.println("성공을 하였습니다.");
					}else {
						System.out.println("입력에 실패하였씁니다");
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("DB연결에 실패하였습니다.");
				}

			} 
			else if (menu.equals("4")) {
				try {
					select.addAll(dba.selectUplist());
//					for(String str:select) {
//						System.out.println(str);
//					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("학생정보를 불러오는데 실패");
				}
				System.out.println("수정할 학생의  학번을 입력해주세요 >>>:");
				String stuid = sc.nextLine();
				System.out.println("변경 된 이름을 적어주세요:");
				String stuname = sc.nextLine();
				System.out.println("변경 된 점수을 적어주세요:");
				int score = Integer.parseInt(sc.nextLine());
			} else if (menu.equals("5")) {
				System.out.println("프로그램 종료합니다");
				System.exit(0);
			} else {
				System.out.println("메뉴를 확인해주세요");
			}

		}
	}
}
