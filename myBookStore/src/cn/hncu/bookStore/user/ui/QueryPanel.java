/*
 * QueryPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.hncu.bookStore.user.ui;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JFrame;

import cn.hncu.bookStore.common.UserTypeEnum;
import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.bookStore.user.vo.UserModel;
import cn.hncu.bookStore.user.vo.UserQueryModel;

/**
 * 
 * @author �º���
 *
 * @version 1.0
 */
public class QueryPanel extends javax.swing.JPanel {

	private JFrame mainFrame = null;

	/** Creates new form QueryPanel 
	 * @param mainFrame */
	public QueryPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initComponents();
		myInitData();
	}

	private void myInitData() {
		for(UserTypeEnum type:UserTypeEnum.values()){
			combType.addItem(type.getName());
		}
		
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		tfdName = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		tfdUuid = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		combType = new javax.swing.JComboBox();
		btnQuery = new javax.swing.JButton();
		btnBack = new javax.swing.JButton();

		setMinimumSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		jLabel1.setFont(new java.awt.Font("΢���ź�", 1, 48));
		jLabel1.setForeground(new java.awt.Color(204, 0, 0));
		jLabel1.setText("\u67e5\u627e\u7528\u6237");
		add(jLabel1);
		jLabel1.setBounds(250, 20, 230, 80);

		jLabel2.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel2.setText("\u7528\u6237\u7c7b\u578b:");
		add(jLabel2);
		jLabel2.setBounds(90, 310, 90, 30);

		tfdName.setFont(new java.awt.Font("Dialog", 1, 18));
		tfdName.setAutoscrolls(false);
		add(tfdName);
		tfdName.setBounds(180, 230, 140, 32);

		jLabel3.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel3.setText("uuid:");
		add(jLabel3);
		jLabel3.setBounds(120, 160, 50, 30);

		tfdUuid.setFont(new java.awt.Font("Dialog", 1, 12));
		add(tfdUuid);
		tfdUuid.setBounds(180, 160, 110, 30);

		jLabel4.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel4.setText("\u59d3\u540d:");
		add(jLabel4);
		jLabel4.setBounds(120, 230, 50, 30);

		combType.setFont(new java.awt.Font("Dialog", 1, 18));
		combType.setForeground(new java.awt.Color(51, 51, 255));
		combType.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "��ѡ��..." }));
		add(combType);
		combType.setBounds(180, 310, 160, 30);

		btnQuery.setFont(new java.awt.Font("Dialog", 1, 24));
		btnQuery.setForeground(new java.awt.Color(0, 204, 204));
		btnQuery.setText("\u67e5\u627e");
		btnQuery.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQueryActionPerformed(evt);
			}
		});
		add(btnQuery);
		btnQuery.setBounds(150, 440, 120, 60);

		btnBack.setFont(new java.awt.Font("Dialog", 1, 24));
		btnBack.setForeground(new java.awt.Color(0, 204, 204));
		btnBack.setText("\u8fd4\u56de");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});
		add(btnBack);
		btnBack.setBounds(520, 430, 120, 60);
	}// </editor-fold>
	//GEN-END:initComponents

	protected void btnQueryActionPerformed(ActionEvent evt) {
		//1�ռ�����
		String name = tfdName.getText();
		String uuid = tfdUuid.getText();
		
		int type =0;
		if(combType.getSelectedIndex()>0){
			type = UserTypeEnum.getTypeByName(combType.getSelectedItem().toString());
		}
		
		//2��֯����
		UserQueryModel uqm = new UserQueryModel();
		uqm.setName(name);
		uqm.setUuid(uuid);
		uqm.setType(type);
		
		//3�����߼���
		UserEbi ebi = UserEbiFactory.getUserEbi();
		List<UserModel> results = ebi.getbyCondition(uqm);
		
		//4���ص���ͬ�Ľ��ҳ��
		
		mainFrame.setContentPane(new ListPanel(mainFrame,results));
		mainFrame.validate();
		
	}

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
		back();
	}

	private void back() {
		mainFrame.setContentPane(new ListPanel(mainFrame));
		mainFrame.validate();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnQuery;
	private javax.swing.JComboBox combType;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField tfdName;
	private javax.swing.JTextField tfdUuid;
	// End of variables declaration//GEN-END:variables

}