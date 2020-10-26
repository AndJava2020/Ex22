package ru.AndJava2020.Ex22;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Student {
    private static int value=0;
    private int iDNumber;
    private double GPA;
    private String name;
    private Calendar dateBirthday;
    private Date date;



    public Student(String name, double gpa, String birthday){

        this.name=name;
        value++;
        this.iDNumber=value;
        this.GPA=gpa;
        dateBirthday=setBirthday(birthday);
        date=new Date();

    }
    private GregorianCalendar setBirthday(String t){
        t=t.replace("."," ");
        t=t.replace(":"," ");
        Integer []intDate=new Integer[5];

        String []buffer=t.split(" ");
        for (int i = 0; i<5; i++) {
            intDate[i]=Integer.parseInt(buffer[i]);
        }
        return new GregorianCalendar(intDate[2],intDate[1],intDate[0],intDate[3],intDate[4]);
    }

    enum Format {
        shortDate, mediumDate, longDate
    }
    public String getBirthday(String name){
        String result="";
        switch (Format.valueOf(name)){
            case shortDate:
                result=Integer.toString(dateBirthday.get(Calendar.DAY_OF_MONTH))+"."+Integer.toString(dateBirthday.get(Calendar.MONTH));
                break;
            case mediumDate:
                result=Integer.toString(dateBirthday.get(Calendar.DAY_OF_MONTH))+"."+Integer.toString(dateBirthday.get(Calendar.MONTH))  + "."+ Integer.toString(dateBirthday.get(Calendar.YEAR));
                break;
            case longDate:
                result=Integer.toString(dateBirthday.get(Calendar.DAY_OF_MONTH))+"."+Integer.toString(dateBirthday.get(Calendar.MONTH)) + "."+Integer.toString(dateBirthday.get(Calendar.YEAR)) +" "+Integer.toString(dateBirthday.get(Calendar.HOUR))+":"+Integer.toString(dateBirthday.get(Calendar.MINUTE));
                break;

        }
        return result;
    }
    public void Work(){
        Date dt=new Date();
        System.out.println("Student " + name);
        System.out.println("Work started " + date.toString());
        System.out.println("Work ended " + dt.toString());
        System.out.println("Work time ~"+(dt.getTime()-date.getTime())/1000 +"sec");
    }

    @Override
    public String toString() {
        return "Student{" +
                "iDNumber=" + iDNumber +
                ", GPA=" + GPA +
                ", name='" + name + '\'' +
                ", dateBirthday=" + getBirthday("longDate") +
                '}';
    }
}
