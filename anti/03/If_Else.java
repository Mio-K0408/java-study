public class If_Else {
    public static void main(String[] args){
        /**
         * 条件分岐において分岐が多くなるとelseが抜ける場合がある
         */
        int sample1 = 1;
        int ans = 0;
        int sample2 = -1;
        if(sample1<0){
            ans = 0;
        }else if(sample1>100){
            ans = 100;
        }
        // 1つ目の分岐でelseを入れないまま、別の分岐が始まっている。想定外の処理が走ってしまう可能性がある
        // ※排他的になっていればelseなくてもいい。
        if(sample2>0){
            ans = 1;
        }
        System.out.println(ans);

        /**
        * 変数を使って警告文を出すようにする
        * elseを記載しないと"The value of the local variable str is not used"と警告が出る
        */
        String str;
        if(sample1 < 0){
            str = getStr(sample1);
        }else if(sample1 > 100){
            str = getStr(sample1);
        }

        /**
        * 変数を使ってエラー文を出すようにする（finalをつける）
        * elseを記載しないで次の分岐を書くと"TThe final local variable str2 may already have been assigned"とコンパイルエラーが出る
        * あんまり好ましい書き方ではないので、IDEの機能で警告を出す設定にするほうが良いかもしれない
        */
        final String str2;
        if(sample1 < 0){
            str2 = getStr(sample1);
        }else if(sample1 > 100){
            str2 = getStr(sample1);
        }
        if(sample1 == 0){
            str2 = getStr(sample1);
        }
        
        /**
         * 呼び出し元で分岐するのではなく、呼び出される関数側で分岐を入れるほうがきれいになる
         */
    }
    public static String getStr(int sample){
        if(sample <0){
            return "Minus";
        }else if(sample > 100){
            return "Plus";
        }
        return "Other";
    }
}
