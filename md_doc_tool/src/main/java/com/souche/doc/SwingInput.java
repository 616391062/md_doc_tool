package com.souche.doc;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.lang3.StringUtils;
import com.souche.doc.model.DocContent;

public class SwingInput implements Serializable {
	private static final long serialVersionUID = 1L;

	public static void openWindows() {
		Integer frameWidth = 650;
		Integer frameHeight = 500;
		// 创建 JFrame 实例
		JFrame frame = new JFrame("接口文档生成工具");
		// Setting the width and height of frame
		frame.setSize(frameWidth, frameHeight);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (int)(toolkit.getScreenSize().getWidth() - frame.getWidth())/2;
		int y = (int)(toolkit.getScreenSize().getHeight( )- frame.getHeight())/2;
		frame.setLocation(x, y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * 创建面板，这个类似于 HTML 的 div 标签 我们可以创建多个面板并在 JFrame 中指定位置 面板中我们可以添加文本字段，按钮及其他组件。
		 */
		JPanel panel = new JPanel();
		// 添加面板
		frame.add(panel);
		/*
		 * 调用用户定义的方法并添加组件到面板
		 */
		placeComponents(panel, frame);

		// 设置界面可见
		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel, JFrame frame) {
		Integer labelBoundsX = 60;
		Integer labelBoundsY = 40;
		Integer labelBoundsWidth = 120;
		Integer labelBoundsHeight = 35;
		Integer labelIntervalY = 50;
		
		Integer textBoundsX = 130;
		Integer textBoundsY = labelBoundsY;
		Integer textBoundsWidth = 460;
		Integer textBoundsHeight = labelBoundsHeight;
		Integer textIntervalY = labelIntervalY;
		Integer buttonWidth = 80;
		
		String fontName = "Times New Roman";
		Integer fontType = Font.BOLD;
		Integer fontSize = 16;
		/*
		 * 布局部分我们这边不多做介绍 这边设置布局为 null
		 */
		panel.setLayout(null);
		//>>>>>----------------------------------------------------------------------------------<<<<<
		// 创建 JLabel
		JLabel userLabel = new JLabel("负 责 人");
		userLabel.setFont(new Font(fontName, fontType, fontSize));
		/*
		 * 这个方法定义了组件的位置。 setBounds(x, y, width, height) x 和 y 指定左上角的新位置，由 width 和 height指定新的大小。
		 */
		userLabel.setBounds(labelBoundsX, labelBoundsY + labelIntervalY * 0, labelBoundsWidth, labelBoundsHeight);
		panel.add(userLabel);
		/*
		 * 创建文本域用于用户输入
		 */
		final JTextField userText = new JTextField(20);
		userText.setFont(new Font(fontName, fontType, fontSize));
		userText.setBounds(textBoundsX, textBoundsY + textIntervalY * 0, textBoundsWidth, textBoundsHeight);
		panel.add(userText);

		//>>>>>----------------------------------------------------------------------------------<<<<<
		JLabel projectLabel = new JLabel("项 目 名");
		projectLabel.setFont(new Font(fontName, fontType, fontSize));
		projectLabel.setBounds(labelBoundsX, labelBoundsY + labelIntervalY * 1, labelBoundsWidth, labelBoundsHeight);
		panel.add(projectLabel);
		/*
		 * 这个类似用于输入的文本域 但是输入的信息会以点号代替，用于包含密码的安全性
		 */
		final JTextField projectText = new JTextField(20);
		projectText.setFont(new Font(fontName, fontType, fontSize));
		projectText.setBounds(textBoundsX, textBoundsY + textIntervalY * 1, textBoundsWidth, textBoundsHeight);
		panel.add(projectText);
		
		//>>>>>----------------------------------------------------------------------------------<<<<<
		JLabel emailLabel = new JLabel("邮     箱");
		emailLabel.setFont(new Font(fontName, fontType, fontSize));
		emailLabel.setBounds(labelBoundsX, labelBoundsY + labelIntervalY * 2, labelBoundsWidth, labelBoundsHeight);
		panel.add(emailLabel);
		/*
		 * 这个类似用于输入的文本域 但是输入的信息会以点号代替，用于包含密码的安全性
		 */
		final JTextField emailText = new JTextField(20);
		emailText.setFont(new Font(fontName, fontType, fontSize));
		emailText.setBounds(textBoundsX, textBoundsY + textIntervalY * 2, textBoundsWidth, textBoundsHeight);
		panel.add(emailText);

		//>>>>>----------------------------------------------------------------------------------<<<<<
		JLabel dubboLabel = new JLabel("dubbo");
		dubboLabel.setFont(new Font(fontName, fontType, fontSize));
		dubboLabel.setBounds(labelBoundsX, labelBoundsY + labelIntervalY * 3, labelBoundsWidth, labelBoundsHeight);
		panel.add(dubboLabel);
		//选择框
		final Boolean dubboFlag1 = false;
		final JRadioButton dubboJrb1 = new JRadioButton("YES", dubboFlag1); 
		dubboJrb1.setFont(new Font(fontName, fontType, fontSize));
		dubboJrb1.setBounds(textBoundsX, textBoundsY + textIntervalY * 3, buttonWidth, textBoundsHeight); 
		panel.add(dubboJrb1); 
		
		final Boolean dubboFlag2 = true;
		final JRadioButton dubboJrb2 = new JRadioButton("NO", dubboFlag2);
		dubboJrb2.setFont(new Font(fontName, fontType, fontSize));
		dubboJrb2.setBounds(textBoundsX + 110, textBoundsY + textIntervalY * 3, buttonWidth, textBoundsHeight); 
	    panel.add(dubboJrb2);

		//>>>>>----------------------------------------------------------------------------------<<<<<
		JLabel testUrlLabel = new JLabel("test_api");
		testUrlLabel.setFont(new Font(fontName, fontType, fontSize));
		testUrlLabel.setBounds(labelBoundsX, labelBoundsY + labelIntervalY * 4, labelBoundsWidth, labelBoundsHeight);
		panel.add(testUrlLabel);
		/*
		 * 这个类似用于输入的文本域 但是输入的信息会以点号代替，用于包含密码的安全性
		 */
		final JTextField testUrlText = new JTextField(20);
		testUrlText.setFont(new Font(fontName, fontType, fontSize));
		testUrlText.setBounds(textBoundsX, textBoundsY + textIntervalY * 4, textBoundsWidth, textBoundsHeight);
		panel.add(testUrlText);

		//>>>>>----------------------------------------------------------------------------------<<<<<
		JLabel docNameLabel = new JLabel("文 件 名");
		docNameLabel.setFont(new Font(fontName, fontType, fontSize));
		docNameLabel.setBounds(labelBoundsX, labelBoundsY + labelIntervalY * 5, labelBoundsWidth, labelBoundsHeight);
		panel.add(docNameLabel);
		/*
		 * 这个类似用于输入的文本域 但是输入的信息会以点号代替，用于包含密码的安全性
		 */
		final JTextField docNameText = new JTextField(20);
		docNameText.setFont(new Font(fontName, fontType, fontSize));
		docNameText.setBounds(textBoundsX, textBoundsY + textIntervalY * 5, textBoundsWidth, textBoundsHeight);
		panel.add(docNameText);
		
		//>>>>>----------------------------------------------------------------------------------<<<<<
		final JLabel methodLabel = new JLabel("method");
		methodLabel.setFont(new Font(fontName, fontType, fontSize));
		methodLabel.setBounds(labelBoundsX, labelBoundsY + labelIntervalY * 6, labelBoundsWidth, labelBoundsHeight);
		panel.add(methodLabel);
		
		//选择框
		final Boolean flag1 = true;
		final JRadioButton methodJrb1 = new JRadioButton("POST", flag1); 
		methodJrb1.setFont(new Font(fontName, fontType, fontSize));
		final Boolean flag2 = false;
		final JRadioButton methodJrb2 = new JRadioButton("GET", flag2);
		methodJrb2.setFont(new Font(fontName, fontType, fontSize));
		methodJrb1.setBounds(textBoundsX, textBoundsY + textIntervalY * 6, buttonWidth, textBoundsHeight); 
		panel.add(methodJrb1); 
		methodJrb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!methodJrb1.isSelected()) {
					methodJrb1.setSelected(true);
					if (methodJrb2.isSelected()) {
						methodJrb2.setSelected(false);
					}
				}else {
					methodJrb2.setSelected(false);
				}
			}
		});
		methodJrb2.setBounds(textBoundsX + 110, textBoundsY + textIntervalY * 6, buttonWidth, textBoundsHeight); 
	    panel.add(methodJrb2);
	    methodJrb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!methodJrb2.isSelected()) {
					methodJrb2.setSelected(true);
					if (methodJrb1.isSelected()) {
						methodJrb1.setSelected(false);
					}
				}else {
					methodJrb1.setSelected(false);
				}
			}
		});
	    
		//>>>>>----------------------------------------------------------------------------------<<<<<
	    //窗口打开事件
	    frame.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {
				String reqDirUrl = "/Users/" + getComputerName() + "/Desktop/MdDocument/Request";
				String rapDirUrl = "/Users/" + getComputerName() + "/Desktop/MdDocument/Rsponse";
				String configName = "/Users/" + getComputerName() + "/Desktop/MdDocument/Config/mdconfig.md";
				if (!(new File(reqDirUrl).exists())) {
					//创建初始化文件夹
					ReadFile.createDirs(reqDirUrl);
				}
				if (!(new File(rapDirUrl).exists())) {
					//创建初始化文件夹
					ReadFile.createDirs(rapDirUrl);
				}
				if (!(new File(configName).exists())) {
					//创建初始化文件夹
					MdHandle.writeLocalStrOne("", configName);
				}
				//读取配置文件
				Map<String, String> mdConfig = getMdConfig("/Users/" + SwingInput.getComputerName() + "/Desktop/MdDocument/Config", "mdconfig.md");
				if (StringUtils.isBlank(userText.getText())) {
					userText.setText(mdConfig.get("userText"));
				}
				if (StringUtils.isBlank(projectText.getText())) {
					projectText.setText(mdConfig.get("projectText"));
				}
				if (StringUtils.isBlank(emailText.getText())) {
					emailText.setText(mdConfig.get("emailText"));
				}
				if (StringUtils.isBlank(testUrlText.getText())) {
					testUrlText.setText(mdConfig.get("testUrlText"));
				}
				if (StringUtils.isBlank(docNameText.getText())) {
					docNameText.setText(mdConfig.get("docNameText"));
				}
			}
			
			public void windowIconified(WindowEvent e) {
			}
			public void windowDeiconified(WindowEvent e) {
			}
			public void windowDeactivated(WindowEvent e) {
			}
			public void windowClosing(WindowEvent e) {
			}
			public void windowClosed(WindowEvent e) {
			}
			public void windowActivated(WindowEvent e) {
			}
		});
	    
	    //>>>>>----------------------------------------------------------------------------------<<<<<
	    dubboJrb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dubboJrb1.isSelected()) {
					//设置method一栏不可见
					methodLabel.setVisible(false);
					methodJrb1.setVisible(false);
					methodJrb2.setVisible(false);
					//设置另一个按钮
					dubboJrb2.setSelected(false);
				}else {
					dubboJrb1.setSelected(true);
					if (dubboJrb2.isSelected()) {
						dubboJrb2.setSelected(false);
					}
				}
			}
		});
	    
	    //>>>>>----------------------------------------------------------------------------------<<<<<
	    dubboJrb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dubboJrb2.isSelected()) {
					//设置method一栏不可见
					methodLabel.setVisible(true);
					methodJrb1.setVisible(true);
					methodJrb2.setVisible(true);
					//设置method一栏默认值
					methodJrb1.setSelected(true);
					methodJrb2.setSelected(false);
					//设置另一个按钮
					dubboJrb1.setSelected(false);
				}else {
					dubboJrb2.setSelected(true);
					if (dubboJrb1.isSelected()) {
						dubboJrb1.setSelected(false);
					}
				}
			}
		});
		//>>>>>----------------------------------------------------------------------------------<<<<<
		// 创建确认按钮
		JButton confirmButton = new JButton("确   认");
		confirmButton.setFont(new Font(fontName, fontType, fontSize));
		confirmButton.setBounds(labelBoundsX - 10 + 300, labelBoundsY + labelIntervalY * 7 + 10, labelBoundsWidth - 40, labelBoundsHeight);
		panel.add(confirmButton);
		confirmButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "/Users/" + getComputerName() + "/Desktop/MdDocument/MdDocument.md";
				Map<String, String> map = new HashMap<String, String>();
				List<String> list = new ArrayList<String>();
				Boolean docDubboHeadFlag = false;
				map.put("userText", userText.getText());
				map.put("projectText", projectText.getText());
				map.put("emailText", emailText.getText());
				map.put("testUrlText", testUrlText.getText());
				map.put("docNameText", docNameText.getText());
				if (dubboJrb1.isSelected()) {
					docDubboHeadFlag = true;
				}else {
					if (methodJrb1.isSelected()) {
						map.put("methodText", methodJrb1.getText());
					}else {
						map.put("methodText", methodJrb2.getText());
					}
				}
				
				//读写配置文件
				String writeMdConfig = writeMdConfig(map);
				//先读文件
				try {
					List<String> configList = ReadFile.getOnlyFileNameByPackageName("/Users/" + getComputerName() + "/Desktop/MdDocument/Config");
					if (configList != null && !configList.isEmpty()) {
						//删除文件
						ReadFile.deleteFile("/Users/" + getComputerName() + "/Desktop/MdDocument/Config/mdconfig.md");
					}
				} catch (Exception e2) {
					//不存在,写配置文件
					System.out.println("文件不存在");
				}
				//写配置文件
				MdHandle.writeLocalStrOne(writeMdConfig, "/Users/" + getComputerName() + "/Desktop/MdDocument/Config/mdconfig.md");
				//读取文件夹下的接口文档
				try {
					list = ReadFile.getOnlyFileNameByPackageName("/Users/" + getComputerName() + "/Desktop/MdDocument");
				} catch (Exception e2) {
					System.out.println("还没有这个文件夹");
				}
				if (list != null && !list.isEmpty()) {
					int flag = 0;
					for (String onlyFileName : list) {
						if (onlyFileName.startsWith("MdDocument")) {
							flag += 1;
						}
					}
					if (flag != 0) {
						url = "/Users/" + getComputerName() + "/Desktop/MdDocument/MdDocument_" + flag + ".md";
					}else {
						url = "/Users/" + getComputerName() + "/Desktop/MdDocument/MdDocument.md";
					}
				}
				if (StringUtils.isNotBlank(map.get("docNameText"))) {
					if (list != null && !list.isEmpty()) {
						int temp = 0;
						for (String onlyFileName : list) {
							if (onlyFileName.startsWith(map.get("docNameText"))) {
								temp += 1;
							}
						}
						if (temp != 0) {
							url = "/Users/" + getComputerName() + "/Desktop/MdDocument/" + map.get("docNameText") + "_" + temp + ".md";
						}else {
							url = "/Users/" + getComputerName() + "/Desktop/MdDocument/" + map.get("docNameText") + ".md";
						}
					}
				}
				//文档头
				if (docDubboHeadFlag) {
					//dubbo接口文档头
					MadeMdDoc.settingDocDubboHead(url, map);
				}else {
					//普通接口文档头
					MadeMdDoc.settingDocHead(url, map);
				}
				//请求
				List<List<DocContent>> reqList = ReadFile.getDocContent("/Users/" + getComputerName() + "/Desktop/MdDocument/Request");
				MadeMdDoc.settingReqFormParam(reqList, url);
				//响应
				List<List<DocContent>> rspList = ReadFile.getDocContent("/Users/" + getComputerName() + "/Desktop/MdDocument/Rsponse");
				MadeMdDoc.settingRspFormParam(rspList, url);
				//代码实例
				MadeMdDoc.settingDocCodeExample(url);
			}
		});
		
		// 创建退出按钮
		JButton quitButton = new JButton("退   出");
		quitButton.setFont(new Font(fontName, fontType, fontSize));
		quitButton.setBounds(labelBoundsX + 150 + 300, labelBoundsY + labelIntervalY * 7 + 10, labelBoundsWidth - 40, labelBoundsHeight);
		panel.add(quitButton);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	private static Map<String, String> getMdConfig(String dirUrl, String onlyFileName) {
		Map<String, String> map = new HashMap<String, String>();
		//读取文件夹下的初始化配置信息
		try {
			//"/Users/wangyulong/Desktop/MdDocument/Config"
			List<String> readMdConfig = ReadFile.getOnlyFileNameByPackageName(dirUrl);
			if (readMdConfig != null && !readMdConfig.isEmpty()) {
				for (String fileName : readMdConfig) {
					if (fileName.equals(onlyFileName)) {
						File file = new File(dirUrl + "/" + fileName);
						BufferedReader reader = null;
						try {
							reader = new BufferedReader(new FileReader(file));
							String tempString = null;
							// 一次读入一行，直到读入null为文件结束
							while ((tempString = reader.readLine()) != null) {
								map = getTargetValue(map, tempString, "userText");
								map = getTargetValue(map, tempString, "projectText");
								map = getTargetValue(map, tempString, "emailText");
								map = getTargetValue(map, tempString, "testUrlText");
								map = getTargetValue(map, tempString, "docNameText");
							}
							reader.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						} finally {
							if (reader != null) {
								try {
									reader.close();
								} catch (IOException e2) {
									e2.printStackTrace();
								}
							}
						}
					}
				}
			}
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return map;
	}

	private static Map<String, String> getTargetValue(Map<String, String> map, String tempString, String targetSource) {
		if (tempString.trim().startsWith(targetSource)) {
			String[] split = tempString.trim().split("<=>");
			for (int i = 0; i < split.length; i++) {
				if (!split[i].equals(targetSource)) {
					map.put(targetSource, split[i]);
				}
			}
		}
		return map;
	}
	
	public static String writeMdConfig(Map<String, String> map) {
		StringBuilder buf = new StringBuilder();
		// 开始
		buf.append("userText<=>" + map.get("userText"));
		buf.append("\n");
		buf.append("projectText<=>" + map.get("projectText"));
		buf.append("\n");
		buf.append("emailText<=>" + map.get("emailText"));
		buf.append("\n");
		buf.append("testUrlText<=>" + map.get("testUrlText"));
		buf.append("\n");
		buf.append("docNameText<=>" + map.get("docNameText"));
		return buf.toString();
	}
	
	public static String getComputerName() {
		///Users/wangyulong
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
		String desktopPath = desktopDir.getAbsolutePath();
		return desktopPath.trim().substring(7);
	}
	
}
