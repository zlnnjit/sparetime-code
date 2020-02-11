package top.bcoder.algorithm.offercode;

/**
 * @author zln
 * @date 2020/2/10
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test4 {

    public static boolean Find(int target, int[][] array) {
        //条件判断
        if (array == null || array.length < 1 || array[0].length < 1) {
            return false;
        }

        //获取最左边的坐标
        int row = 0;
        int column = array[0].length - 1;

        while (row != array.length && column != -1) {
            if (array[row][column] == target) {
                return true;
            }
            if (target > array[row][column]) {
                row++;
            } else {
                column--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] target = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(Find(7, target));    // 要查找的数在数组中
        System.out.println(Find(5, target));    // 要查找的数不在数组中
        System.out.println(Find(1, target));    // 要查找的数是数组中最小的数字
        System.out.println(Find(15, target));   // 要查找的数是数组中最大的数字
        System.out.println(Find(0, target));    // 要查找的数比数组中最小的数字还小
        System.out.println(Find(16, target));   // 要查找的数比数组中最大的数字还大
        System.out.println(Find(16, target));   // 健壮性测试，输入空指针
    }
}
