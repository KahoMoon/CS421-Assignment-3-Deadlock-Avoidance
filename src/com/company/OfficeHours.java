package com.company;
import java.util.concurrent.ThreadLocalRandom;

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

                System.out.println("\nA student asks a question.");
                professorIsBusy = true;

            }
        }

    }

    public void professor() throws InterruptedException{

        while(true){
            synchronized (this){

                if(professorIsBusy){

                    System.out.println("The professor answers the student's question.\n");
                    professorIsBusy = false;

                }else{

                    System.out.println("The professor naps...");
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));

                }

            }
        }

    }

}
