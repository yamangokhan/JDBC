import java.sql.*;

public class NewQuery {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1) ilgili Driver i yükle (tv nin fişini tak, başka alet çalışmasın ne çalışacagını bilsin)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2) Bağlantı olustur (uydu netflix sifrelerini girmeliyiz)

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "4511332Gy.");

        // 3) SQL komutları için bir statement nesnesi olustur. (her kanal için tv de kumanda uzerinden yer ayarlıyoruz.)
        Statement st = con.createStatement();

        // SQL ifadeleri yazılabilir ve çalıştırabiliriz kumanda da 1 e basarım TRT1 i açarım gibi
        ResultSet veri = st.executeQuery(" Select * from Payment;");

        // 5) Sonucları aldık ve işledik

        while (veri.next()) {

            System.out.println(veri.getString("Salary_date") + "  " + veri.getInt("Employee_ID"));
     }
        // 6 - Kapatma
        con.close();
        st.close();
        veri.close();
    }

}



