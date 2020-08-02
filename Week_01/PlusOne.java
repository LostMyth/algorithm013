/**
 * @Auther: Lance.Lu
 * @Date: 2020/8/2 15:46
 * @Description:
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = ++digits[i] % 10;
            // 如果当前位置数字不为0直接返回。
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 执行到这里表示所有位置上的数都为0了，所以数组长度+1， 且第一位必为1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
