package ru.yandex.qa.methods;

public class MainMethods {

    public static void main(String[] args) {
        print();
        print("Привет! Как дела?");
        print("Привет! Сколько тебе лет?");
        print("Привет! Мне ", 27);
        print(null);

        System.out.println("-------------------------");
        String begin = getBegin("Привет! Как дела?", 5);
        System.out.println(begin);

        System.out.println("-------------------------");
        StringInfo beginAndEnd = getBeginAndEnd("Привет! Как дела?", 5);
        System.out.println(beginAndEnd.getBegin());
        System.out.println(beginAndEnd.getEnd());
    }

    private static String getBegin(String s, int count) {
        String substring = s.substring(0, count);
        return substring;
    }

    private static StringInfo getBeginAndEnd(String s, int count) {
        String begin = s.substring(0, count);
        String end = s.substring(s.length() - count);
        return new StringInfo(begin, end);
    }

    private static void print(String s, int i) {
        System.out.printf("%s%s%n", s, i);
    }

    private static void print(String str) {
        System.out.println(str);
    }

    //прикол - java отдаст предпочтение более низкоуровнему классу string
    private static void print(Object obj) {
        System.out.println("Object " + obj);
    }

    private static void print() {
        System.out.println("Привет!");
    }

    private static class StringInfo {
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
