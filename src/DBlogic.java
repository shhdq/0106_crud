import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBlogic {

    String DB = "jdbc:mysql://localhost:3306/0106-crud";
    String USER = "root";
    String PASS = "biskviits";

    // crud
    // insert
    public void insert() {
        try(Connection conn = DriverManager.getConnection(DB, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {

            String sql = "INSERT INTO users (email, password) VALUES ('t@t.lv', 'ttttt')";
            stmt.execute(sql);
            System.out.println("Dati ievadīti");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete
    public void delete() {

        try(Connection conn = DriverManager.getConnection(DB, USER, PASS);
            Statement stmt = conn.createStatement();) {

            String delete = "DELETE FROM users WHERE id = 1";
            stmt.execute(delete);
            System.out.println("Dati ir izdzēsti");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // update
    public void update() {
        try(Connection conn = DriverManager.getConnection(DB, USER, PASS);
            Statement stmt = conn.createStatement();) {

            String update = "UPDATE users SET email = 'rcs@rcs.lv' WHERE id = 2";
            stmt.execute(update);
            System.out.println("Dati ir atjaunoti");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // select
    public void select() {
        try(Connection conn = DriverManager.getConnection(DB, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, email, password FROM users");
            ) {

            while(rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("email: " + rs.getString("email"));
                System.out.println("password: " + rs.getString("password"));
                System.out.println("");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
