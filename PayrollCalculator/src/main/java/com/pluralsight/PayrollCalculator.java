package com.pluralsight;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Kullanıcıdan dosya adlarını al
        System.out.print("Enter the name of the employee file to process: ");
        String inputFileName = input.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFileName = input.nextLine();

        List<Employee> employees = readEmployees(inputFileName);

        if (outputFileName.endsWith(".json")) {
            writeAsJson(outputFileName, employees);
        } else {
            writeAsCsv(outputFileName, employees);
        }

        System.out.println("Payroll file created: " + outputFileName);
    }

    // 📥 CSV dosyasından çalışan bilgilerini oku
    public static List<Employee> readEmployees(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // ilk satır başlık (header) – atla

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                employees.add(new Employee(id, name, hoursWorked, payRate));
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return employees;
    }

    // 📤 CSV olarak çıktı yaz
    public static void writeAsCsv(String fileName, List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("id|name|gross pay");
            writer.newLine();

            for (Employee e : employees) {
                writer.write(e.getEmployeeId() + "|" + e.getName() + "|" + String.format("%.2f", e.getGrossPay()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing the CSV file: " + e.getMessage());
        }
    }

    // 📤 JSON olarak çıktı yaz (bonus)
    public static void writeAsJson(String fileName, List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("[");
            writer.newLine();

            for (int i = 0; i < employees.size(); i++) {
                Employee e = employees.get(i);
                writer.write("  { \"id\": " + e.getEmployeeId() + ", \"name\": \"" + e.getName() +
                        "\", \"grossPay\": " + String.format("%.2f", e.getGrossPay()) + " }");

                if (i < employees.size() - 1) {
                    writer.write(",");
                }
                writer.newLine();
            }

            writer.write("]");
        } catch (IOException e) {
            System.out.println("Error writing the JSON file: " + e.getMessage());
        }
    }
}