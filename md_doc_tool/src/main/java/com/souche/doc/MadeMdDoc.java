package com.souche.doc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.souche.doc.model.DocContent;

public class MadeMdDoc implements Serializable {
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		String url = "/Users/" + SwingInput.getComputerName() + "/Desktop/MdDocument/MdDocument.md";
		//文档头
		Map<String, String> map = new HashMap<String, String>();
		MadeMdDoc.settingDocHead(url, map);
		//请求
		List<DocContent> reqList = ReadFile.getDocContentByPackageName("com/souche/doc/target/req");
		MadeMdDoc.settingReqParam(reqList, url, true);
		//响应
		List<DocContent> rspList = ReadFile.getDocContentByPackageName("com/souche/doc/target/rsp");
		MadeMdDoc.settingRspParam(rspList, url, true);
		//代码实例
		MadeMdDoc.settingDocCodeExample(url);
	}

	/**
	 * 请求文档头
	 * @return void
	 */
	public static void settingDocHead(String url, Map<String, String> map) {
		String docHead = MdHandle.docHead(map);
		// 把生成的markdown代码写入到系统剪贴板中
		MdHandle.writeLocalStrOne(docHead, url);
	}
	
	/**
	 * 请求文档头
	 * @return void
	 */
	public static void settingDocDubboHead(String url, Map<String, String> map) {
		String docHead = MdHandle.docDubboHead(map);
		// 把生成的markdown代码写入到系统剪贴板中
		MdHandle.writeLocalStrOne(docHead, url);
	}
	
	/**
	 * 请求文档头
	 * @return void
	 */
	public static void settingDocCodeExample(String url) {
		String docCodeExample = MdHandle.docCodeExample();
		// 把生成的markdown代码写入到系统剪贴板中
		MdHandle.writeLocalStrOne(docCodeExample, url);
	}
	
	/**
	 * 请求参数表格
	 * @param List<List<DocContent>> reqList
	 * @return void
	 */
	public static void settingReqFormParam(List<List<DocContent>> reqList, String url) {
		if (reqList == null || reqList.isEmpty()) {
			DocContent docContent = new DocContent("xxx", "xxx", "xxx", "xxx");
			List<DocContent> list = new ArrayList<DocContent>();
			list.add(docContent);
			settingReqParam(list, url, true);
		}else {
			for (int i = 0; i < reqList.size(); i++) {
				if (i == 0) {
					settingReqParam(reqList.get(i), url, true);
				}else {
					settingReqParam(reqList.get(i), url, false);
				}
			}
		}
	}
	
	/**
	 * 请求参数表格
	 * @param List<DocContent> list
	 * @return void
	 */
	public static void settingReqParam(List<DocContent> list, String url, Boolean isHead) {
			int cols = 4;
			int rows = list.size();
			String head = MdHandle.tableReqHead(cols, isHead);
			String style = MdHandle.tableStyle(cols);
			// 打印表格内容：
			String body = MdHandle.tableBody(cols, rows, list);
			System.out.println(head + style + body);
			// 把生成的markdown代码写入到系统剪贴板中
			MdHandle.writeLocalStrOne(head + style + body, url);
	}
	
	/**
	 * 返回参数表格
	 * @param List<List<DocContent>> rspList
	 * @return void
	 */
	public static void settingRspFormParam(List<List<DocContent>> rspList, String url) {
		if (rspList == null || rspList.isEmpty()) {
			DocContent docContent = new DocContent("xxx", "xxx", "xxx", "");
			List<DocContent> list = new ArrayList<DocContent>();
			list.add(docContent);
			settingRspParam(list, url, true);
		}else {
			for (int i = 0; i < rspList.size(); i++) {
				if (i == 0) {
					settingRspParam(rspList.get(i), url, true);
				}else {
					settingRspParam(rspList.get(i), url, false);
				}
			}
		}
	}
	
	/**
	 * 返回参数表格
	 * @param List<DocContent> list
	 * @return void
	 */
	public static void settingRspParam(List<DocContent> list, String url, Boolean isHead) {
		int cols = 4;
		int rows = list.size();
		String head = MdHandle.tableRspHead(cols, isHead);
		String style = MdHandle.tableStyle(cols);
		// 打印表格内容：
		String body = MdHandle.tableBody(cols, rows, list);
		System.out.println(head + style + body);
		// 把生成的markdown代码写入到系统剪贴板中
		MdHandle.writeLocalStrOne(head + style + body, url);
	}
	
}
