/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluej;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author BAHATI
 */
public class BlueJ {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Calendar c = new GregorianCalendar();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int dayOfTheWeek;
        int destination;
        int userYear, userMonth, userDay, userHour, userMinute, userSecond;
        double plutoniumRemaining = 20000.0;
        //String[] DAYS_OF_THE_WEEK = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        System.out.println("TERRIFIC TIME MACHINE - CONTROL PANEL");
        System.out.println("-------------------------------------");
        do {

            //obtain day of the week from the zeller's algorithm
            dayOfTheWeek = returnDayOfWeek(month, year % 100, day, year / 100);
            if (month == 1 || month == 2) {
                dayOfTheWeek = dayOfTheWeek - 2;
            } else {
                System.out.println();
            }

            
            if (dayOfTheWeek == 0) {
                System.out.println("Current time is: " + "Saturday, " + month + "/" + day + "/" + year + ", " + hour + ":" + minute + ":" + second);
            } else if (dayOfTheWeek == 1) {
                System.out.println("Current time is: " + "Sunday, " + month + "/" + day + "/" + year + ", " + hour + ":" + minute + ":" + second);
            } else if (dayOfTheWeek == 2) {
                System.out.println("Current time is: " + "Monday, " + month + "/" + day + "/" + year + ", " + hour + ":" + minute + ":" + second);
            } else if (dayOfTheWeek == 3) {
                System.out.println("Current time is: " + "Tuesday, " + month + "/" + day + "/" + year + ", " + hour + ":" + minute + ":" + second);
            } else if (dayOfTheWeek == 4) {
                System.out.println("Current time is: " + "Wednesday, " + month + "/" + day + "/" + year + ", " + hour + ":" + minute + ":" + second);
            } else if (dayOfTheWeek == 5) {
                System.out.println("Current time is: " + "Thursday, " + month + "/" + day + "/" + year + ", " + hour + ":" + minute + ":" + second);
            } else {
                System.out.println("Current time is: " + "Friday, " + month + "/" + day + "/" + year + ", " + hour + ":" + minute + ":" + second);
            }

            System.out.println();
            System.out.println("Plutonium remaining is " + plutoniumRemaining + " grams");
            System.out.println();
            System.out.println("Enter 1 to input a destination time, or any other number to remain here");
            System.out.println();

            destination = input.nextInt();
            if (destination == 1) {

                System.out.print("Year(1753-2200): ");
                userYear = input.nextInt();

                //validate year entered by the user
                if (validateYear(userYear)) {
                    System.out.println();
                } else {
                    do {
                        System.out.print("Please enter a valid year(1753-2200): ");
                        userYear = input.nextInt();
                    } while (!(validateYear(userYear)));

                }
                System.out.print("Month(1-12) 1 for January, 2 for Feburary, etc: ");
                userMonth = input.nextInt();

                //validate the month entered by the user
                if (isMonthEnteredCorrect(userMonth)) {
                    System.out.println();
                } else {
                    do {
                        System.out.print("Please enter a valid month(1-12): ");
                        userMonth = input.nextInt();
                    } while (!(isMonthEnteredCorrect(userMonth)));
                }
                
                //check if your is leap
                //validate user month inputs to be within the range 
                if (isLeapYear(userYear)) {

                    if (userMonth == 2) {
                        do {
                            System.out.print("PLease enter a day (1-29): ");
                            userDay = input.nextInt();
                        } while (userDay < 1 || userDay > 29);
                    } else if (userMonth == 4 || userMonth == 6 || userMonth == 9 || userMonth == 11) {
                        do {
                            System.out.print("Please enter a day(1-30): ");
                            userDay = input.nextInt();
                        } while (userDay < 1 || userDay > 30);
                    } else {
                        do {
                            System.out.print("Please enter a day(1-31): ");
                            userDay = input.nextInt();
                        } while (userDay < 1 || userDay > 31);
                    }
                } else {
                    if (userMonth == 4 || userMonth == 6 || userMonth == 9 || userMonth == 11) {
                        do {
                            System.out.print("Please enter a day(1-30): ");
                            userDay = input.nextInt();
                        } while (userDay < 1 || userDay > 30);
                    } else if (userMonth == 2) {
                        do {
                            System.out.print("Please enter a day(1-28): ");
                            userDay = input.nextInt();
                        } while (userDay < 1 || userDay > 28);
                    } else {
                        do {
                            System.out.print("Please enter a day(1-31): ");
                            userDay = input.nextInt();
                        } while (userDay < 1 || userDay > 31);
                    }

                }

                System.out.print("Enter the hour(0-23): ");
                userHour = input.nextInt();
                //validate hours entered
                if (isHourEnteredCorrect(userHour)) {
                    System.out.println();
                } else {
                    do {
                        System.out.print("Please enter a valid hour(0-23): ");
                        userHour = input.nextInt();
                    } while (!(isHourEnteredCorrect(userHour)));
                }
                System.out.print("Enter the minute(0-59): ");
                userMinute = input.nextInt();
                
                //validate minutes entered
                if (isMinutesEnteredCorrect(userMinute)) {
                    System.out.println();
                } else {
                    do {
                        System.out.print("Please enter a valid minutes(0-59): ");
                        userMinute = input.nextInt();
                    } while (!(isMinutesEnteredCorrect(userMinute)));

                }
                System.out.print("Enter the second(0-59): ");
                userSecond = input.nextInt();
                
                //validate seconds entered
                if (isSecondsEnteredCorrect(userSecond)) {
                    System.out.println();
                } else {
                    do {
                        System.out.print("Please enter a valid second(0-59): ");
                        userSecond = input.nextInt();
                    } while (!(isSecondsEnteredCorrect(userSecond)));

                }
                
                //according to zellers algorithm january is 13 and feb is 14 of the prevoius year
                if (userMonth == 1) {
                    userMonth = 13;
                    userYear--;
                } else if (userMonth == 2) {
                    userMonth = 14;
                    userYear--;
                }

                //obtain day of the week from the zeller's algorithm
                dayOfTheWeek = returnDayOfWeek(userMonth, userYear % 100, userDay, userYear / 100);

                if (userMonth == 13) {
                    userMonth = 1;
                    userYear++;
                } else if (userMonth == 14) {
                    userMonth = 2;
                    userYear++;
                }
                
                //display destination time
                if (dayOfTheWeek == 0) {
                    System.out.println("Destination time is: Saturday, " + userMonth + "/" + userDay + "/" + userYear + ", " + userHour + ":" + userMinute + ":" + userSecond);
                } else if (dayOfTheWeek == 1) {
                    System.out.println("Desetnation time is:" + "Sunday, " + userMonth + "/" + userDay + "/" + userYear + ", " + userHour + ":" + userMinute + ":" + userSecond);
                } else if (dayOfTheWeek == 2) {
                    System.out.println("Destination time is:" + "Monday, " + userMonth + "/" + userDay + "/" + userYear + ", " + userHour + ":" + userMinute + ":" + userSecond);
                } else if (dayOfTheWeek == 3) {
                    System.out.println("Destination time is:" + "Tuesday, " + userMonth + "/" + userDay + "/" + userYear + ", " + userHour + ":" + userMinute + ":" + userSecond);
                } else if (dayOfTheWeek == 4) {
                    System.out.println("Destination time is:" + "Wednesday, " + userMonth + "/" + userDay + "/" + userYear + ", " + userHour + ":" + userMinute + ":" + userSecond);
                } else if (dayOfTheWeek == 5) {
                    System.out.println("Destination time is:" + "Thursday, " + userMonth + "/" + userDay + "/" + userYear + ", " + userHour + ":" + userMinute + ":" + userSecond);
                } else {
                    System.out.println("Destination time is:" + "Friday, " + userMonth + "/" + userDay + "/" + userYear + ", " + userHour + ":" + userMinute + ":" + userSecond);
                }

                int baseCost = 500;
                int seconds;
                int sumYear = 0;
                int sumMonth = 0;
                int sumDay = 0;
                int sumHour = 0;
                int sumMinute = 0;
                int sumSecond;
                int totalsMonth = 0;
                
                //calculate the number of seconds for the current date from the base date 1/1/1970
                for (int i = 1970; i < year; i++) {

                    if ((i % 400 == 0) || ((i % 4 == 0) && (i % 100 != 0))) {
                        sumYear = sumYear + 31622400;
                    } else {
                        sumYear = sumYear + 31536000;
                    }
                }

                for (int i = year, j = 1; j < month; j++) {
                    if (j == 4 || j == 6 || j == 9 || j == 11) {
                        sumMonth = sumMonth + 2592000;

                    }
                    if (j == 2) {
                        if ((i % 400 == 0) || ((i % 4 == 0) && (i % 100 != 0))) {
                            sumMonth = sumMonth + 2505600;
                        } else {
                            sumMonth = sumMonth + 2419200;
                        }
                    } else {
                        sumMonth = sumMonth + 2678400;
                    }

                }
                for (int k = 1; k < day; k++) {
                    sumDay = sumDay + 86400;
                }
                for (int h = 0; h < hour; h++) {
                    sumHour = sumHour + 3600;
                }
                for (int m = 0; m < minute; m++) {
                    sumMinute = sumMinute + 60;
                }

                int currentSeconds = sumYear + sumMonth + sumDay + sumHour + sumMinute + second;
                sumYear = 0;
                sumMonth = 0;
                sumDay = 0;
                sumHour = 0;
                sumMinute = 0;

                //calculate the number to seconds to the destination date from the base date 1/1/1970
                for (int i = 1970; i < userYear; i++) {

                    if ((i % 400 == 0) || ((i % 4 == 0) && (i % 100 != 0))) {
                        sumYear = sumYear + 31622400;
                    } else {
                        sumYear = sumYear + 31536000;
                    }
                }
                for (int i = year, j = 1; j < userMonth; j++) {
                    if (j == 4 || j == 6 || j == 9 || j == 11) {
                        sumMonth = sumMonth + 2592000;

                    }
                    if (j == 2) {
                        if ((i % 400 == 0) || ((i % 4 == 0) && (i % 100 != 0))) {
                            sumMonth = sumMonth + 2505600;
                        } else {
                            sumMonth = sumMonth + 2419200;
                        }
                    } else {
                        sumMonth = sumMonth + 2678400;
                    }

                }
                for (int k = 1; k < userDay; k++) {
                    sumDay = sumDay + 86400;
                }
                for (int h = 0; h < userHour; h++) {
                    sumHour = sumHour + 3600;
                }
                for (int m = 0; m < userMinute; m++) {
                    sumMinute = sumMinute + 60;
                }
                int desetnationSecond = sumYear + sumMonth + sumDay + sumHour + sumMinute + userSecond;
                
                //get the absolute difference between the current seconds and the destination date 
                int totalSeconds = Math.abs((currentSeconds - desetnationSecond));

                final double FIRST_CONSTANT = 0.005;  //Travel up to 94,608,000 seconds: 94,608,000 * 0.005 
                final double SECOND_CONSTANT = 0.002; //Travel up to 283,824,000 seconds: (283,824,000 – 94,608,000) * 0.002 
                final double THIRD_CONSTANT = 0.001; //Travel beyond 283,824,000 seconds: (300,000,000 – 283,824,000) * 0.001 
                double pl;
                double pl2;
                double pl3;
                int carPlutonium = 20000;
                int userConfirmation;
                
                //Travel up to 94,608,000 seconds
                if (totalSeconds <= 94608000) {
                    pl = baseCost + ((FIRST_CONSTANT * (totalSeconds)) / 1000);
                    System.out.println("Seconds to travel:  " + totalSeconds);
                    System.out.println("The cost of plutonium needed is: " + pl + "grams");
                    System.out.println();
                    double roundpl = (pl * 2);
                    if (carPlutonium < pl) {
                        System.out.println("Not enought plutonium for that trip");
                        System.out.println();
                        System.out.println("Please, add more plutonium before attempting");
                        System.out.println();
                        System.out.println("---------------------------------------------------");
                        System.out.println(" ");
                    }

                    if (carPlutonium >= pl) {
                        if (roundpl > carPlutonium) {
                            System.out.println(" Not enought plutonium for a round trip");
                            System.out.println("Press 0 to confirm or any other number to cancel");
                            userConfirmation = input.nextInt();

                        } else {
                            System.out.println("Press 0 to confirm or any other number to cancel");
                            userConfirmation = input.nextInt();
                        }

                        if (userConfirmation == 0) {
                            System.out.println("Have fun!");
                            System.out.println("---------------------------------------------------");
                            System.out.println(" ");
                            plutoniumRemaining = (plutoniumRemaining - pl);
                        } else {
                            System.out.println("---------------------------------------------------");
                            System.out.println(" ");
                            System.out.println();
                            System.out.println("Plutonium remaining is " + plutoniumRemaining + " grams");
                        }
                    }
                }
                
                //Travel up to 94,608,000 seconds 283824000
                if (94608000 < totalSeconds && totalSeconds <= 283824000) {
                    pl2 = baseCost + ((SECOND_CONSTANT * (totalSeconds - 94608000) + (94608000 * FIRST_CONSTANT)) / 1000);
                    System.out.println("Seconds to travel:  " + totalSeconds);
                    System.out.println("The cost of plutonium needed is: " + pl2 + " grams");
                    System.out.println();
                    double roundpl2 = (pl2 * 2);
                    if (carPlutonium < pl2) {
                        System.out.println("Not enought plutonium for that trip");
                        System.out.println();
                        System.out.println("Please, add more plutonium before attempting");
                        System.out.println();
                        System.out.println("---------------------------------------------------");
                        System.out.println(" ");
                    }

                    if (carPlutonium >= pl2) {
                        if (roundpl2 > carPlutonium) {
                            System.out.println(" Not enought plutonium for a round trip");
                            System.out.println();
                            System.out.println("Press 1 to confirm or any other number to cancel");
                            userConfirmation = input.nextInt();

                        } else {
                            System.out.println("Press 1 to confirm or any other number to cancel");
                            userConfirmation = input.nextInt();
                        }

                        if (userConfirmation == 1) {
                            System.out.println("Have fun");
                            System.out.println("---------------------------------------------------");
                            System.out.println(" ");
                            plutoniumRemaining = (plutoniumRemaining - pl2);
                        } else {
                            System.out.println("---------------------------------------------------");
                            System.out.println(" ");
                            System.out.println();
                            System.out.println("Plutonium remaining is " + plutoniumRemaining + " grams");
                        }
                    }
                }
                
                //Travel beyond 283,824,000 seconds
                if (totalSeconds > 283824000) {
                    pl3 = baseCost + ((94608000 * 0.005) + ((283824000 - 94608000) * SECOND_CONSTANT) + (THIRD_CONSTANT * (totalSeconds - 283824000)) / 1000);
                    System.out.println("Seconds to travel:  " + totalSeconds);
                    System.out.println("The cost of plutonium needed is: " + pl3 + " grams");
                    System.out.println();
                    double roundpl3 = (pl3 * 2);
                    if (carPlutonium < pl3) {
                        System.out.println("Not enought plutonium for that trip");
                        System.out.println();
                        System.out.println("Please add more plutonium before attempting");
                        System.out.println();

                    }

                    if (carPlutonium >= pl3) {
                        if (roundpl3 > carPlutonium) {
                            System.out.println(" Not enought plutonium for a round trip");
                            System.out.println();
                            System.out.println("Press 1 to confirm or any other number to cancel");
                            userConfirmation = input.nextInt();

                        } else {
                            System.out.println("Press 1 to confirm or any other number to cancel");
                            userConfirmation = input.nextInt();
                        }

                        if (userConfirmation == 1) {
                            System.out.println("Enjoy your stay");
                            System.out.println("---------------------------------------------------");
                            System.out.println(" ");
                            plutoniumRemaining = (plutoniumRemaining - pl3);
                        } else {
                            System.out.println("---------------------------------------------------");
                            System.out.println(" ");
                            System.out.println();
                            System.out.println("Plutonium remaining is " + plutoniumRemaining + " grams");
                        }
                    }
                }
                year = userYear;
                month = userMonth;
                day = userDay;
                second = userSecond;
                hour = userHour;
                minute = userMinute;
            } else {
                System.out.println("Have fun!");
            }

        } while (destination == 1);
    }

    //this method corresponds to zeller's congurence algorithm
    public static int returnDayOfWeek(int month, int year, int dayOfMonth, int centuary) {
        int h = (((dayOfMonth + (13 * (month + 1)) / 5) + year + (year / 4) + (centuary / 4) + (5 * centuary)) % 7);
        return h;
    }

    //validates year, returns false when the method executes successfully
    public static boolean validateYear(int year) {
        return year >= 1753 && year <= 2200;
    }

    //check if year is leap or not
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    //check hour and if it matches the character sequence
    public static boolean isHourEnteredCorrect(int hour) {
        return hour >= 0 && hour < 24;
    }

    //validates minutes entered
    public static boolean isMinutesEnteredCorrect(int minutes) {
        return minutes >= 0 && minutes < 60;
    }

    //validates seconds entered
    public static boolean isSecondsEnteredCorrect(int seconds) {
        return seconds >= 0 && seconds < 60;
    }

    //validates month entered
    public static boolean isMonthEnteredCorrect(int month) {
        return month >= 1 && month <= 12;
    }

}
