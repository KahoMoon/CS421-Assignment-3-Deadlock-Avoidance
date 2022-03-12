package com.company;

public class OfficeHours {

    boolean isBusy;

    public OfficeHours() {

        this.isBusy = false;

    }


    public void student() throws InterruptedException{

        while(true){
            synchronized (this){

                while(isBusy){
                    wait();
                }

                System.out.print("A student asks a question");
                isBusy = true;

            }
        }

    }

    public void professor() throws InterruptedException{

        while(true){
            synchronized (this){

                while

            }
        }

    }

}
