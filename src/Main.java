import java.io.*;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        try {
            Date date = new Date();
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("The app just got launched at: " + date);

            Storage.setIngredients();
            writer.write("\n Ingredients were set at:" + date);

            int cnt = 1;
            try {
                File myObj = new File("input.txt");
                Scanner myReader = new Scanner(myObj);

                while (myReader.hasNextLine()) {

                    User user = new Management("admin1", "admin1");

                    for (int i = 0; i < 2; i++) {
                        String data = myReader.nextLine();
                        if (cnt == 1) {
                            user.Username = data;
                            cnt++;
                        }
                        else if (cnt == 2) {
                            user.setPassword(data);
                            User.users.add(user);
                            cnt = 1;
                        }
                    }

                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            writer.close();

            CLI.noob();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}