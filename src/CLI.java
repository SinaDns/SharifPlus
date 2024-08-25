import java.io.*;
import java.util.Scanner;


public class CLI {
    public static void noob() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Salam. Be Sharif+ Khosh Oomadid.");
        System.out.println("Baraye Khadamate Bishtar, Az Dastoorhayi Ke Dar HELP Oomade, Estefade Konid");
        System.out.println();
        System.out.println("Baraye Sakhte Account 1, Va Baraye Login 2 Ra Vared Konid. 3 Baraye Exit Ast.");



        User user1 = new Customer("custom", "custom");
        User user2 = new Management("admin", "admin");


        while (true) {

            int option = scan.nextInt();

            if (option == 1) {
                User.createUser(scan);
                System.out.println("Baraye Sakhte Account 1, Va Baraye Login 2 Ra Vared Konid. 3 Baraye Exit Ast.");
            }
            if (option == 2) {
                User.Login(scan);
            }
            if (option == 3) {
                break;
            }

        }



    }

}


