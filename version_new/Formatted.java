package version_new;

public class Formatted {
    public static void main(String[] args) {
        String name = null, message = "";
        // 14以前
        message = String.format("Hello %s", name);
        // 15
        message = "Hello %s".formatted(name);
        System.out.println(message);
        // name=null→OUT:Hello null
        // null以外（空文字含む）→OUT:Hello

        message =  "Value: %s".formatted(name != null ? name : "(unknown)");
        System.out.println(message);
        // name=null→OUT:Value: (unknown)
        // null以外（空文字含む）→OUT:Value: 
    }
}
