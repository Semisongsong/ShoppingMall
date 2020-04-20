package Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Manager.Setting;
import Manager.Shoppingmall;

public class Login extends JFrame implements ActionListener, Serializable {
	JPanel nP, cP, sP, eP;
	JLabel idLabel, pwLabel, joinlabel;
	JTextField idField, pwdField, loginField;
	JButton loginBtn, joinBtn;
	Socket client = null;
	MsCenter mc = null;
	Socket withClient = null;
	Socket withClient2 = null;
	private String msg;

	Login(Socket withClient) {
		super("�α���");
		this.withClient = withClient;
		createpanel();
		setClose();
	}

	private void createpanel() {
		this.setLayout(new BorderLayout());
		nP = new JPanel();
		nP.setBorder(new EmptyBorder(10, 10, 0, 10));
		idLabel = new JLabel("ID");
		nP.add(idLabel);

		// �ؽ�Ʈ �ʵ� �����
		idField = new JTextField(15);
		nP.add(idField);

		// center �г� �����
		cP = new JPanel();
		pwLabel = new JLabel("�� ȣ");
		pwdField = new JPasswordField(15);

		cP.add(pwLabel);
		cP.add(pwdField);
		// south �г� �����
		sP = new JPanel();
		loginBtn = new JButton("�α���");
		sP.add(loginBtn);

		eP = new JPanel();
		joinBtn = new JButton("ȸ������");
		sP.add(joinBtn);
		loginBtn.addActionListener(this);
		joinBtn.addActionListener(this);

		// �г� �����ӿ� �ֱ� ��ġ�� ����"".
		this.add(nP, "North");
		this.add(cP, "Center");
		this.add(sP, "South");
		this.add(eP, "East");

		// �� ����
		// this.setBackground(Color,blue);

		// ������ �����ֱ�
		this.setBounds(400, 500, 300, 200);

	}

	public void setClose() {
		// this.setVisible(false);
		// �ڵ����� �����Ը���
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		// true�� ȭ�鿡�� ��Ÿ���� false�� ȭ�鿡�� �������
		this.setVisible(true);
	}

	private void loginchk(String msg) {
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] check = { idField.getText(), pwdField.getText(), "login" };
					mc = new MsCenter(withClient, withClient2);
					mc.allMsg(check);
					// client.streamSet(check);
//					int go = loginresult(msg);
//					if (go == 1) {
//						JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
//						System.out.println("���θ����");
//					} else if (go == 5) {
//						JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
//						System.out.println("���ð��");
//					} else if (go == 10) {
//						JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵�ų� ��й�ȣ�� ���� �ʽ��ϴ�.");
//						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//						idField.setText("");
//						pwdField.setText("");
//					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		loginchk(msg);
		gosignup();
	}

	private void gosignup() {
		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Signup join = Signup.getInstance();
				new Signup(client);
			}

		});
	}

	public int loginresult(String msg) {
		if (msg.contains("login/yes/1")) {
			JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
			new Shoppingmall();
			System.out.println("���θ����");
			return 1;
		} else if (msg.contains("login/yes/5")) {
			JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
			new Setting(withClient,withClient2);
			System.out.println("���ð��");
			return 5;
		} else if (msg.contains("login/yes/10")) {
			JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵�ų� ��й�ȣ�� ���� �ʽ��ϴ�.");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			idField.setText("");
			pwdField.setText("");
			return 10;
		}
		return 0;
	}

}
