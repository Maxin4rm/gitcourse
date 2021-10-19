package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static int[][]arr = new int[8][8];

    private static void arrayOut(){
        for(int[] i : arr){
            for(int j : i){
                System.out.print(" " + j + " ");
            }
            System.out.println(" ");
        }
    }

    private static void arrayInit(){
        for(int[] i : arr) Arrays.fill(i, 0);
        for(int i = 0; i < arr.length; i++){
            if(i < 5 && i > 2) continue;
            for(int j = 0; j < arr[i].length; j++){
                if((i == 1 && j % 2 == 0) || ((i == 0 || i == 2) && j % 2 == 1)) arr[i][j] = 1;
                else if((i == 6 && j % 2 == 1) || ((i == 5 || i == 7) && j % 2 == 0)) arr[i][j] = 2;
            }
        }
    }

        public static void main(String[] args){
        arrayInit();
        arrayOut();
        boolean isCorrect, inCorrect = false, imCorrect;
        Scanner scan = new Scanner(System.in);
        do{
            do {
                System.out.println("Ход первого игрока");
                System.out.println("Введите координату строки клетки, на которой находится фигура, которой вы собираетесь ходить ");
                int x0 = 0;
                int y0 = 0;
                int x = 0;
                int y = 0;
                do {
                    imCorrect = true;
                    try {
                        x0 = Integer.parseInt(scan.nextLine()) - 1;
                    } catch (Exception e) {
                        imCorrect = false;
                    }
                    if(x0 < 0 || x0 > 7){System.out.println("Ошибка"); imCorrect = false;}
                } while (!imCorrect);
                System.out.println("Введите координату столбца клетки, на которой находится фигура, которой вы собираетесь ходить ");
                do {
                    imCorrect = true;
                    try {
                         y0 = Integer.parseInt(scan.nextLine()) - 1;
                    } catch (Exception e) {
                        imCorrect = false;
                    }
                    if(y0 < 0 || y0 > 7){System.out.println("Ошибка"); imCorrect = false;}
                } while (!imCorrect);

                isCorrect = false;
                if (arr[y0][x0] == 2) {
                    System.out.println("Введите координату строки клетки, куда вы собираетесь ходить вашей фигурой ");
                    do {
                        imCorrect = true;
                        try {
                            x = Integer.parseInt(scan.nextLine()) - 1;
                        } catch (Exception e) {
                            imCorrect = false;
                        }
                        if(x < 0 || x > 7){System.out.println("Ошибка"); imCorrect = false;}
                    } while (!imCorrect);
                    System.out.println("Введите координату столбца клетки, куда вы собираетесь ходить вашей фигурой ");
                    do {
                        imCorrect = true;
                        try {
                            y = Integer.parseInt(scan.nextLine()) - 1;
                        } catch (Exception e) {
                            imCorrect = false;
                        }
                        if(y < 0 || y > 7){System.out.println("Ошибка"); imCorrect = false;}
                    } while (!imCorrect);

                    if ((y0 - y) == 1 && Math.abs(x - x0) == 1) {
                        arr[y0][x0] = 0;
                        arr[y][x] = 2;
                    }else if(((arr[y0 - 1][x0 - 1] == 1 && x == x0 - 2) || (arr[y0 - 1][x0 + 1] == 1 && x == x0 + 2)) && y0 - y == 2){   //сбивание вперед
                        int buff = (x > x0) ? 1 : -1;
                        arr[y0][x0] = 0;
                        arr[y0 - 1][x0 + buff] = 0;
                        arr[y][x] = 2;
                    } else isCorrect = true;
                    if(!isCorrect) arrayOut();

                } else {
                    System.out.println("Вы ввели неверные координаты. Попробуйте еще раз");
                    isCorrect = true;
                }
            }while(isCorrect);

            do{
                System.out.println("Ход второго игрока");
                System.out.println("Введите координату строки клетки, на которой находится фигура, которой вы собираетесь ходить ");
                int x0 = 0;
                int y0 = 0;
                int x = 0;
                int y = 0;
                do {
                    imCorrect = true;
                    try {
                        x0 = Integer.parseInt(scan.nextLine()) - 1;
                    } catch (Exception e) {
                        imCorrect = false;
                    }
                    if(x0 < 0 || x0 > 7){System.out.println("Ошибка"); imCorrect = false;}
                } while (!imCorrect);
                System.out.println("Введите координату столбца клетки, на которой находится фигура, которой вы собираетесь ходить ");
                do {
                    imCorrect = true;
                    try {
                        y0 = Integer.parseInt(scan.nextLine()) - 1;
                    } catch (Exception e) {
                        imCorrect = false;
                    }
                    if(y0 < 0 || y0 > 7){System.out.println("Ошибка"); imCorrect = false;}
                } while (!imCorrect);


                isCorrect = false;
                if (arr[y0][x0] == 1) {
                    System.out.println("Введите координату строки клетки, куда вы собираетесь ходить вашей фигурой ");
                    do {
                        imCorrect = true;
                        try {
                            x = Integer.parseInt(scan.nextLine()) - 1;
                        } catch (Exception e) {
                            imCorrect = false;
                        }
                        if(x < 0 || x > 7){System.out.println("Ошибка"); imCorrect = false;}
                    } while (!imCorrect);
                    System.out.println("Введите координату столбца клетки, куда вы собираетесь ходить вашей фигурой ");
                    do {
                        imCorrect = true;
                        try {
                            y = Integer.parseInt(scan.nextLine()) - 1;
                        } catch (Exception e) {
                            imCorrect = false;
                        }
                        if(y < 0 || y > 7){System.out.println("Ошибка"); imCorrect = false;}
                    } while (!imCorrect);

                    if ((y0 - y) == -1 && Math.abs(x - x0) == 1) {
                        arr[y0][x0] = 0;
                        arr[y][x] = 1;
                    }else if(((arr[y0 + 1][x0 - 1] == 2 && x == x0 - 2) || (arr[y0 + 1][x0 + 1] == 2 && x == x0 + 2)) && y0 - y == 2){   //сбивание вперед
                        int buff = (x > x0) ? 1 : -1;
                        arr[y0][x0] = 0;
                        arr[y0 + 1][x0 + buff] = 0;
                        arr[y][x] = 1;
                    } else isCorrect = true;
                    if(!isCorrect) arrayOut();
                } else {
                    System.out.println("Вы ввели неверные координаты. Попробуйте еще раз");
                    isCorrect = true;
                }
            }while(isCorrect);

        }while(!inCorrect);
        scan.close();
    }
}









