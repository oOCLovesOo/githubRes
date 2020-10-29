package leetCodeProj.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import leetCodeProj.test.bean.ExcelLine;

public class ReadSeq {
		public static void main(String[] args) throws Exception {
			genColXLS();
		}
	
		public static void genColXLS() throws Exception {
			String filePath = "D:\\online2020\\数据移植文件2020\\数据移植(2020)\\增量移植(新)\\famsdb_dll_2020_01_06sc";
			List<File> fileMapperList =  getFiles(filePath);
			int fileIndex = 0;
			List<ExcelLine> list = new ArrayList<>();
			for (File file : fileMapperList) {
				String fileName = file.getName();
				if(!"famsdb_20200106.txt".equals(fileName)){
					continue;
				}
				StringBuffer buffer = new StringBuffer();
				BufferedReader bf = new BufferedReader(new FileReader(file.getPath()));
				String s = null;
				int index = 0;
				
				ExcelLine el = new ExcelLine();
				while((s=bf.readLine())!=null) {
					if(index%8==0) {//取序列名
						el.line1 = s;
					}
					if(index%8==1) {//取最小值和最大值
						el.line2 = s;
					}
					if(index%8==2) {//取初始值
						el.line3 = s;
					}
					if(index%8==3) {
						
					}
					if(index%8==4) {
						
					}
					if(index%8==5) {//取当前值
						el.line4 = s;
					}
					if(index%8==6) {
						
					}
					if(index%8==7) {
						list.add(el);
						el = new ExcelLine();
					}
					index++;
				}

				System.out.println("解析完毕");
				fileIndex+=fileIndex;
			}
	        FileWriter fw = new FileWriter("D:\\online2020\\数据移植文件2020\\数据移植(2020)\\增量移植(新)\\famsdb_dll_2020_01_06sc\\out.txt");
	        BufferedWriter bw = new BufferedWriter(fw);
	        for (int i = 0; i < list.size(); i++) {
	        	ExcelLine el = list.get(i);
	        	String str = el.line1+"]"+el.line2+"]"+el.line3+"]"+el.line4+"]";
	        	bw.write(str);
	        	bw.newLine();
	        	bw.flush();
	        }
	        bw.close();
	        fw.close();
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
