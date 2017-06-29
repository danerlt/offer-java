package offer;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @describute 題目描述：
 * 在一个二维数组中,每一行都按照从到右递增的顺序,
 * 每一列都按照从上到下递增的顺序排序.请完成一个函数,输入
 * 这样的一个二维数组和一个数组中,是否含有该整数.
 * <p>
 * 解题思路:
 * number从左下角开始,又三种可能的情况:
 * 1.number == target,这种情况直接返回true;
 * 2.number < target,那么target的范围不可能number的这一列,
 * 就在number这一列的右边去找,然后将number的值设为number右边的数,再次比较和target比较
 * 3.number > target,那么target的范围不可能number的这一行,
 * 就在number这一行的上边去找,然后将number的值设为number上边的数,再次比较和target比较
 * Created by danerlt on 17-6-28.
 */
public class Example03 {
    public boolean hasNumber(int[][] arr, int target) {
        boolean found = false;
        int rows = arr.length;
        int columns = arr[0].length;
        if (arr != null && rows > 0 && columns > 0) {
            int row = rows - 1;
            int column = 0;

            while (row >= 0 && column < columns) {
                int number = arr[row][column];//起始位置为左下角的值.
                if (number == target) {
                    found = true;
                    break;
                } else if (number < target) {
                    ++column;
                } else {
                    --row;
                }
            }
        }
        return found;
    }
    @Test
    public void testHasNumber () {
        int[][] arr = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        assertTrue(hasNumber(arr, 15));
    }

    @Test
    public void testHasNotNumber () {
        int[][] arr = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        assertFalse(hasNumber(arr, 5));
    }
}