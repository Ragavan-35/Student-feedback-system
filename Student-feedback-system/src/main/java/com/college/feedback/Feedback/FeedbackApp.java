package com.college.feedback.Feedback;


import java.sql.SQLException;
import java.util.*;

public class FeedbackApp {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        FeedbackDAO dao = new FeedbackDAO();

        while (true) {
            System.out.println("\n1. Add Feedback\n2. View All\n3. View by ID\n4. Update\n5. Delete\n6. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Feedback fb = new Feedback();
                    System.out.print("ID: ");
                    fb.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Student Name: ");
                    fb.setStudentName(sc.nextLine());
                    System.out.print("Feedback: ");
                    fb.setFeedback(sc.nextLine());
                    dao.createFeedback(fb);
                    System.out.println("Feedback added.");
                    break;

                case 2:
                    List<Feedback> all = dao.getAllFeedback();
                    for (Feedback f : all) {
                        System.out.println(f.getId() + " - " + f.getStudentName() + ": " + f.getFeedback());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Feedback found = dao.getFeedbackById(sc.nextInt());
                    if (found != null) {
                        System.out.println("Name: " + found.getStudentName());
                        System.out.println("Feedback: " + found.getFeedback());
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 4:
                    Feedback update = new Feedback();
                    System.out.print("ID: ");
                    update.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("New Name: ");
                    update.setStudentName(sc.nextLine());
                    System.out.print("New Feedback: ");
                    update.setFeedback(sc.nextLine());
                    if (dao.updateFeedback(update)) {
                        System.out.println("Updated.");
                    } else {
                        System.out.println("Update failed.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    if (dao.deleteFeedback(sc.nextInt())) {
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Delete failed.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
