package com.company;

public class OfficeHours {

    boolean professorIsBusy;

    public OfficeHours() {

        this.professorIsBusy = false;

    }


    public void student() throws InterruptedException{

        while(true){
            synchronized (this){

                while(professorIsBusy){
                    wait();
                }

                System.out.print("A student asks a question.");
                professorIsBusy = true;

            }
        }

    }

    public void professor() throws InterruptedException{

        while(true){
            synchronized (this){

                if(professorIsBusy){

                    System.out.print("The professor answers the student's question.");
                    professorIsBusy = false;

                }else{

                    System.out.print("The professor naps...");

                }

            }
        }

    }

}
