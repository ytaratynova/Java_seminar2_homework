// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package seminar2_homework;


import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;


public class task02 {
    /**
     * @param args
     */

    public static int Input() {             // Пользователь вводит размер массива
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число элементов в массиве: ");
        String number = iScanner.nextLine();
        iScanner.close();
        return Integer.parseInt(number);
    }

    public static int[] Create(int length) { // Генерация элементов массива
        int[] arr = new int[length];

        for (int i = 0; i < length; i++){
            arr[i] = (int) (Math.random()*(200-1)) - 100;
        }
        return arr;
    }

    public static int[] Sort(int[] arr) {   // Сортировка массива
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < (arr.length - 1 - i); j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            Logo(arr); 
            }
        }
        return arr;
    }

    public static void Logo(int[] arr){     // Записываем логи
        try{
            Logger logger = Logger.getLogger(task02.class.getName());
            logger.setLevel(Level.INFO);
            FileHandler fh = new FileHandler("log.xml", true);
            logger.addHandler(fh);
            XMLFormatter xml = new XMLFormatter();
            fh.setFormatter(xml);

            logger.info(Arrays.toString(arr));
            fh.close();

            } catch (Exception e) {
            System.out.println("Ошибка!");
            } finally {
            
            System.out.println("__________________________________");
           }
    }

    public static void main(String[] args){
        int size = Input();   
        int[] num = Create(size);
        System.out.printf("Задан случайный массив %s \n",Arrays.toString(num));
        System.out.printf("Отсортированный массив %s", Arrays.toString(Sort(num)));
    }
  
}
