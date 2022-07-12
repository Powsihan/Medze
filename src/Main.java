public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.print("" +
                " \t\t\t#             #\n" +
                " \t\t\t##           ## \t######## \t#######   \t######## \t########\n" +
                " \t\t\t###         ### \t##       \t##     ## \t     ##  \t##\n" +
                " \t\t\t#####     ##### \t##       \t##     ## \t    ##   \t##\n" +
                " \t\t\t##  ##   ##  ## \t######   \t##     ## \t   ##    \t######\n" +
                " \t\t\t##    ###    ## \t##       \t##     ## \t  ##     \t##\n" +
                " \t\t\t##     #     ## \t##       \t##     ## \t ##      \t##\n" +
                " \t # #######           ## \t######## \t#######   \t######## \t########\n"+
                "\t\t\t             ##                                       \n"+
                "       \t\t\t         ");Main.loarding();System.out.print(" UWU ");Main.loarding();

    }
    public static void loarding() throws InterruptedException {
        for (int i = 0; i < 24; i++)
        {
            System.out.print("#");
            Thread.sleep(100);
        }
    }
}