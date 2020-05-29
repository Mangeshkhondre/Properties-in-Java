package com.company;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args) throws Exception
    {
//        OpOnProperties();
        OpOnXML();
    }
    static void OpOnProperties() throws Exception
    {
        FileReader reader = new FileReader("db.properties");

        Properties prop = new Properties();
        prop.load(reader);

        System.out.println("user = "+prop.getProperty("user","defaultUSerName"));
        System.out.println("password = "+prop.getProperty("password","defaultPassword"));

        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to change password ? ( Y / N ) : ");
        char ch = sc.next().charAt(0);
        if(ch=='Y')
        {
            System.out.print("Enter new password : ");
            String newPassword= sc.next();
            prop.setProperty("password",newPassword);


            prop.store( new FileWriter("db.properties"), "");

            System.out.print("Processing .");
            for(int i=1;i<=3;i++)
            {
                TimeUnit.MICROSECONDS.sleep(1000000);
                System.out.print(".");
            }
            System.out.println();
            System.out.println("Password Changed Successfully ! ");


            System.out.println("New Credentials : ");
            System.out.println("user = "+prop.getProperty("user"));
            System.out.println("password = "+prop.getProperty("password"));
        }
    }
    static void OpOnXML() throws Exception
    {
        Properties p = new Properties();
        try(FileInputStream fis = new FileInputStream("db.xml"))
        {
            p.loadFromXML(fis);
            System.out.println("user = "+p.getProperty("user"));
            System.out.println("password = "+p.getProperty("password"));

            Scanner sc = new Scanner(System.in);
            System.out.print("Do you want to change password ? ( Y / N ) : ");
            char ch = sc.next().charAt(0);
            if(ch=='Y')
            {
                System.out.print("Enter new password : ");
                String newPassword= sc.next();
                p.setProperty("password",newPassword);


                p.storeToXML(new FileOutputStream("db.xml"), "");

                System.out.print("Processing .");
                for(int i=1;i<=3;i++)
                {
                    TimeUnit.MICROSECONDS.sleep(1000000);
                    System.out.print(".");
                }
                System.out.println();
                System.out.println("Password Changed Successfully ! ");


                System.out.println("New Credentials : ");
                System.out.println("user = "+p.getProperty("user"));
                System.out.println("password = "+p.getProperty("password"));
            }
        }

    }
}
