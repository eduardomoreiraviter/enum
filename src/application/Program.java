package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String departamento = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int payDay = sc.nextInt();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Telefone: ");
        String phone = sc.next();

        Address address = new Address(email, phone);

        System.out.print("Quantos funcionários tem o departamento? ");
        int n = sc.nextInt();

        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            System.out.println("Dados do funcionario " + i);
            System.out.print("Nome: ");
            String name = sc.next();
            System.out.print("Salario: ");
            double salary = sc.nextDouble();

            employees.add(new Employee(name, salary));
        }

        Department department = new Department(departamento, payDay, address, employees);

        System.out.println();
        showReport(department);

        sc.close();
    }

    //TODO showreport
            private static void showReport(Department department) {

                System.out.println("FOLHA DE PAGAMENTO: ");

                //pagamento
                double pagamento = 0;
                for (Employee emp : department.getEmployees()){
                    pagamento += emp.getSalary();
                }
                System.out.println("Departamento Vendas = " + pagamento );
                System.out.println("Pagamento realizado no dia = " + department.getPayDay());

                //funcionarios
                System.out.println("Funcionarios: ");
                for (Employee emp : department.getEmployees()){
                    System.out.println(emp.getName());
                }

                //email
                System.out.println("Para duvidas favor entrar em contato: " + department.getAddress().getEmail());



            }
}
