import java.sql.*;
import java.util.Scanner;

public class JdbcAdventure {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/soloaventyr?allowPublicKeyRetrieval=TRUE&useSSL=false&serverTimezone=UTC",
                        "jesper", "elev123");

        ) {
            Statement stmt = conn.createStatement();
            int target_id = 2;

            int story_id = 1;
            System.out.println(getStoryBody(stmt, story_id));

            while (target_id != 20) {
                String strSelect2 = "select target_id, description from links where story_id = " + story_id;
                System.out.println("The SQL statment is: " + strSelect2 + "\n");
                ResultSet rset2 = stmt.executeQuery(strSelect2);

                while (rset2.next()) {
                    int target_ids = rset2.getInt("target_id");
                    String description = rset2.getString("description");
                    System.out.println(target_ids + ": " + description);
                }

                Scanner in = new Scanner(System.in);
                target_id = in.nextInt();
                story_id = target_id;

                String strSelect3 = "select body from story where id = " + target_id;
                System.out.println("The SQL statment is: " + strSelect3 + "\n");
                ResultSet rset3 = stmt.executeQuery(strSelect3);

                while (rset3.next()) {
                    String body = rset3.getString("body");
                    System.out.println(body);
                }

            }

            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String getStoryBody(Statement stmt, int story_id) throws SQLException {
        String strSelect = "select body from story where id = " + story_id;
        System.out.println("This SQL statement is: " + strSelect + "\n");
        ResultSet rset = stmt.executeQuery(strSelect);

        System.out.println("Story body:");
        String body = "";
        while (rset.next()) {
            body = rset.getString("body");
            // System.out.println(body);
        }
        return body;
    }
}
