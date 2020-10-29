package leetCodeProj.test;

import java.util.ArrayList;
import java.util.List;

import leetCodeProj.dto.AssetTargetDb;

public class Test3 {
	public static void main(String[] args) {
		List<AssetTargetDb> resultList = new ArrayList<AssetTargetDb>();
		AssetTargetDb  va = new AssetTargetDb();
		
		for (int i = 0; i < 3; i++) {
			AssetTargetDb vi = va;
			resultList.add(vi);
		}
		
		System.out.println("list大小："+resultList.size());
		for (int i = 0; i < 3; i++) {
			System.out.println("对象"+i+"地址："+resultList.get(i));
		}
		
	}

}
