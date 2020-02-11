package top.bcoder.algorithm.offercode;

/**
 * @author zln
 * @date 2020/2/10
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Test5 {
    //复制算法
//    public String replaceSpace(StringBuffer str) {
//        return str.toString().replace(" ", "%20");
//    }

    //复制算法二
//    public String replaceSpace(StringBuffer str) {
//        StringBuffer result = new StringBuffer();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) != ' ') {
//                result.append(str.charAt(i));
//            }else {
//                result.append("%20");
//            }
//        }
//        return result.toString();
//    }
    public static String replaceSpace(StringBuffer str) {
        //条件判断
        if (str == null || str.length() < 1) {
            return str.toString();
        }
        //原长度
        int oldLength = str.length();

        //遍历空格个数
        int spaceCount = 0;
        for (int i = 0; i < oldLength; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }


        if (spaceCount == 0) {
            //没有空格，直接返回str
            return str.toString();
        }

        //确定替换后的字符串长度
        int length = oldLength + spaceCount * 2;


        for (int index = str.length() - 1; index >= 0; index--) {
            if (str.charAt(index) == ' ') {
                str.deleteCharAt(index);
                str.insert(index, "0");
                str.insert(index, '2');
                str.insert(index, '%');
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello world");
        System.out.println(replaceSpace(s));
    }
}
