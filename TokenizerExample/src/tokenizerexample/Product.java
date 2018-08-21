/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizerexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;


public class Product
{
    private String name;
    private double price;
    private Date dateOfProduction;
    
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
    
    
    
    static void writeToDataBase(Product[] products, PrintWriter writer)
    {
    
        writer.println(products.length);
        GregorianCalendar calendar =new GregorianCalendar();
        
        for(int i=0; i<products.length;i++)
        {
            calendar.setTime(products[i].getDate());
            writer.println(products[i].getName()+"|"+products[i].getPrice()+"|"+calendar.get(Calendar.YEAR)+"|"+calendar.get(Calendar.MONTH)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
        
        }
        
    }
    
    static Product[] readFromFile (BufferedReader reader) throws IOException
    {
        int length=Integer.parseInt(reader.readLine());
        
        Product[] products = new Product[length];
        
        for(int i=0; i<length;i++)
        {
            String line = reader.readLine();
            StringTokenizer token = new StringTokenizer(line,"|");
            String name = token.nextToken();
            Double price = Double.parseDouble(token.nextToken());
            int year=Integer.parseInt(token.nextToken());
            int month=Integer.parseInt(token.nextToken());
            int day=Integer.parseInt(token.nextToken());
    
            products[i]=new Product(name,price,year,month,day);
        
        }
    
         return products;       
    
    }
     
    
}
