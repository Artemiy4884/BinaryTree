package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        menu(tree);
    }

    public static void menu(Tree tree){
        Scanner s = new Scanner(System.in);
        boolean isExit = false;
        do{
        System.out.print("What to do?(A C D P)");
        String choice = s.nextLine();
        switch (choice){
            case "A":{
                System.out.print("Please, enter an element to add: ");
                int value = Integer.parseInt(s.nextLine());
                tree.add(value);
            }break;
            case "C":{
                System.out.print("Please, enter an element for check: ");
                int value = Integer.parseInt(s.nextLine());
                if(tree.search(value)){
                    System.out.println("Found!");
                }else{
                    System.out.println("Not found!");
                }
            }break;
            case "D":{
                System.out.print("Please, enter an element for deleting: ");
                int value = Integer.parseInt(s.nextLine());
                tree.delete(value);
            }break;
            case "P":{
                tree.straightPrint();
                tree.symmetricalPrint();
                tree.reversePrint();
            }break;
            case "E":
                isExit = true;
                break;
        }
        }while(!isExit);
    }
}
