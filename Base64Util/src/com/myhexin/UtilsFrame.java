package com.myhexin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * @Company: 浙江核心同花顺网络信息股份有限公司
 * @Description: 工具图形界面类
 * @Auther: chenjiahao@myhexin.com
 * @Date: 2018年12月4日 下午1:21:04
 * @Version:
 */
public class UtilsFrame {
	
	public SimpleBase64Utils utils = new SimpleBase64Utils();
	
	public UtilsFrame() {
		JFrame jframe = new JFrame("Base64加解密工具");
		jframe.setSize(400, 600);
		jframe.setBackground(Color.WHITE);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		jframe.getContentPane().setLayout(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 输入标签和文字域
		JLabel inputLabel = new JLabel("Input:");
		inputLabel.setFont(new Font("Consolas",1,15));
		inputLabel.setBounds(30, 50, 80, 20);
		
		JTextArea input = new JTextArea();
		input.setBounds(30, 100, 300, 100);
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		input.setFont(new Font("Consolas",1,20));
		
		JScrollPane inputPane = new JScrollPane();
		inputPane.setBounds(30, 100, 300, 100);
		inputPane.setViewportView(input);
		
		// 输出标签和文字域
		JLabel outputLabel = new JLabel("Output:");
		outputLabel.setFont(new Font("Consolas",1,15));
		outputLabel.setBounds(30, 250, 80, 20);
		
		JTextArea output = new JTextArea();
		output.setBounds(30, 300, 300, 100);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setFont(new Font("Consolas",1,20));
		output.setEditable(false);
		
		JScrollPane outputPane = new JScrollPane();
		outputPane.setBounds(30, 300, 300, 100);
		outputPane.setViewportView(output);
		
		// 加密按钮
		JButton encodeBtn = new JButton("Encode");
		encodeBtn.setBounds(60, 500, 80, 30);
		encodeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = input.getText();
				output.setText(utils.getEncode(str));
			}
		});
		
		// 解密按钮
		JButton decodeBtn = new JButton("Decode");
		decodeBtn.setBounds(250, 500, 80, 30);
		decodeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = input.getText();
				output.setText(utils.getDecode(str));
			}
		});
		
		// 窗口绑定控件
		jframe.getContentPane().add(inputLabel);
		jframe.getContentPane().add(inputPane);
		jframe.getContentPane().add(outputLabel);
		jframe.getContentPane().add(outputPane);
		jframe.getContentPane().add(encodeBtn);
		jframe.getContentPane().add(decodeBtn);
	}

}
