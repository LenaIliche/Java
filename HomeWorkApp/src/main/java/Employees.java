public class Employees {
    String name;
    String position;
    String email;
    String phone;
    int salary; //ставила double, но форматированная печать ругается потом((
    int age;

    public Employees (String name, String position, String email, String phone, int salary, int age) {

        this.name = name;
        this.position = position;
        this. email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployee() {
        System.out.printf("\nEmployee: %s,\nPosition: %s,\nEmail: %s,\nPhone: %s,\nSalary: %d,\nAge: %d\n",
                this.name, this.position, this.email, this.phone, this.salary,this.age);
    }

    public static void main(String[] args) {
        Employees[] persArray = new Employees[5];
        persArray[0] = new Employees("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Employees("Petrov Petr", "Senior Engineer", "petr@mailbox.com", "892389076", 60000, 59);
        persArray[2] = new Employees("Sidorov Sidr", "Junior Engineer", "sidr@mailbox.com", "8923150987", 20000, 22);
        persArray[3] = new Employees("Pen Pineapple", "Japan Engineer", "pen@mailbox.com", "892312321", 1000000, 67);
        persArray[4] = new Employees("Apple Pen", "Dancer", "apple@mailbox.com", "892312098", 50000, 45);

        for (Employees employees : persArray) {
            if (employees.age > 40) {
                employees.printEmployee();
            }
        }
    }

}
