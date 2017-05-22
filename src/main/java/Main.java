class Main {
    static int a = +4;
    static boolean b = true;

    public static void main(String[] args) {
        a = 2;
        boolean b = false;
        b = b && (a > 1);
        System.out.println(foo(1, 2));
    }

    static int foo(int a , int b){
        int c = +a + b * (-a - 1);
        return c;
    }
}