package lesson5;

public class Main {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];

        persArray[0] = new Person("Иванов Иван Иванович", "Директор", "ivanovII@mail.ru", "+7(910) 123-45-67", 100000, 55);
        persArray[1] = new Person("Петров Петр Петрович", "Главный инженер", "petrovPP@mail.ru", "+7(910) 234-56-78", 90000, 50);
        persArray[2] = new Person("Сидоров Сидр Сидорович", "Руководитель проекта", "sidorovSS@mail.ru", "+7(910) 345-67-89", 80000, 39);
        persArray[3] = new Person("Ильин Илья Ильич", "Начальник отдела МТС", "ilynII@mail.ru", "+7(910) 456-78-90", 85000, 40);
        persArray[4] = new Person("Алексеев Алексей Алексеевич", "Начальник отдела АСУ", "alekseevAA@mail.ru", "+7(910) 567-89-01", 85000, 41);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                persArray[i].info();
            }
        }
    }
}
