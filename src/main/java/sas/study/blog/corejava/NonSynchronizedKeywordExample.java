package sas.study.blog.corejava;

public class NonSynchronizedKeywordExample {

    static int k = Integer.MAX_VALUE;

    static int getK() {
        return k;
    }

    static void setK(int k) {
        SynchronizedKeyowrdExample.k = k;
    }

    static int operate(int k1, int k2) {
        return k1 - k2;
    }

}
