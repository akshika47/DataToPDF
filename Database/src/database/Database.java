/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.*;
import java.sql.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dinal
 */
public class Database {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DocumentException {
        try {
            Document document=new Document();
              try {
                  PdfWriter.getInstance(document,new FileOutputStream("E:/data.pdf"));
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
              }
             document.open();
             PdfPTable table=new PdfPTable(2);
             table.addCell("Name");
             table.addCell("Address");
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdbforAkshika", "root", "");
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("Select * from data");
             while(rs.next()){
             table.addCell(rs.getString("name"));
             table.addCell(rs.getString("address"));
             }
             document.add(table);
             document.close();
              // TODO code application logic here
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
