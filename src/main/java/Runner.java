import view.Menu;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.guestMenu();
    }
}
