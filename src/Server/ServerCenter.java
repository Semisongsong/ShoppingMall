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

	public void select(Object objectMember, Object msg) {

		System.out.println("��������"+objectMember);
		System.out.println(msg);
		
//		check = (String[]) objectMember;
//		for (int i = 0; i < check.length; i++) {
//			if (check[check.length - 1].equals("login")) { // �α��� üũ
//				System.out.println(check[i]);
//				System.out.println("�̰� �α��� : " + check[check.length - 1]);
//			} else if (check[check.length - 1].equals("join")) { // ȸ������ üũ
//				System.out.println(check[i]);
//				System.out.println("�̰�ȸ������ : " + check[check.length - 1]);
//				dc.Insert(check);
//				break;
//			} else if (check[check.length - 1].equals("check")) { // ȸ������ üũ
//				System.out.println(check[i]);
//				System.out.println("�̰��ߺ�üũ����  : " + check[check.length - 1]);
//			}
			dc = new DAOCenter();
			dc.whichone(objectMember,msg);

		//}
		//String m = "member";
		// System.out.println(objectMember);

		//dc.whichone(objectMember, m);

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
