public class test {
    public static void main(String[] args) {
        int k =3;
        int i = 0;
        System.out.println(k*(i++)%7);
        System.out.println(k*(i++)%7);
        System.out.println(k*(i++)%7);
        System.out.println(k*(i++)%7);
        System.out.println(k*(i++)%7);
        System.out.println(k*(i++)%7);
        System.out.println(k*(i++)%7);
        for(int j=0; j<7; j++) {
            System.out.println("----------------------");
            System.out.println(j);
            System.out.println((k+j)%7);
        }
        System.arraycopy(args, i, args, k, i);
    }
}
