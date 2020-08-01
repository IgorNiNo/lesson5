package lesson5;

public class Person {
    private String name;
    private String function;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String function, String email, String phone, int salary, int age) {
        this.name = name;
        this.function = function;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.printf("Сотрудник: ФИО - %-27s, должность - %-20s, email - %-18s, номер телефона - %s, з/пл. - %-6d, возраст - %d лет\n",
                name, function, email, phone, salary, age);
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Введен некорректный возраст");
        }
    }

    public int getAge() {
        return age;
    }

}
