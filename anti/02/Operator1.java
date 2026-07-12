public class Operator1 {
    public static void main(String[] args) {
        /**
         * 条件演算子（?:）、優先順位が低い。ただし、優先順位によって発生するエラーは
         * ほぼほぼコンパイラで拾える
         * 今回だと（+）のほうが優先順位が高いのでかっこでくくらないと想定通りにならない
         */
        boolean multiple = true;
        // System.out.println("テスト1：" + multiple ? "成功" : "失敗");
        // OUT:適合な型: Stringをbooleanに変換できません:
        System.out.println("テスト2：" + (multiple ? "成功" : "失敗"));
        // OUT：テスト2：成功

        /**
         * エラーにならないけど、想定と異なる結果が返ってくるパターン
         */
        boolean flag = true;
        int a = 10, b = 20, c = 30;

        int x = flag ? a : b + c;
        System.out.println(x); // flag=true では 10
        // ここは flag ? a : (b + c) と解釈される
        // 意図が (flag ? a : b) + c なら結果が違う

        String s = flag ? "OK" : "NG" + a;
        System.out.println(s); // flag=true では "OK"
        // ここも flag ? "OK" : ("NG" + a) と解釈される
        // 意図が (flag ? "OK" : "NG") + a なら違う

        /**
         * 対策として、複雑な式の一部として条件式を使う場合は必ず括弧でかこう。
         * また、基本的には自分で計算式を書くより標準ライブラリのメソッドを使うようにする
         */

        // 文字列連結は String.format でまとめる
        // これなら "テスト1：" + (multiple ? "成功" : "失敗") の意図が明確になる
        String result1 = String.format("テスト1：%s", multiple ? "成功" : "失敗");
        System.out.println(result1);
        // OUT:テスト1：成功

        // 文字列の結合を標準ライブラリに委ねる
        // ここを "OK" : ("NG" + a) と誤解することを防ぐ
        String result2 = String.format("%s%d", flag ? "OK" : "NG", a);
        System.out.println(result2);
        // OUT:OK10

        // 数値の足し算は Integer.sum を使う
        // (flag ? a : b) + c という意図を明確にするため、条件式の結果を先に決める
        int sum = Integer.sum(flag ? a : b, c);
        System.out.println(sum);
        // OUT:40

        // 条件式の結果を先に取得してから Math.max などを使う
        // これで flag ? a : b が全体の一部として扱われることを保証する
        int selected = flag ? a : b;
        int y = Math.max(selected, c);
        System.out.println(y);
        // OUT:30

        // 文字列連結の別パターン
        // String.format を使うことで、+ の優先順位に惑わされずに結果を生成できる
        String message = String.format("%s %s", flag ? "結果" : "エラー", String.valueOf(a));
        System.out.println(message);
        // OUT:結果 10
    }
}
