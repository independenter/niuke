package base;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;

/**
 * <p>
 *
 * @author independenter
 * @since
 */
public class Arrays {

    public static int[] getArrays(int len){
        int reuslt[] = new int[len];
        for (int i = 0; i < len; i++) {
            reuslt[i] = RandomUtil.randomInt(0,len);
        }
        return reuslt;
    }
}
