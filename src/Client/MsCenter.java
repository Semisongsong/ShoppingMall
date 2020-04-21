package Client;

import java.net.Socket;
import java.util.ArrayList;

import Manager.Setting;

public class MsCenter {
	private String msg = null;
	private Login login = null;
	private Signup join = null;
	// private Signup join = Signup.getInstance();
	private static ClientChat ch = null;
	private Socket withClient = null;
	private Socket withClient2 = null;
	Setting sett = null;
	private static MsCenter mc = null;

	MsCenter(ClientChat ch) {
		this.ch = ch;
		new Login(ch);

	}

	public void start() {
		new Login(ch);
	}

	public static MsCenter getInstance() {
		if (mc == null) {
			mc = new MsCenter(ch);
		}
		return null;

	}

	public void checkMsg(String msg) {
		if (msg.contains("member")) {
			join = new Signup(withClient);
			join.membercheck(msg);

		} else if (msg.contains("login")) {
			login = new Login(ch);
			login.loginresult(msg);
		} else if (msg.contains("check")) {
			join = new Signup(withClient);
			join.idchk(msg);
			join.jbchk(msg);
		}
		// this.msg=msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String allMsg(String[] in) {
		ch = new ClientChat(withClient, withClient);
		ch.streamSet(in);
		return msg;

	}

	public ArrayList<String[]> list(String msg, Socket withClient) {
		// this.withClient2=withClient;
		// this.ch = ch;
		// Setting sett = new Setting(withClient,withClient2);
		// sett.init(list);
		System.out.println(msg);
		this.withClient = withClient;
		ch = new ClientChat(withClient, withClient2);
		ch.send(msg, withClient);
//		if(list!=null) {
//			return list;
//		}
//		return list;
		return null;
	}

	public ArrayList<String[]> back(Socket withServer2, ArrayList<String[]> list) {
		Setting sett = new Setting(withClient, withClient2);
		sett.init(list, withClient2);
		return list;

	}

}
