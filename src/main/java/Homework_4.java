public class Homework_4 {

    public static void main(String[] args) {
        Employees[] person = new Employees[5];
        person[0] = new Employees("Liliia_1", "Interpreter", "liliia_1@gmail.com", "89166527316", 50000, 20);
        person[1] = new Employees("Liliia_2", "Interpreter_2", "liliia_2@gmail.com", "89166527317", 60000, 30);
        person[2] = new Employees("Liliia_3", "Interpreter_3", "liliia_3@gmail.com", "89166527318", 70000, 41);
        person[3] = new Employees("Liliia_4", "Interpreter_4", "liliia_4@gmail.com", "89166527319", 80000, 50);
        person[4] = new Employees("Liliia_5", "Interpreter_5", "liliia_5@gmail.com", "89166527320", 90000, 60);

        for (Employees employees : person)
            if (employees.getAge() > 40)
                System.out.println(employees);
    }

}
