package top.bcoder.algorithm;

import org.apache.velocity.runtime.parser.CharStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zln
 * @date 2020/2/29
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        int m = Math.abs(n);
        while (m != 0) {
            res *= x;
            --m;
        }

        return n > 0 ? res : 1 / res;
    }
}