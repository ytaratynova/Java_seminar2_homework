package seminar2_homework;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;



public class task04 {

    public static String inputString(){
        Scanner iScanner = new Scanner(System.in); // считываем строку
        System.out.printf("Что вы хотите посчитать?: ");
        String calculate = iScanner.nextLine();
        iScanner.close();
        
        String new_calculate = calculate.replace("+", " + ") // 'причесываем' введенные пользователем данные
                                        .replace("*", " * ")
                                        .replace("/", " / ")
                                        .replace("-", " -") // - приклеиваем к цифре
                                        .replace("- ", "-")
                                        .replace("  ", " ");
        System.out.println(new_calculate);
        return new_calculate;
    }

    public static float calculate(String[] arr){
        List<String> calc_list = new ArrayList<>(Arrays.asList(arr)); 
        while (calc_list.contains("*") | calc_list.contains("/")){   
            for (int i = 1; i < calc_list.size() - 1; i++){
                if (calc_list.get(i).equals("*")){
                    float result = Float.parseFloat(calc_list.get(i-1)) * Float.parseFloat(calc_list.get(i+1));
                    logo(Float.parseFloat(calc_list.get(i-1)), Float.parseFloat(calc_list.get(i+1)), result, "*");
                    calc_list.set(i-1, Float.toString(result));
                    calc_list.remove(i);
                    calc_list.remove(i);
                    break;
                }

                if (calc_list.get(i).equals("/")){
                    float result = Float.parseFloat(calc_list.get(i-1)) / Float.parseFloat(calc_list.get(i+1));
                    logo(Float.parseFloat(calc_list.get(i-1)), Float.parseFloat(calc_list.get(i+1)), result, "/");
                    calc_list.set(i-1, Float.toString(result));
                    calc_list.remove(i);
                    calc_list.remove(i);
                    break;
                }
            }
        }

        while (calc_list.contains("+")){ // удаляем знак + из ссписка, чтобы просто сложить элементы
            calc_list.remove("+"); 
        }
        
        float sum = 0;
        for (int i = 0; i<calc_list.size(); i++) {
            sum += Float.parseFloat(calc_list.get(i));
            logo(sum - Float.parseFloat(calc_list.get(i)), Float.parseFloat(calc_list.get(i)), sum, "+");
        }
        return sum;
    }

    public static void logo(float a, float b, float u, String c){     // Записываем логи
        try{
            Logger logger = Logger.getLogger(task04.class.getName());
            FileHandler fh = new FileHandler("calculate.xml", true);
            logger.addHandler(fh);
            XMLFormatter xml = new XMLFormatter();
            fh.setFormatter(xml);

            String resultString = Float.toString(a)+c+Float.toString(b)+"="+Float.toString(u);
            logger.info(resultString);
            fh.close();

            } catch (Exception e) {
            System.out.println("Ошибка!");
            } finally {
            
            System.out.println("__________________________________");
           }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        String[] calc_arr = inputString().split(" ");
        float sumFinal = calculate(calc_arr);
        System.out.printf("Результат выражения равен = %.2f", sumFinal);
    }

}

