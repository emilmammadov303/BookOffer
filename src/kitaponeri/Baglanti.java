package kitaponeri;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import static java.util.Map.Entry.comparingByValue;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toMap;

public class Baglanti {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DOMAIN_NAME = "localhost";
    static final String DB_NAME = "kitap";
    static final String DB_URL = "jdbc:mysql://" + DOMAIN_NAME + "/" + DB_NAME;
    static final String USER = "root";
    static final String PASS = "";
    
    public boolean Login(String username,String password){
            boolean isThere = false;
        try {
            Connection conn = null;
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM `bx_users` u WHERE u.username='"+username+"' and u.password='"+password+"'");
            
            int recordCount =0;
            while(result.next())
            {
                recordCount++;
            }
            
            if(recordCount == 0){
                isThere = false;
            }else{
                isThere = true;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isThere;
    }
    
    public String[] selectPhoto(String sql,int sayfa) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        String[] imageS = new String[30];
        
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();            
            
            rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                for(int i=sayfa*10-9;i<=sayfa*10;i++){
                   if(rs.getRow() == i){
                       imageS[i-sayfa*10+9] = rs.getString("Image_URL_M");
                       imageS[i-sayfa*10+19] = rs.getString("Book_Title");
                       imageS[i-sayfa*10+29] = rs.getString("ISBN");
                System.out.println(rs.getString("Image_URL_S"));
                } 
                }
                
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        return imageS;
    }
    
    public void selectBook(ArrayList<String> list) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        String listEleman = "";
        
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            
            
            rs = stmt.executeQuery("Select * from bx_books");
            
            while(rs.next())
            {
                listEleman = "";
                listEleman = rs.getString("ISBN") + "     " + rs.getString("Book_Title") + "    " + 
                "[" + rs.getString("Book_Author") + "]";
                list.add(listEleman);  
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
    }
    
    public void selectUser(ArrayList<String> list) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        String listEleman = "";
        
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            
            
            rs = stmt.executeQuery("Select * from bx_users");
            
            while(rs.next())
            {
                listEleman = "";
                listEleman = rs.getString("User_ID") + "     " + rs.getString("username") + "    " + 
                "[" + rs.getString("password") + "]    " + rs.getString("Location") + "    " + rs.getString("Age");
                list.add(listEleman);  
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
    }
    
    public void update(String sql){
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();
            
            
            int result = stmt.executeUpdate(sql);
           
            if(result != -1)
            {  
                System.out.println("Veri Guncellendi");
            }
            
            stmt.close();
            conn.close();

        } catch (SQLException se) {se.printStackTrace();} 
          catch (Exception e) {e.printStackTrace();}
    }
    
    public int selectUserID(String username) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("Select User_ID from bx_users where username='" + username + "'");
            rs.next();
            
