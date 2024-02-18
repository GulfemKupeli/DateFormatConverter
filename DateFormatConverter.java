import javax.swing.*;

public class DateFormatConverter {
    public static void main(String[] args) {
        /**

         Program description:I built a versatile date format converter that can handle various date formats and validate input dates. Users may input dates in different formats, and the program should convert them to the European format (day.month.year) while ensuring the input dates are valid.

         Author:Gülfem Küpeli

         E-mail address: 210401024@ogr.ikcu.edu.tr

         Homework Number: 01

         Last Changed:27/10/2023

         */
        JOptionPane.showMessageDialog(null, "Welcome to the Advanced Date Format Converter!");

        /* This part gets user input for date format. */
        String[] options = { "MM/DD/YYYY", "DD/MM/YYYY", "YYYY/MM/DD" };
        int choice = JOptionPane.showOptionDialog(null, "Select the date format:", "Date Format", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        /* It stores the user's choice of date format and prompts the user to enter a date in the chosen format. */
        String inputF = options[choice];
        String input = JOptionPane.showInputDialog("Enter your date (e.g., 06/17/2008):");

        //This method is called to convert the user input date into the European format. Also it checks for valid inputs.
        String europeanFormat = convertToEuropean(input, inputF);
        if (europeanFormat.equals("Invalid date format")) {
            JOptionPane.showMessageDialog(null, "Invalid date format");
        } else {
            JOptionPane.showMessageDialog(null, "Validating the entered date...\nYou've converted the date to the European format: " + europeanFormat);
        }

    }

    //convertToEuropean method takes the input date and format as parameters and converts it into the European format.
    public static String convertToEuropean(String input, String inputFormat) {
        String[] parts = input.split("/");
        if (parts.length == 3) {
            int day, month, year;
            switch (inputFormat) {
                case "MM/DD/YYYY":
                    month = Integer.parseInt(parts[0]);
                    day = Integer.parseInt(parts[1]);
                    year = Integer.parseInt(parts[2]);
                    break;
                case "DD/MM/YYYY":
                    day = Integer.parseInt(parts[0]);
                    month = Integer.parseInt(parts[1]);
                    year = Integer.parseInt(parts[2]);
                    break;
                case "YYYY/MM/DD":
                    year = Integer.parseInt(parts[0]);
                    month = Integer.parseInt(parts[1]);
                    day = Integer.parseInt(parts[2]);
                    break;
                default:

                    return "Invalid date format";
            }

            if (isValidDate(day, month, year)) {
                return String.format("%02d.%02d.%02d", day, month, year % 100);
            }
        }
        return "Invalid date format";
    }
    /* ısValidDate checks the provided date if it is valid and considers leap years. The ısLeapYear method checks if a year is a leap year.
     Firstly, year % 4 == 0, checks if the year is divisible by 4. If it is, it passes the first condition for a leap year.
     The second part, year % 100 != 0, checks if the year is not divisible by 100.If it is then the year is a leap year.
      The third part, year % 400 == 0, checks if the year is divisible by 400. If this condition is met, it also means the year is a leap year. */
    public static boolean isValidDate(int day, int month, int year) {
        if (year < 0 || month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        return day >= 1 && day <= daysInMonth[month];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
