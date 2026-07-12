package other;
/**
 * Javaの String.valueOf(Object) の動作確認
 *
 * 学べること
 * ・null と "null" の違い
 * ・String.valueOf(Object) の動作
 * ・toString() との違い
 */
public class StringValueOfSample {

    public static void main(String[] args) {

        // ==========================================
        // 1. Object が null の場合
        // ==========================================
        Object obj = null;

        String result = String.valueOf(obj);

        System.out.println("=== Objectがnullの場合 ===");
        System.out.println(result);                  // null
        System.out.println(result == null);          // false
        System.out.println(result.equals("null"));   // true

        /*
         * ポイント
         * result は null ではない。
         * 「null」という文字列(String)が返される。
         */

        // ==========================================
        // 2. Object に値が入っている場合
        // ==========================================
        obj = 100;

        result = String.valueOf(obj);

        System.out.println("\n=== Objectに100が入っている場合 ===");
        System.out.println(result);                  // 100

        /*
         * 内部では obj.toString() が呼ばれる。
         */

        // ==========================================
        // 3. toString() との違い
        // ==========================================
        obj = null;

        System.out.println("\n=== toString()との違い ===");

        try {
            System.out.println(obj.toString());
        } catch (NullPointerException e) {
            System.out.println("toString() -> NullPointerException");
        }

        System.out.println(String.valueOf(obj));

        /*
         * toString()
         * → nullだと例外
         *
         * String.valueOf()
         * → "null" を返すので例外にならない
         */

        // ==========================================
        // 4. String型の null と "null" の違い
        // ==========================================

        String a = null;
        String b = "null";

        System.out.println("\n=== null と \"null\" の違い ===");

        System.out.println(a == null);          // true
        System.out.println(b == null);          // false
        System.out.println(b.equals("null"));   // true

        /*
         * a
         * → 参照が存在しない
         *
         * b
         * → "null"という4文字の文字列
         */

        // ==========================================
        // 5. String.valueOf(Object) の内部イメージ
        // ==========================================

        obj = null;

        String sample = (obj == null)
                ? "null"
                : obj.toString();

        System.out.println("\n=== 内部イメージ ===");
        System.out.println(sample);

        /*
         * String.valueOf(Object) は
         * おおよそ次のような実装になっている。
         *
         * public static String valueOf(Object obj) {
         *     return (obj == null) ? "null" : obj.toString();
         * }
         */
    }
}