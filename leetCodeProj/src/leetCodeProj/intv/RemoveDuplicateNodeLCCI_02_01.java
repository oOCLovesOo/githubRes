package leetCodeProj.intv;

import java.util.HashMap;
import java.util.Map;

import leetCodeProj.util.ListNode;

public class RemoveDuplicateNodeLCCI_02_01 {
	public ListNode removeDuplicateNodes(ListNode head) {
		if (head==null || head.next==null) {
			return head;
		}
		ListNode preNode = null;
		ListNode nowNode = null;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		nowNode = head;
		while (true) {
			if (map.containsKey(nowNode.val)) {
				preNode.next = nowNode.next;
			} else {
				map.put(nowNode.val, 0);
				preNode = nowNode;

			}
			nowNode = nowNode.next;
			if (nowNode == null) {
				return head;
			}
		}
	}
}
