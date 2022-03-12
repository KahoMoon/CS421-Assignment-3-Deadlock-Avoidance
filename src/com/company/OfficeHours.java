package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class OfficeHours {

    boolean professorIsBusy;
    boolean anotherStudent;

    public OfficeHours() {

        this.professorIsBusy = false;
        this.anotherStudent = false;

    }


    public void student() throws InterruptedException{

        while(true){
            synchronized (this){

                if(professorIsBusy){

                    if(ThreadLocalRandom.current().nextInt(0, 2000) % 2 == 0){

                        anotherStudent = true;

                    }

                    wait();

                }

                System.out.println("\nA student asks a question.");

                professorIsBusy = true;

                notify();
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));

            }
        }

    }

    public void professor() throws InterruptedException{

        while(true){
            synchronized (this){

                if(!professorIsBusy && !anotherStudent){
                    System.out.println("The professor naps...");
                    wait();
                }

                AnswerStart();
                AnswerDone();

            }
        }

    }

    private void AnswerStart(){

        System.out.println("The professor answers the student's question.\n");

    }

    private void AnswerDone() throws InterruptedException{

        if(!anotherStudent){
            professorIsBusy = false;
        }


        notify();
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));

    }

}
