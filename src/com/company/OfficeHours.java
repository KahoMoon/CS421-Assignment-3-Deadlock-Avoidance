package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class OfficeHours {

    boolean professorHasAQuestionToAnswer;
    boolean anotherStudentHasAQuestion;

    public OfficeHours() {

        this.professorHasAQuestionToAnswer = false;
        this.anotherStudentHasAQuestion = false;

    }


    public void student() throws InterruptedException{

        while(true){
            synchronized (this){

                if(professorHasAQuestionToAnswer){

                    Thread.sleep(500);
                    wait();

                }

                System.out.println("\nA student asks a question.");
                professorHasAQuestionToAnswer = true;

                notify();
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));

            }
        }

    }

    public void professor() throws InterruptedException{

        while(true){
            synchronized (this){

                if(!professorHasAQuestionToAnswer && !anotherStudentHasAQuestion){

                    System.out.println("The professor naps...");
                    Thread.sleep(500);
                    wait();

                }

                System.out.println("The professor answers the student's question.\n");
                professorHasAQuestionToAnswer = false;

                notify();
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));

            }
        }

    }

}
