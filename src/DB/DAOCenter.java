package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Server.ServerCenter;

public class DAOCenter implements DAOInterface {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private String[] check;
//	private MemberDAO memDAO = null;
//	private ManagementDAO mgmtDAO = null;
//	private CartDAO cartDAO = null;
	private static DAOCenter DAOcenter;
	private static MemberDAO dao = MemberDAO.getInstance();
	String notice = "";
	ServerCenter sc = null;
	String msg="";

	private DAOCenter() {
		connect();
		if (conn != null) {
//			memDAO = MemberDAO.getInstance(conn);
//			mgmtDAO = ManagementDAO.getInstance(conn);
//			cartDAO = CartDAO.getInstance(conn);
		}
	}

	public static DAOCenter getInstance() {
		if (DAOcenter == null) {
			DAOcenter = new DAOCenter();
		}
		return DAOcenter;
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class load fail :" + e.getMessage());
		}
	}

	private void connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class load fail : " + e.getMessage());
		}
	}

	public void whichone(Object objectMember) {
		check = (String[]) objectMember;
		for (int i = 0; i < check.length; i++) {
			String notice = check[check.length - 1];
			if (notice.equals("login")) { // 로그인 체크
				System.out.println(check[i]);
				System.out.println("이건 로그인 : " + check[check.length - 1]);
			} else if (notice.equals("join")) { // 회원가입 체크
				//System.out.println("지금 여기인거니??"+check[i]);
				System.out.println("이건회원가입 : " + check[check.length - 1]);
				Insert(objectMember, notice);
				// dao.InsertMember(check);
				break;
			} else if (notice.equals("check")) { // 회원가입 체크
				System.out.println(check[i]);
				System.out.println("이건중복체크지롱  : " + check[check.length - 1]);
			}

		}

//		switch (notice) {
//
//		case "join":
//			MemberDAO dao = MemberDAO.getInstance();
//			dao.InsertMember(objectMember);
//			System.out.println("왔다");
//			break;
//		case "goods":
//			break;
//		case "cart":
//			break;
//		case "order":
//			break;
//		}

	}

	@Override
	public Boolean Insert(Object obj, String notice) {
		switch (notice) {

		case "join":
			boolean bl=dao.InsertMember(obj);
			if(bl==true) {
				msg = "yes";
			}else {
				msg = "no";
			}
			System.out.println("DAO에서 메세지 확인 : "+msg);
			sc= new ServerCenter();
			sc.goSC(msg);
			break;
		case "goods":
			break;
		case "cart":
			break;
		case "order":
			break;
		}
		return null;
	}

	@Override
	public Boolean Select(Object DTO) {
		return null;
	}

	@Override
	public Boolean Edit(Object DTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Delete(Object DTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Insert() {
		// TODO Auto-generated method stub
		return null;
	}



}
