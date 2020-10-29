package leetCodeProj.intv;

/**
 * 力扣:Exchange LCCI 05.07
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * @author CLoves
 *
 */
public class ExchangeLCCI_05_07 {
	/**
	 * 交换某个整数的奇数位和偶数位(二进制)
	 */
    public int exchangeBits(int num) {
    	return ((num&0x55555555)<<1)|((num&0xAAAAAAAA)>>1);
    }
}
