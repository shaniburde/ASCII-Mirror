package asciimirror;


public class Main {
    public static void main(String[] args) {
        Main.start();
    }

    private static void start() {
        ASCIIMirror mirror = new ASCIIMirror();
        System.out.println("Input the file path:");
        System.out.println(mirror.getFilePath());
    }
}