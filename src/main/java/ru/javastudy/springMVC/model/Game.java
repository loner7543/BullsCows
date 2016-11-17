package ru.javastudy.springMVC.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Александр on 17.11.2016.
 */
public class Game {
    private Random random;
    private int[] digits = new int[4];//список для 4х цифр загаданноего числа
    private String secretNumber;//строовое представление загаданного числа
    private int partialMatch;//частичное совпадение
    private int fullMatch;//полное совпадение
    private List<String> log;

    public Game(){
        log = new LinkedList<>();
        random = new Random();
    }



    public void generateNumber(){
        boolean contains;
        for (int i = 0;i<4;i++){
            do {
                contains = false;
                digits[i] = random.nextInt(10);
                //сравнить сгенерированную цифру с предыдущей
                for (int k = 0;k<i;k++){
                    if (digits[k]==digits[i])
                    {
                        contains = true;
                    }
                }

            }
            while (contains);
        }
        this.secretNumber = String.valueOf(digits[0])+String.valueOf(digits[1])+String.valueOf(digits[2])+String.valueOf(digits[3]);
    }

    //сравнивает загаданное и введенное число(1 попытка)
    public void compare(String userVariant){
        String res  = "";
        partialMatch =0;//cow
        fullMatch = 0;//bull
        char[] array = userVariant.toCharArray();
        for (int i = 0;i<4;i++){
            if (secretNumber.contains(String.valueOf(array[i])))//если
            {
                if (secretNumber.toCharArray()[i]==array[i])
                {
                    fullMatch++;
                }
                else {
                    partialMatch++;
                }
            }
        }
        res = "Число "+userVariant+ " имеет "+fullMatch+" быков и "+partialMatch+" коров";
        log.add(res);
        if (fullMatch==4){
            res = "Игра окончена. Вы выиграли";
            log.add(res);
        }
    }

    public int getPartialMatch() {
        return partialMatch;
    }

    public int getFullMatch() {
        return fullMatch;
    }

    public List<String> getLog() {
        return log;
    }
}
