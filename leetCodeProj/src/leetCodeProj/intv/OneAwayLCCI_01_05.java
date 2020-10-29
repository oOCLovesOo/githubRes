package leetCodeProj.intv;

public class OneAwayLCCI_01_05 {
	public boolean oneEditAway(String first, String second) {
		if (first == null || second == null) {
			return false;
		}
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}

		// 正式判断
		if (first.length() == second.length()) {
			// 相等
			int count = 0;
			for(int i=0;i<first.length();i++) {
				if(first.charAt(i)!=second.charAt(i)) {
					count++;
					if(count>=2) {
						return false;
					}
				}
			}
			return true;

		} else {
			// 差一位
			if ((first.length() == 0 && second.length() == 1) || (first.length() == 1 && second.length() == 0)) {
				return true;
			}
			//找第一个不同点
			String str1 = null;
			String str2 = null;
			if(first.length()<second.length()) {
				str1 = second ;
				str2 = first;
			}else {
				str2 = second ;
				str1 = first;
				
			}
			int index = 0;
			int startFind = 0;
			for(int i=0;i<str1.length();i++) {//找不同
				if(startFind == 0) {
					if(i!=str1.length()-1) {
						if(str1.charAt(i)!=str2.charAt(index)) {
							startFind = 1;
							index--;
						}
					}else {
						return true;
					}
				}else {
					if(str1.charAt(i)!=str2.charAt(index)) {
						return false;
					}
				}
				
				index++;
			}
			return true;
		}

	}
	
	public static void main(String[] args) {
		System.out.println(new OneAwayLCCI_01_05().oneEditAway("pwle","pafe"));
	}
}
