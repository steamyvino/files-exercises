/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;


public class Product implements Serializable
{
    public static final int NAME_LENGTH = 30;
    public static final int RECORD_LENGTH = (Character.BYTES*NAME_LENGTH+Double.BYTES+3*Integer.BYTES);
    private String name; // 60 byte
    private double price; // 8 byte
    private Date dateOfProduction; //  4+4+4=12 (3 integers) 
    
    Product()
    {
        name=" ";
        price=0.0;
        dateOfProduction = new GregorianCalendar().getTime();

    }
    
    Product(String name,double price)
    {
        this();
        this.name=name;
        this.price=price;
    }
    
    Product(String name,double price,int year,int month,int day)
    {
        
        this.name=name;
        this.price=price;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        this.dateOfProduction=calendar.getTime();
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public Date getDate()
    {
        return dateOfProduction;     
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public void setPrice(double price)
    {
        this.price=price;
    }
    
    public void setDate(Date date)
    {
        this.dateOfProduction=date;
    }
    
    public void setDate(int year, int month ,int day)
    {
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        this.dateOfProduction=calendar.getTime();
    }
    
    @Override
    public String toString()
    {   
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.getDate());
        return ("Name: "+this.getName()+" "+"|Price: "+this.getPrice()+"|Year "+calendar.get(Calendar.YEAR)+"|Month "+calendar.get(Calendar.MONTH)+"|Day "+calendar.get(Calendar.DAY_OF_MONTH));
    }
    

     /**
      * Sensitive data should not be serialized / Code below is an example
      * private transient String password will show null after calling getPassword();
      */
//    private String password = "secretPassword";
//    
//    String getPassword()
//    {
//        return this.password
//    }
    
        private String dataCode = "data1432";
    
    String getDataCode()
    {
        return this.dataCode;
    }
    
    private void readObject(ObjectInputStream InS) throws IOException, ClassNotFoundException
    {   
        InS.defaultReadObject();
        if(!dataCode.equals("data1432"))
                 throw new IOException("Data invalid");
    }
    
    
}
