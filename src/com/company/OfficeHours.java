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

                if(professorIsBusy){

                    Thread.sleep(500);
                    wait();

                }

                System.out.println("\nA student asks a question.");
                professorIsBusy = true;

                notify();
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));

            }
        }

    }

    public void professor() throws InterruptedException{

        while(true){
            synchronized (this){

                if(!professorIsBusy){

                    System.out.println("The professor naps...");
                    Thread.sleep(500);
                    wait();

                }else {

                    System.out.println("The professor answers the student's question.\n");

                    if((Math.random() < 0.5)) {

                        professorIsBusy = false;

                    }

                    notify();
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));

                }

            }
        }

    }

}
