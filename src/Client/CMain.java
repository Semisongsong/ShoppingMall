package Client;

import java.net.Socket;


public class CMain {

	public static void main(String[] args) throws Exception {
		Socket withServer = null;
		withServer = new Socket("1.247.118.32", 7777);
		System.out.println("�����Ƕ� ��Ʈ�ѹ� ����");
		new ClientChat(withServer);
	}

}
