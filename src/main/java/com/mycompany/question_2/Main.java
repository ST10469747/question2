/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.question_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author emeris
 */
public class Main {


    private static final String[] CONSOLE_TYPES = {"PS5", "XBOX", "NINTENDO SWITCH"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ConsoleSales> records = new ArrayList<>();
        boolean another = true;

        System.out.println("=== Electronics Store Console Sales ===");

        while (another) {
            // Select console type
            System.out.println();
            System.out.println("Select a console device type:");
            for (int i = 0; i < CONSOLE_TYPES.length; i++) {
                System.out.println((i + 1) + ". " + CONSOLE_TYPES[i]);
            }
            int choice = readInt(input, "Enter choice (1-" + CONSOLE_TYPES.length + "): ",
                    1, CONSOLE_TYPES.length);
            String consoleType = CONSOLE_TYPES[choice - 1];

            // Store name and total sales
            System.out.print("Enter store name: ");
            String store = input.nextLine().trim();

            int totalSales = readInt(input, "Enter total amount of sales: ", 0, Integer.MAX_VALUE);

            // Instantiate the ConsoleSales class
            ConsoleSales sale = new ConsoleSales(consoleType, store, totalSales);
            records.add(sale);

            System.out.print("Add another record? (y/n): ");
            another = input.nextLine().trim().equalsIgnoreCase("y");
        }

        // Print the report
        System.out.println();
        System.out.println("========== SALES REPORT ==========");
        int grandTotal = 0;
        for (ConsoleSales sale : records) {
            sale.printReport();
            grandTotal += sale.getTotalSales();
        }
        System.out.println("Total console sales: " + grandTotal);

        input.close();
    }

    // Reads a whole number within a range, re-prompting on invalid input
    private static int readInt(Scanner input, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // fall through to the error message
            }
            System.out.println("Invalid input, please try again.");
        }
    }
}