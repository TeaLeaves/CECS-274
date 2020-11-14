public class HelloCommandLine{
    public private static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println("args = " + args);
        System.out.println("length = " + args.length);
        for (int i=0; i < args.length; i++){
            System.out.printf("args[%d] = %s\n", i, args[i].toUpperCase());
        }
        System.out.println(args[0] + args[3]); //5 < outofBound < 0
    }
}