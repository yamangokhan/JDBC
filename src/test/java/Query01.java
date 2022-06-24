import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1- Driver Yükle
        Class.forName("com.mysql.jdbc.Driver");

        // 2- Bağlantı Oluştur
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "4511332Gy.");
        // okul : baglantı yapacagımız database'in ismi

        //3- Statement : SQL kdolarımızı yazmak için bir nesne oluştur
        Statement st = con.createStatement();

        //4- ResultSet : SQL sorgularımızı yazacağımız alan

        ResultSet veri = st.executeQuery("select * from ogrenciler");

        //5- sonucları al
// =============== 1. yol index kullanarak
        while (veri.next()) {
            //System.out.println(veri.getInt(1) + veri.getString(2) + veri.getString(3) + veri.getString(4));
            // 1., 2., 3. ve 4.sutundaki verileri while döngüsü ile al diyoruz
            //1. Sutun "okul no"
            //2. Sutun "ogrenci ismi"
            //3. Sutun "sınıf"
            //4. Sutun "cinsiyet"

//============= 2. yol sutun ismi kullanarak===========
            System.out.println(veri.getInt("okul_no") + veri.getString("ogrenci_ismi") + veri.getString("sinif") + veri.getString("cinsiyet"));
        }

        // 6 - Kapatma
        con.close();
        st.close();
        veri.close();
    }
}
