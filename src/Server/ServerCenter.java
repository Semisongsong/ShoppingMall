package Server;

import java.util.ArrayList;

import DB.DAOCenter;

public class ServerCenter {
	private ArrayList<ServerChat> sList = new ArrayList<>();
	private DAOCenter dc = new DAOCenter();
	private String[] check = null;

	public void addServerChat(ServerChat s) {
		this.sList.add(s);
	}

	public void select(Object objectMember,String mm) {

		System.out.println("서버센터"+objectMember);

		check = (String[]) objectMember;
		for (int i = 0; i < check.length; i++) {
			if (check[check.length - 1].equals("login")) { // 로그인 체크
				System.out.println(check[i]);
				System.out.println("이건 로그인 : " + check[check.length - 1]);
			} else if (check[check.length - 1].equals("join")) { // 회원가입 체크
				System.out.println(check[i]);
				System.out.println("이건회원가입 : " + check[check.length - 1]);
				dc.Insert(check);
				break;
			} else if (check[check.length - 1].equals("check")) { // 회원가입 체크
				System.out.println(check[i]);
				System.out.println("이건중복체크지롱  : " + check[check.length - 1]);
			}
			//dc = new DAOCenter();
			//dc.Select(check);

		}
		String m = "member";
		// System.out.println(objectMember);

		dc.whichone(objectMember, m);

//			      Object Object_Array[] = new Object[100];
//
//			      String String_Array[] = Arrays.copyOf(Object_Array, Object_Array.length, String[].class);
//			      for (int i = 0; i < String_Array.length; i++) {
//			         String_Array[i] = Object_Array[i].toString();
//			         System.out.println(String_Array[i]);
//			      }
//			   }
	}

}