            return rs.getInt(1);
    }
    
    public boolean usernameVarMi(String username){
        boolean isThere = false;
        try {
            Connection conn = null;
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM `bx_users` u WHERE u.username='"+username+"'");
            
            int recordCount =0;
            while(result.next())
            {
                recordCount++;
            }
            
            if(recordCount == 0){
                isThere = false;
            }else{
                isThere = true;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isThere;
    }
    
    public void selectEnIyi(String[] books) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement stmt = null;
        Connection conn2 = null;
        Statement stmt2 = null;
        ResultSet rs;
        ResultSet rs2;
        int i=0;
        
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt2 = conn2.createStatement();
            rs = stmt.executeQuery("select ISBN, count(Book_Rating) as rate_count,(sum(Book_Rating)/count(Book_Rating)) as trate from bx_book_ratings group by ISBN order by trate desc, rate_count desc limit 0, 10;");
            while(rs.next())
            {
                rs2 = stmt2.executeQuery("Select * from bx_books where ISBN='" + rs.getString("ISBN") + "';");
                rs2.next();
                System.out.println(rs2.getString("ISBN") + " = " + rs2.getString("Book_Title"));
                books[i] = rs2.getString("Image_URL_M");
                books[i+10] = rs2.getString("Book_Title");
                i++;
                                                
            }
    }
    
    public void selectEnPopuler(String[] books) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement stmt = null;
        Connection conn2 = null;
        Statement stmt2 = null;
        ResultSet rs;
        ResultSet rs2;
        int i=0;
        
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt2 = conn2.createStatement();
            rs = stmt.executeQuery("SELECT ISBN, COUNT(Book_Rating) AS rc FROM bx_book_ratings GROUP BY ISBN ORDER BY rc DESC LIMIT 10");
            while(rs.next())
            {
                rs2 = stmt2.executeQuery("Select * from bx_books where ISBN='" + rs.getString("ISBN") + "';");
                rs2.next();
                System.out.println(rs2.getString("ISBN") + " = " + rs2.getString("Book_Title"));
                books[i] = rs2.getString("Image_URL_M");
                books[i+10] = rs2.getString("Book_Title");
                i++;
                                                
            }
    }
    
    public void selectEnYeni(String[] books) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        int i=0;
        
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from bx_books order by date desc limit 5");
            
            while(rs.next())
            {
                books[i] = rs.getString("Image_URL_M");
                books[i+5] = rs.getString("Book_Title");
                i++;
                                                
            }
    }
    
    public static <K, V> ArrayList<String> mapToUserID(Map<K, V> map) {
        ArrayList<String> userID = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() 
				+ " Value : " + entry.getValue());
            userID.add(entry.getKey().toString());
        }
        
        return userID;
    }
    
    public void onerilen(int ID,String[] books) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        Connection conn2 = null;
        Statement stmt2 = null;
        
        ResultSet rs;
        ResultSet rs2;
        int userRate,myRate;
        HashMap<Integer, Double> benzerlik = new HashMap<Integer, Double>();
        
        Class.forName("com.mysql.jdbc.Driver");  
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt2 = conn2.createStatement();
        
        String query = "SELECT * FROM `bx_book_ratings` rate1, `bx_book_ratings` rate2 WHERE rate1.`User_ID` != " + ID + " AND rate2.`User_ID` = " + ID + " AND rate1.ISBN = rate2.ISBN;";
            
        rs = stmt.executeQuery(query);
        
        while(rs.next()){
            userRate = rs.getInt("rate1.book_rating");
            myRate = rs.getInt("rate2.book_rating");
            if(benzerlik.containsKey(rs.getInt("rate1.User_ID"))){
                benzerlik.put(rs.getInt("rate1.User_ID"), benzerlik.get(rs.getInt("rate1.User_ID")) + Math.sqrt(Math.abs(Math.pow(userRate, 2) - Math.pow(myRate, 2))));
            }else{
                benzerlik.put(rs.getInt("rate1.User_ID"), 0.0 + Math.sqrt(Math.abs(Math.pow(userRate, 2) - Math.pow(myRate, 2))));
            }
        }
        Map<Integer, Double> sorted = benzerlik.entrySet().stream().sorted(comparingByValue()).collect(
            toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        ArrayList<String> userID = mapToUserID(sorted);
        int i=0,j=0;
        
        String[] onerilenISBN = new String[10];
        while(i < 10){
            rs2 = stmt2.executeQuery("Select ISBN from bx_book_ratings where User_ID=" + Integer.parseInt(userID.get(j)) + " and Book_Rating > 5 ORDER BY Book_Rating DESC;");
            while(rs2.next() && i < 10){
                onerilenISBN[i] = rs2.getString("ISBN");
                i++;
            }
            j++;
        }
        
        for(int a=0;a<10;a++){
            System.out.println(onerilenISBN[a]);
        }
        for(int a=0;a<10;a++){
            rs2 = stmt2.executeQuery("Select * from bx_books where ISBN=" + onerilenISBN[a] + ";");
            while(rs2.next()){
                books[a] = rs2.getString("Image_URL_M");
                books[a+10] = rs2.getString("Book_Title");
            }
        }
    }
}