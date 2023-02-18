// Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


package seminar2_homework;


public class task01 {
    public static void main(String[] args){
        StringBuilder request = new StringBuilder("SELECT * FROM students WHERE ");
        String student = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\": null}";

        student = student.replace(":", " = ")
                            .replace("\"","")
                            .replace("{", "")
                            .replace("}", "");
        String[] student_string = student.split(", ");
               

        for (int i = 0; i < student_string.length; i++){
            if (!student_string[i].contains("null")){
            request.append(student_string[i]);
            System.out.println(request);
            request.append(" AND ");
            }
        }
        
    }
    
}
