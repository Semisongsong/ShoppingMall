package Server;

import java.util.ArrayList;

import DB.DAOCenter;

public class ServerCenter {
	private ArrayList<ServerChat> sList = new ArrayList<>();
	private DAOCenter dc = DAOCenter.getInstance();
	private String[] check = null;
	ServerChat chat = null;
	//private static ServerCenter sc;

	public ServerCenter() {

	}

//	public static ServerCenter getInstance() {
//		if (sc == null) {
//			new ServerCenter();
//		}
//		return sc;
//	}

	public void addServerChat(ServerChat s) {
		this.sList.add(s);
	}

	public void select(Object objectMember) {

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
		dc.whichone(objectMember);

		// }
	}

	public void goSC(String msg) {
		System.out.println("����� �������;� ���� : "+msg);
		chat = new ServerChat(null, null);
		chat.send(msg);
	}

}
