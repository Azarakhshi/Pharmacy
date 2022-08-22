package view.useroption.patientoption;

import java.util.Scanner;

public class PatientOption {
    Scanner scanner = new Scanner(System.in);
    public void patientOptions(){
        while (true){
            System.out.println("1- Add prescription. ");
            System.out.println("2- See confirmed price for each item. ");
            System.out.println("3- See confirmed total price. ");
            System.out.println("4- Edit prescription. ");
            System.out.println("5-  Delete prescription. ");
            System.out.println("exit");
            String input = scanner.next();
            if(input.equals("1")){

            }else if(input.equals("2")){

            }else if (input.equals("3")){

            }else if(input.equals("4")){

            }else if(input.equals("5")){

            }else if(input.equals("exit")){
                break;
            }else {
                System.out.println("your input is invalid. ");
            }
        }
    }

}
