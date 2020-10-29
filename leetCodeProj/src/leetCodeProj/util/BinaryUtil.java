package leetCodeProj.util;

public class BinaryUtil {

	/**
	 * 统计数字二进制情况下1的个数，位移法，支持负数（优先用这个）
	 */
	public int countNum3(int num) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((flag & num) != 0) {
				count++;
			}
			flag <<= 1;
		}
		return count;
	}

	/**
	 * 统计数字二进制情况下1的个数(-2147483647这时统计的不正确输出0)
	 */
	public int countNum(int num) {
		int x = num;
		x = (x & 0x55555555) + ((x & 0xaaaaaaaa) >> 1);
		x = (x & 0x33333333) + ((x & 0xcccccccc) >> 2);
		x = (x & 0x0f0f0f0f) + ((x & 0xf0f0f0f0) >> 4);
		x = (x & 0x00ff00ff) + ((x & 0xff00ff00) >> 8);
		x = (x & 0x0000ffff) + ((x & 0xffff0000) >> 16);
		return x;
	}

	/**
	 * 统计数字二进制情况下1的个数,位移法(不支持负数如-9)
	 */
	public int countNum2(int num) {
		int x = 0;
		while (num != 0) {
			x += num & 1;
			num >>= 1;
		}
		return x;
	}

}
