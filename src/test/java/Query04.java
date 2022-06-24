import java.sql.*;


public class Query04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "XXXXXXXXXX");

        //Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");

        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Toplam Sütun Sayisi: " + rsmd.getColumnCount());

        System.out.println("1. Sütunu ismi: " + rsmd.getColumnName(1));
        System.out.println("2. Sütunu ismi: " + rsmd.getColumnName(2));
        System.out.println("3. Sütunu ismi: " + rsmd.getColumnName(3));
        System.out.println("4. Sütunu ismi: " + rsmd.getColumnName(4));

        System.out.println("===================================");

        System.out.println("1. Sütunun Data Tipi: " + rsmd.getColumnTypeName(1));
        System.out.println("2. Sütunun Data Tipi: " + rsmd.getColumnTypeName(2));
        System.out.println("3. Sütunun Data Tipi: " + rsmd.getColumnTypeName(3));
        System.out.println("4. Sütunun Data Tipi: " + rsmd.getColumnTypeName(4));

        System.out.println("Tablonun ismi: " + rsmd.getTableName(1));
        System.out.println("rsmd.getColumnDisplaySize() = " + rsmd.getColumnDisplaySize(1));
        System.out.println("rsmd.getCatalogName(1) = " + rsmd.getCatalogName(1));

        while (rs.next()){
            System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
        }

    }
}