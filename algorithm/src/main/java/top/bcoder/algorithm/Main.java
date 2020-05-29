package top.bcoder.algorithm;

import java.util.Scanner;

/**
 * @author zln
 * @date 2020/4/15
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String param = in.nextLine();
        String[] names = param.split(",");
        Boolean cherck = checkName(names);
        if (!cherck) {
            System.out.println("error.0001");
            return;
        }
        if (names.length == 1) {
            System.out.println(names[0]);
            return;
        }
        String result = names[0];
        for (int i = 1; i < names.length; i++) result = compare(names[i], result);
        System.out.println(result);
    }

    private static String compare(String name, String result) {
        int i = 0;
        while (i != name.length() && i != result.length()) {
            if ( name.charAt(i) > result.charAt(i) ) return result;
            if ( name.charAt(i) < result.charAt(i) ) return name;
            i++;
        }
        if (name.length() > result.length()) {
            return result;
        }else {
            return name;
        }
    }

    private static Boolean checkName(String[] names) {
        for (String name : names) {
            if (name.length() < 1 || name.charAt(0) < 'A' || name.charAt(0) > 'z') return false;
            for (int i = 1; i < name.length(); i++) if (name.charAt(i) < 'a' || name.charAt(i) > 'z') return false;
        }
        return true;
    }
}
