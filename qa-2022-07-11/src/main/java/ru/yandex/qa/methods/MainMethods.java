package ru.yandex.qa.methods;

public class MainMethods {

    public static void main(String[] args) {
        print();
        print("Как дела?");
        print(45);
        //print(null);

        System.out.println("--------------------");
        String begin = getBegin("Все нормик. Как сам?", 4);
        System.out.println(begin);

        System.out.println("--------------------");
        StringInfo beginAndEnd = getBeginAndEnd("Все нормик. Как сам?", 4);
        System.out.println(beginAndEnd.getBegin());
        System.out.println(beginAndEnd.getEnd());
    }

    private static String getBegin(String s, int i) {
        String substring = s.substring(0, i);
        return substring;
    }

    private static StringInfo getBeginAndEnd(String s, int i) {
        String begin = s.substring(0, i);
        String end = s.substring(s.length() - i, s.length());
        return new StringInfo(begin, end);
    }

    private static void print() {
        System.out.println("Привет!");
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static void print(Integer s) {
        System.out.println(s);
    }

    private static void print(Object s) {
        System.out.println(s);
    }

    public static class StringInfo {
        private String begin;
        private String end;

        public StringInfo(String begin, String end) {
            this.begin = begin;
            this.end = end;
        }

        public String getBegin() {
            return begin;
        }

        public void setBegin(String begin) {
            this.begin = begin;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "StringInfo{" +
                    "begin='" + begin + '\'' +
                    ", end='" + end + '\'' +
                    '}';
        }
    }
}
