package Client;

import java.net.Socket;

public class CMain {

	public static void main(String[] args) throws Exception {
		Socket withServer = null;
		Socket withServer2 = null;
		withServer = new Socket("10.0.0.127", 7777);
		withServer2 = new Socket("10.0.0.127",8888);
		System.out.println("�����Ƕ� ��Ʈ�ѹ� ����");
		new ClientChat(withServer, withServer2);
	}

}
