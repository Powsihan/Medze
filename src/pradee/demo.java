package pradee;


public class demo {
    public static void main(String[] args) {
        System.out.println("test1");
        PradeeList<Integer> n = new PradeeList<>();
        System.out.println("test2");
        n.add(5);
        System.out.println("test3");
        n.add(3);
        System.out.println("test3.5");
//        n.add(5);
        n.add(1);
        n.add(4);
        n.add(2);
        System.out.println("tes4");
        n.display();
        System.out.println("test");
//        System.out.println(n.search(5));
    }
}
