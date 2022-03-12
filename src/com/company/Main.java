package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        OfficeHours officeHours = new OfficeHours();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    officeHours.professor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    officeHours.student();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();

        t2.join();
        t1.join();

    }
}
