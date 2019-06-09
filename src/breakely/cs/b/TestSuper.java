package breakely.cs.b;


class Super{
    int x = 2;
    int f(){
        return 2;
    }
}

class Sub extends Super{
    int x = 4;
    int f(){
        return 4;
    }
}

public class TestSuper {
    public static void main(String[] args) {
       Sub sub = new Sub();
       Super supe =  sub;
       int a,b,c,d,a1,b1,c1,d1;
       a = supe.x;
       b = sub.x;
       c = sub.f();
       d = supe.f();
       a1 = ((Sub)supe).x;
       b1 = ((Super)sub).x;
       System.out.println(c);
       System.out.println(d);
       System.out.println(a1);
       System.out.println(b1);
    }
}
