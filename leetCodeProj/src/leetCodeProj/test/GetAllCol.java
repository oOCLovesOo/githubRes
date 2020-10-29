package leetCodeProj.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAllCol {
		public static void main(String[] args) throws Exception {
			genColXLS();
		}
	
		public static void genColXLS() throws Exception {
			String filePath = "C:\\Users\\Administrator\\Desktop\\file\\mapper";
			List<File> fileMapperList =  getFiles(filePath);
			int fileIndex = 0;
			for (File file : fileMapperList) {
				String fileName = file.getName();
				StringBuffer buffer = new StringBuffer();
				BufferedReader bf = new BufferedReader(new FileReader(file.getPath()));
				String s = null;
				int index = 0;
				while((s=bf.readLine())!=null) {
					if(index <=3) {
						index++;
						continue;
					}
					if("</resultMap>".endsWith(s.trim())) {
						break;
					}
					buffer.append(s.trim()+"$");
					index++;
				}
				String str = buffer.toString();
				String[][] replaceRegular = {
						{"<[a-zA-Z]+ column=\"",""},
						{"\" property=\"","|"},
						{"\" jdbcType=\"[a-zA-Z]+\" />",""}
				};
				for (int i=0;i<replaceRegular.length;i++) {
					String regu = replaceRegular[i][0];
					String repChar = replaceRegular[i][1];
					str = str.replaceAll(regu, repChar);
				}
				String newStr = str.substring(0,str.length()-2);
				File excel = new File("D:\\BS\\WorkSpace\\ZJNXSJYZ\\shujuyizhi_common\\src\\com\\joyin\\util\\clUtil\\selectFile.xls");
				try {
//					Writabl
				}catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				fileIndex+=fileIndex;
			}
		}
	
		/**
	    * @Description
	    * @Date
	    */
	    public static List<File> getFiles(String path) {
	        List<File> files = new ArrayList<File>();
	        File file = new File(path);
	        File[] tempList = file.listFiles();

	        for (int i = 0; i < tempList.length; i++) {
	            if (tempList[i].isFile()) {
	                files.add(tempList[i]);
	            }
	            if (tempList[i].isDirectory()) {
	            }
	        }
	        return files;
	    }
}
