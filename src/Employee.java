public class Employee {

    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    @Override
    public String toString() {
        return "Employee name=" + name +
                "\nsalary=" + salary + " TL" +
                "\nworkHours=" + workHours +
                "\nhireYear=" + hireYear +
                "\ntax=" + tax() + " TL" +
                "\nbonus=" + bonus() + " TL" +
                "\nraise salary=" + raiseSalary() + " TL" +
                "\nsalary(tax and bonus included)=" + (salary - tax() + bonus()) + " TL" +
                "\ntotal salary=" + (salary + raiseSalary() + bonus() - tax()) + " TL";
    }

    public double tax() {
        double tax;
        if (salary <= 1000)
            tax = 0;
        else {
            tax = (salary * 0.03);
        }
        return tax;
    }

    public double bonus() {
        int bonus;
        if (workHours > 40) {
            bonus = (workHours - 40) * 30;
        } else
            bonus = 0;
        return bonus;
    }

    public double raiseSalary() {
        int thisYear = 2021;
        double salaryIncrease;
        double salaryWithTaxAndBonus = salary - tax() + bonus();
        int numberOfEmpYears = thisYear - hireYear;
        if (numberOfEmpYears < 10) {
            salaryIncrease = salaryWithTaxAndBonus * 0.05;
        } else if (numberOfEmpYears < 20) {
            salaryIncrease = salaryWithTaxAndBonus * 0.1;
        } else {
            salaryIncrease = salaryWithTaxAndBonus * 0.15;
        }
        return salaryIncrease;
    }
}
