package leetCodeProj.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] agrs) {
		List<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
		cartList.add(new ShoppingCart("小明的购物车", "剃须刀"));
		cartList.add(new ShoppingCart("小明的购物车", "大菠萝"));
		cartList.add(new ShoppingCart("小红的购物车", "大香蕉"));
		cartList.add(new ShoppingCart(null, "赖美云同款T恤"));
		//按照购物车名进行分组
		Map<String,List<ShoppingCart>> cartMap = makeEntityListMap(cartList,"getCartName");
		//打印结果
		for(String key:cartMap.keySet()) {
			System.out.print(key+":"+"{");
			for(ShoppingCart sc:(List<ShoppingCart>)cartMap.get(key)) {
				System.out.print(sc.getGoods()+"|");
			}
			System.out.println("}");
		}
		
		cartList.stream().collect(Collectors.groupingBy(ShoppingCart::getCartName));
	}

    /**
     * 按给定字段分组(支持null键分组)
     * list转HashMap<key,list>
     * @param list 被分组List
     * @param getterName key的字段getter方法
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <K, V> Map<K, List<V>> makeEntityListMap(List<V> list, String getterName) {
        Map<K, List<V>> map = new HashMap<K, List<V>>();
        if(list == null || list.size() == 0) {
            return map;
        }
        try {
            Method getter = list.get(0).getClass().getMethod(getterName);
            for (V item : list) {
            	K key = null;
                if(getter.invoke(item)!=null) {
                    key = (K) getter.invoke(item);
                }
                List<V> groupList = map.get(key);
                if (groupList == null) {
                    groupList = new ArrayList<V>();
                    map.put(key, groupList);
                }
                groupList.add(item);
            }
        } catch (Exception e) {
            return map;
        }
        return map;
    }

    
	static class ShoppingCart{
		//购物车名称
		private String cartName="";
		//商品
		private String goods="";
		
		ShoppingCart(String cartName,String goods){
			this.cartName = cartName;
			this.goods = goods;
		}

		public String getCartName() {
			return cartName;
		}

		public void setCartName(String cartName) {
			this.cartName = cartName;
		}

		public String getGoods() {
			return goods;
		}

		public void setGoods(String goods) {
			this.goods = goods;
		}
        
	}

}
