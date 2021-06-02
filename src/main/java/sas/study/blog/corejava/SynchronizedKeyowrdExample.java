package sas.study.blog.corejava;

public class SynchronizedKeyowrdExample {

    static int k = Integer.MAX_VALUE;

    synchronized static int getK() {
        return k;
    }

    synchronized static void setK(int k) {
        SynchronizedKeyowrdExample.k = k;
    }

    static int operate(int k1, int k2) {
        return k1 - k2;
    }
}
