import java.sql.*;


public class Query02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "4511332Gy.");


        Statement st = con.createStatement();

        // soru : ogrenciler tablosundaki erkek ögrenci bilgilerini getirin

        ResultSet veri = st.executeQuery("select * from ogrenciler where cinsiyet = 'E'");
        while (veri.next()){
            System.out.println(veri.getInt(1) + " "
                    + veri.getString(2) + " "
                    + veri.getString(3) + " "
                    + veri.getString(4));
        }
        System.out.println("==============================================");

        // soru : ogrenciler tablosundaki 9. sınıf kız ögrencilerin bilgilerini getirin

        ResultSet veriIkınciSoru = st.executeQuery("select * from ogrenciler where sinif= '9' and cinsiyet='K'");
        while (veriIkınciSoru.next()){
            System.out.println(veriIkınciSoru.getInt(1) + " "
                    + veriIkınciSoru.getString(2) + " "
                    + veriIkınciSoru.getString(3) + " "
                    + veriIkınciSoru.getString(4));
        }
    }
}
