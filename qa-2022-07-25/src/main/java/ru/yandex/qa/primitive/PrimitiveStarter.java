package ru.yandex.qa.primitive;

import java.util.ArrayList;

public class PrimitiveStarter {

    public static void main(String[] args) {
        int i = 5;

        Integer i2 = 5;
        Integer i3 = new Integer(5);
        Integer i5 = Integer.valueOf(5);

        i = i5;
        i = i5.intValue();

        //ограничения
        //1) приминивы не могут быть null
        //i = getInteger();

        //2) приметив не может быть дженериком
        ArrayList<Integer> list = new ArrayList<>();
        //ArrayList<int> list2 = new ArrayList<>();

        //---------------------------------
        long start = System.currentTimeMillis();
        int i10 = 2;
        int i11 = 2;
        int i12;
        for (int j = 0; j < 1_000_000_000l; j++) {
            i12 = 110 + ((++i11) + 1);
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        Integer i20 = 2;
        Integer i21 = 2;
        Integer i22;
        for (int j = 0; j < 1_000_000_000l; j++) {
            i22 = i20 + ((++i21) + 1);
        }
        System.out.println(System.currentTimeMillis() - start);

        i21 =+ 3;
        i21 = ++i21;

        //------------------------

        int[] ints = new int[]{2, 3};
        int length = ints.length;
        int[] clone = ints.clone();
    }

    private static Integer getInteger() {
        //some logic
        return null;
    }
}
