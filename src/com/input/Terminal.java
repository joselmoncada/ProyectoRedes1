package com.input;

import java.util.Scanner;

public class Terminal implements Input {
    @Override
    public String getInput() {
        String option = "0";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Menú de terminal");
            System.out.println(" 1- Imprimir tablero");
            System.out.println(" 2- Imprimir piscina de valores");
            System.out.println(" 3- Jugar");
            System.out.println(" 4- Debug completo");
            System.out.println(" 5- Salir del Bingo");
            option = scanner.nextLine();
            switch(option){
                case "1":
                    return "printBoard";
                case "2":
                    return "printValues";
                case "3":
                    return "play";
                case "4":
                    return "debug";
                case "5":
                    return "endGame";
                default:
                    System.out.println("!Opción Inválida!");
                    break;
            }
        }
    }
}
