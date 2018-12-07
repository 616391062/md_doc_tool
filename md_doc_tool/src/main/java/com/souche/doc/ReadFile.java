package com.souche.doc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.souche.doc.model.DocContent;

public class ReadFile implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 通过包名获取需要的数据集合
	 */
	public static List<DocContent> getDocContentByPackageName(String packageName) {
		//例如:com.souche.doc
		List<DocContent> docContents = new ArrayList<DocContent>();
		List<String> list = getFileNameByPackageName(packageName);
		if (list != null && !list.isEmpty()) {
			for (String fileName : list) {
				docContents.addAll(readFileByLines(fileName));
			}
		}
		return docContents;
	}
	
	/**
	 * 获取需要的数据集合
	 */
	public static List<List<DocContent>> getDocContent(String dirUrl) {
		List<List<DocContent>> result = new ArrayList<List<DocContent>>();
		List<String> list = getFileName(dirUrl);
		if (list != null && !list.isEmpty()) {
			for (String fileName : list) {
				List<DocContent> docContents = readFileByLines(fileName);
				if (docContents != null && !docContents.isEmpty()) {
					result.add(docContents);
				}
			}
		}
		return result;
	}
	
	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	public static List<DocContent> readFileByLines(String fileName) {
		List<DocContent> list = new ArrayList<DocContent>();
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			Boolean temp = false;
			String des = "";
			String isRequire = "";
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				if (tempString.contains("@ApiModelProperty")) {
					temp = true;
					String description = "";
					String isRequireOrRemark = "";
					int indexOfStart = tempString.indexOf("\"");
					if (tempString.contains("<必传>")) {
						isRequireOrRemark = "是";
						int indexOfEnd = tempString.indexOf("<必传>");
						description = tempString.substring(indexOfStart + 1, indexOfEnd).trim();
					}else if (tempString.contains("required") && tempString.contains("true")) {
						isRequireOrRemark = "是";
						int indexOfEnd = tempString.indexOf("\",");
						description = tempString.substring(indexOfStart + 1, indexOfEnd);
					}else {
						if (fileName.contains("target/req") || fileName.contains("MdDocument/Request")) {
							isRequireOrRemark = "否";
						}
						int indexOfEnd = tempString.indexOf("\")");
						description = tempString.substring(indexOfStart + 1, indexOfEnd);
					}
					des = description;
					isRequire = isRequireOrRemark;
				}
				if (temp == true && tempString.contains("private")) {
					DocContent docContent = new DocContent();
					temp = false;
					String trimString = tempString.trim();
					int indexOfStart = trimString.indexOf(" ");
					int indexOfCenter = trimString.indexOf(" ", 8);
					int indexOfEnd = trimString.indexOf(";");
					String fieldType = trimString.substring(indexOfStart, indexOfCenter);
					String fieldName = trimString.substring(indexOfCenter, indexOfEnd);
					//赋值
					docContent.setFieldName(fieldName);
					docContent.setFieldType(fieldType);
					docContent.setDescription(des);
					docContent.setIsRequireOrRemark(isRequire);
					list.add(docContent);
					des = "";
					isRequire = "";
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return list;
	}

	/**
	 * 通过包名获取包下面的文件名
	 */
	public static List<String> getFileNameByPackageName(String packageName) {
		List<String> list = new ArrayList<String>();
		// 设定为当前文件夹
		File directory = new File("");
		//包路劲
		String packageUrl = directory.getAbsolutePath() + "/src/main/java/" + packageName;
		File f = new File(packageUrl);
		if (!f.exists()) {
			System.out.println(packageUrl + " not exists");
			return null;
		}
		File fa[] = f.listFiles();
		File fs = null;
		for (int i = 0; i < fa.length; i++) {
			fs = fa[i];
			if (fs.isDirectory()) {
				System.out.println(fs.getName() + " [目录]");
				list.add(packageUrl + "/" + fs.getName());
			} else {
				System.out.println(fs.getName());
				list.add(packageUrl + "/" + fs.getName());
			}
		}
		return list;
	}
	
	/**
	 * 读取文件夹下面的文件名
	 */
	public static List<String> getFileName(String dirUrl) {
		List<String> list = new ArrayList<String>();
		File f = new File(dirUrl);
		if (!f.exists()) {
			System.out.println(dirUrl + " not exists");
			return null;
		}
		File fa[] = f.listFiles();
		File fs = null;
		for (int i = 0; i < fa.length; i++) {
			fs = fa[i];
			if (fs.isDirectory()) {
				System.out.println(fs.getName() + " [目录]");
				list.add(dirUrl + "/" + fs.getName());
			} else {
				System.out.println(fs.getName());
				list.add(dirUrl + "/" + fs.getName());
			}
		}
		return list;
	}
	
	/**
	 * 通过包名获取包下面的文件名
	 */
	public static List<String> getOnlyFileNameByPackageName(String packageName) {
		List<String> list = new ArrayList<String>();
		// 设定为当前文件夹
		File directory = new File(packageName);
		//包路劲
		String packageUrl = directory.getAbsolutePath();
		File f = new File(packageUrl);
		if (!f.exists()) {
			System.out.println(packageUrl + " not exists");
			return null;
		}
		File fa[] = f.listFiles();
		File fs = null;
		for (int i = 0; i < fa.length; i++) {
			fs = fa[i];
			if (fs.isDirectory()) {
				System.out.println(fs.getName() + " [目录]");
				list.add(fs.getName());
			} else {
				System.out.println(fs.getName());
				list.add(fs.getName());
			}
		}
		return list;
	}
	
	/**
     * 删除空目录
     * @param dir 将要删除的目录路径
     */
	public static void doDeleteEmptyDir(String dir) {
        boolean success = (new File(dir)).delete();
        if (success) {
            System.out.println("Successfully deleted empty directory: " + dir);
        } else {
            System.out.println("Failed to delete empty directory: " + dir);
        }
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
	public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
	
	/**
     * 删除单个文件
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
    
    /**
     * 创建文件夹
     * @param dirs
     * @return 成功返回true，否则返回false
     */
    public static boolean createDirs(String dirs) {
    	File file = new File(dirs);
        return file.mkdirs();
    }
    
	public static void main(String[] args) {
		//deleteFile("/Users/wangyulong/Desktop/MdDocument/Config/mdconfig.md");
		createDirs("/Users/wangyulong/Desktop/MdDocument/Config");
	}
}
