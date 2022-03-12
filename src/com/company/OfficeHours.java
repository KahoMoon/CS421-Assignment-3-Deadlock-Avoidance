package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class OfficeHours {

    boolean professorHasAQuestionToAnswer;

    public OfficeHours() {

        this.professorHasAQuestionToAnswer = false;

    }


    public void student() throws InterruptedException{

        while(true){
            synchronized (this){

                if(professorHasAQuestionToAnswer){

                    Thread.sleep(500);
                    wait();

                }
                else{

                    QuestionStart();
                    QuestionDone();

                }

            }
        }

    }

    public void professor() throws InterruptedException{

        while(true){
            synchronized (this){

                if(!professorHasAQuestionToAnswer){

                    System.out.println("The professor naps...");
                    Thread.sleep(500);
                    wait();

                }else {

                    AnswerStart();
                    AnswerDone();

                }
            }
        }

    }

    private void AnswerStart(){

        System.out.println("The professor answers the student's question.\n");

    }

    private void AnswerDone() throws InterruptedException{

        professorHasAQuestionToAnswer = false;

        notify();
        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));

    }

    private void QuestionStart(){

        System.out.println("\nA student asks a question.");

    }

    private void QuestionDone() throws InterruptedException{

        professorHasAQuestionToAnswer = true;

        notify();
        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));

    }

}
