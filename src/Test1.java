public class Test1 {
    public static void main(String[] args) {
        String ss="ABCDEa123abc";
        String s1="ABCDFB123abc";
        String s2=new String("1111");
        String s3=new String("1111");
        System.out.println(ss.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        System.out.println("ss==s1"+(ss==s1));
        System.out.println("ss==s2"+(ss==s2));
        System.out.println("ss2==s3"+(s2==s3));
        char x[]= {'1','1','1','1'};
        System.out.println(x[0]+0);

    }
}
