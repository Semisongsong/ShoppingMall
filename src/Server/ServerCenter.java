package Server;

import java.net.Socket;
import java.util.ArrayList;

import DB.DAOCenter;

public class ServerCenter {
	private ArrayList<ServerChat> sList = new ArrayList<>();
	private DAOCenter dc = DAOCenter.getInstance();
	private String[] check = null;
	private ServerChat chat = null;
	private Socket withClient = null;
	private Socket withClient2 = null;
	// private static ServerCenter sc;

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

	public void select(Object objectMember, Socket withClient, Socket withClient2) {
		chat = chat;
		this.withClient = withClient;
		this.withClient2 = withClient2;
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
//			} else if (check[check.length - 1].equals("check")) { // ���̵� �ߺ� üũ
//				System.out.println(check[i]);
//				System.out.println("�̰��ߺ�üũ����  : " + check[check.length - 1]);
//			}
		dc.whichone(objectMember, withClient, withClient2);
		// }
	}

	public void select(String msg, Socket withClient, Socket withClient2) {
		this.withClient = withClient;
		this.withClient2 = withClient2;
		dc.list(msg,withClient2);
		//ArrayList<String[]> list = dc.list();
		//goSC2(list,withClient2);
	}

	public void goSC(String msg, Socket withClient) {
		System.out.println("����� �������;� ���� : " + msg);
		chat = new ServerChat(withClient, withClient2, null);
		chat.send(msg, withClient);
	}

	public void goSC2(ArrayList<String[]> list, Socket withClient) {
		this.withClient2=withClient;
		System.out.println("����� �������;� ���� ����Ʈ�� �Ѿ�Դ�?? : " + list);
		chat = new ServerChat(withClient, withClient2, null);
		chat.send2(list, withClient2);
	}

}
