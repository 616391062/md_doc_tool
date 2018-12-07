package com.souche.doc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.souche.doc.model.DocContent;

public class MdHandle implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 设置文档头参数头
	 * @return String
	 */
	public static String docHead(Map<String, String> map) {
		StringBuilder buf = new StringBuilder();
		// 标题行开始
		buf.append("\n");
		buf.append("> 负责人：" + (map.get("userText") != null ? map.get("userText"):""));
		buf.append("\n");
		buf.append("> \n");
		//项目名设置
		buf.append("> 项目名：" + (map.get("projectText") != null ? map.get("projectText"):""));
		buf.append("\n");
		buf.append("> \n");
		//邮箱设置
		buf.append("> 邮箱：" + (map.get("emailText") != null ? map.get("emailText"):""));
		buf.append("\n");
		buf.append("> \n");
		//换行
		buf = lineFeed(buf, 3);
		//接口名设置
		buf.append("#### 接口信息");
		buf.append("\n");
		buf.append("\n");
		//接口地址设置
		buf.append("> test_api:	" + (map.get("testUrlText") != null ? map.get("testUrlText"):""));
		buf.append("\n");
		buf.append("> \n");
		buf.append("> method: " + (map.get("methodText") != null ? map.get("methodText"):""));
		// 标题行结束
		buf = lineFeed(buf, 3);
		return buf.toString();
	}
	
	/**
	 * 设置文档头参数头
	 * @return String
	 */
	public static String docDubboHead(Map<String, String> map) {
		StringBuilder buf = new StringBuilder();
		// 标题行开始
		buf.append("\n");
		buf.append("> 负责人：" + (map.get("userText") != null ? map.get("userText"):""));
		buf.append("\n");
		buf.append("> \n");
		//项目名设置
		buf.append("> 项目名：" + (map.get("projectText") != null ? map.get("projectText"):""));
		buf.append("\n");
		buf.append("> \n");
		//邮箱设置
		buf.append("> 邮箱：" + (map.get("emailText") != null ? map.get("emailText"):""));
		buf.append("\n");
		buf.append("> \n");
		//换行
		buf = lineFeed(buf, 3);
		//接口名设置
		buf.append("#### 接口信息");
		buf.append("\n");
		buf.append("\n");
		//接口地址设置
		buf.append("> test_api:	" + (map.get("testUrlText") != null ? map.get("testUrlText"):""));
		buf.append("\n");
		buf.append("> \n");
		//换行
		buf = lineFeed(buf, 3);
		//项目依赖
		buf.append("### 依赖");
		buf.append("\n");
		buf.append("\n");
		buf.append("```xml");
		buf = lineFeed(buf, 4);
		buf.append("```");
		// 标题行结束
		buf = lineFeed(buf, 3);
		return buf.toString();
	}
	
	/**
	 * 设置代码实例
	 * @return String
	 */
	public static String docCodeExample() {
		StringBuilder buf = new StringBuilder();
		// 行开始
		buf = lineFeed(buf, 2);
		buf.append("#### 举例：");
		buf.append("\n");
		buf.append("```json");
		//项目名设置
		buf.append("\n");
		buf.append("请求参数：");
		buf = lineFeed(buf, 6);
		//邮箱设置
		buf.append("响应结果：");
		buf = lineFeed(buf, 6);
		buf.append("```");
		return buf.toString();
	}
	
	/**
	 * 设置换行
	 * @return String
	 */
	public static StringBuilder lineFeed(StringBuilder buf, int temp) {
		for (int i = 0; i < temp; i++) {
			buf.append("\n");
		}
		return buf;
	}
	
	/**
	 * 设置请求参数表格头
	 * @param int cols
	 * @return String
	 */
	public static String tableReqHead(int cols, Boolean isHead) {
		StringBuilder buf = new StringBuilder();
		if (isHead) {
			// 标题行开始
			buf.append("\n");
			buf.append("\n");
			buf.append("#### 请求参数");
			buf.append("\n");
		}
		List<String> asList = Arrays.asList("字段名", "字段类型", "说明", "是否必传");
		// 打印表格头
		for (int j = 1; j <= cols; j++) {
			buf.append("|" + asList.get(j - 1));
		}
		// 标题行结束
		buf.append("|\n");
		return buf.toString();
	}
	
	/**
	 * 设置返回参数表格头
	 * @param int cols
	 * @return String
	 */
	public static String tableRspHead(int cols, Boolean isHead) {
		StringBuilder buf = new StringBuilder();
		if (isHead) {
			// 标题行开始
			buf.append("\n");
			buf.append("\n");
			buf.append("#### 返回参数");
			buf.append("\n");
		}
		List<String> asList = Arrays.asList("字段名", "字段类型", "说明", "备注");
		// 打印表格头
		for (int j = 1; j <= cols; j++) {
			buf.append("|" + asList.get(j-1));
		}
		// 标题行结束
		buf.append("|\n");
		return buf.toString();
	}

	/**
	 * 生成默认格式的markdown表格对齐样式。
	 * @param cols 表格的列数
	 * @return markdown表格对齐样式语句字符串。
	 */
	public static String tableStyle(int cols) {
		StringBuilder buf = new StringBuilder();
		// 打印表格样式使用默认
		for (int j = 1; j <= cols; j++) {
			buf.append("|-");
		}
		// 标题行结束
		buf.append("|\n");
		return buf.toString();
	}

	/**
	 * 生成表格体markdown语句。
	 * @param cols 表格的列数
	 * @param rows 表格的行数
	 * @return 带编号的表格体markdown语句
	 */
	public static String tableBody(int cols, int rows, List<DocContent> list) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			for (int j = 1; j <= cols + 1; j++) {
				System.out.print("|");
				buf.append("|");
				if (j == 1) {
					buf.append(list.get(i).getFieldName());
				}
				if (j == 2) {
					buf.append(list.get(i).getFieldType());
				}
				if (j == 3) {
					buf.append(list.get(i).getDescription());
				}
				if (j == 4) {
					buf.append(list.get(i).getIsRequireOrRemark());
				}
			}
			buf.append("\n");
		}
		buf.append("\n");
		return buf.toString();
	}
	
	/**
	 * str:    要写入的文件内容  
	 * 例如:{\"id\":1777944995971746430,\"frName\":\"会议纪要\",\"createDate\":\"2018-7-11\"}
	 * path：      文件具体路径        例如:D:/111/2018/7/11/会议纪要.json
	 */
	public static void writeLocalStrOne(String str, String path) {
		try {
			File file = new File(path);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
			if (str != null && !"".equals(str)) {
				FileWriter fw = new FileWriter(file, true);
				// 写入本地文件中
				fw.write(str);
				fw.flush();
				fw.close();
				System.out.println("执行完毕!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * str:    要写入的文件内容  
	 * 例如:{\"id\":1777944995971746430,\"frName\":\"会议纪要\",\"createDate\":\"2018-7-11\"}
	 * path：      文件具体路径        例如:D:/111/2018/7/11/会议纪要.json
	 */
	public static void writeLocalStrTwo(String str, String path) {
		try {
			File file = new File(path);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
			if (str != null && !"".equals(str)) {
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				osw.write(str);
				osw.flush();
				osw.close();
				System.out.println("执行完毕!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
