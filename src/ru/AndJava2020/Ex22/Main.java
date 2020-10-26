package ru.AndJava2020.Ex22;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Student student=new Student("Putur", 4.5,"30.10.2000 12:00");
        System.out.println(student);
        System.out.println(student.getBirthday("mediumDate"));
        System.out.println();
        Thread.sleep(3333);//имитация работы
        student.Work();

    }
}
