import java.util.*;

public class Utils {
    public static void strBanner(String title, int length, char bannerCharL, char bannerCharR) {
        System.out.println(strBanner2Str(title, length, bannerCharL, bannerCharR));
    }

    public static void strBanner(String title) {
        Utils.strBanner(title, 64, '-', '-');
    }

    public static String strBanner2Str(String title, int length, char bannerCharL, char bannerCharR) {
        int left = (length - title.length() - 2) / 2;
        int right = length - left - 2 - title.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < left; i++) {
            builder.append(bannerCharL);
        }
        builder.append(title.length() > 0 ? ' ' : bannerCharL);
        builder.append(title);
        builder.append(title.length() > 0 ? ' ' : bannerCharR);
        for (int i = 0; i < right; i++) {
            builder.append(bannerCharR);
        }
        return builder.toString();
    }

    public static class Box {
        public static class BoxInfo {
            char lEdgeChar;
            char rEdgeChar;

            public BoxInfo(char edge_l, char edge_r) {
                this.lEdgeChar = edge_l;
                this.rEdgeChar = edge_r;
            }
        }

        public static final int length = 72;
        public static boolean justPopFlag = false;// match pattern:pop(set to true)->push(split by newline)->print(set
                                                  // to false)

        public static List<BoxInfo> stack = new ArrayList<>();

        public static void print(String str) {
            print(str, ' ', ' ');
        }

        public static void print(String str, char innerSpaceCharL, char innerSpaceCharR) {
            justPopFlag = false;
            int indentOffset = (int) str.codePoints()
                    .filter(i -> Character.UnicodeScript.of(i) == Character.UnicodeScript.HAN
                            || Character.UnicodeScript.of(i) == Character.UnicodeScript.KATAKANA
                            || Character.UnicodeScript.of(i) == Character.UnicodeScript.HIRAGANA
                            || (Character.UnicodeScript.of(i) == Character.UnicodeScript.COMMON && i > 10000))
                    .count();
            int spaces = length - stack.size() * 4 - str.length() - indentOffset;

            StringBuilder builder = new StringBuilder();
            // left borders
            for (int i = 0; i < stack.size(); i++) {
                builder.append(stack.get(i).lEdgeChar);
                builder.append(i != stack.size() - 1 ? ' ' : innerSpaceCharL);
            }
            // content
            builder.append(str);
            for (int i = 0; i < spaces; i++) {
                builder.append(' ');
            }
            // right borders
            for (int i = stack.size() - 1; i >= 0; i--) {
                builder.append(i != stack.size() - 1 ? ' ' : innerSpaceCharR);
                builder.append(stack.get(i).rEdgeChar);
            }
            System.out.println(builder.toString());
        }

        public static void banner(String title, char l, char r) {
            print(strBanner2Str(title, length - stack.size() * 4, l, r));
        }

        public static void banner(String title) {
            banner(title, '-', '-');
        }

        public static void push(String title, char title_l, char title_r, char edge_l, char edge_r) {
            if (justPopFlag) {
                print(""); // print will set flag to false
            }
            stack.add(new BoxInfo(edge_l, edge_r));
            print(strBanner2Str(title, length - stack.size() * 4, title_l, title_r), title_l, title_r);
        }

        public static void push(String title) {
            push(title, '*', '*', '|', '|');
        }

        public static void pop(String title, char title_l, char title_r) {
            print(strBanner2Str(title, length - stack.size() * 4, title_l, title_r), title_l, title_r);
            if (stack.size() > 0)
                stack.remove(stack.size() - 1);
            justPopFlag = true;
        }

        public static void pop(String title) {
            pop(title, '*', '*');
        }
    }
}
