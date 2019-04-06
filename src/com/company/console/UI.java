package com.company.console;

import com.company.domain.Student;
import com.company.domain.Tema;
import com.company.service.Service;

import java.util.Scanner;

public class UI {
    private Service service;

    public UI(Service service) {
        this.service = service;
    }

    public void printMenu() {
        System.out.println("1. Afiseaza toti studentii.");
        System.out.println("2. Adauga un nou student.");
        System.out.println("3. Sterge un student existent.");
        System.out.println("4. Actualizeaza datele unui student.");

        System.out.println("5. Afiseaza toate temele.");
        System.out.println("6. Adauga o tema noua.");
        System.out.println("7. Sterge o tema existenta.");
        System.out.println("8. Prelungeste deadline-ul unei teme.");

        System.out.println("9. EXIT \n");
    }

    public void uiPrintAllStudents() {
        for(Student student : service.findAllStudents()) {
            System.out.println(student);
        }
    }

    public void uiPrintAllTeme() {
        for(Tema tema : service.findAllTeme()) {
            System.out.println(tema);
        }
    }

    public void uiSaveStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti ID-ul studentului: ");
        String id = scanner.nextLine();

        System.out.println("Introduceti numele studentului: ");
        String nume = scanner.nextLine();

        System.out.println("Introduceti grupa studentului: ");
        int grupa = scanner.nextInt();

        if (service.saveStudent(id, nume, grupa) != 0) {
            System.out.println("Student adaugat cu succes! \n");
        }
        else {
            System.out.println("Student existent sau invalid! \n");
        }
    }

    public void uiDeleteStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti ID-ul studentului: ");
        String id = scanner.nextLine();

        if (service.deleteStudent(id) != 0) {
            System.out.println("Student sters cu succes! \n");
        }
        else {
            System.out.println("Studentul nu exista! \n");
        }
    }

    public void uiUpdateStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti ID-ul studentului: ");
        String id = scanner.nextLine();

        System.out.println("Introduceti noul nume al studentului: ");
        String numeNou = scanner.nextLine();

        System.out.println("Introduceti noua grupa a studentului: ");
        int grupaNoua = scanner.nextInt();

        if (service.updateStudent(id, numeNou, grupaNoua) != 0) {
            System.out.println("Student actualizat cu succes! \n");
        }
        else {
            System.out.println("Studentul nu exista! \n");
        }
    }

    public void uiSaveTema() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti ID-ul temei: ");
        String id = scanner.nextLine();

        System.out.println("Introduceti o descriere a temei: ");
        String descriere = scanner.nextLine();

        System.out.println("Introduceti saptamana deadline a temei: ");
        int deadline = scanner.nextInt();

        System.out.println("Introduceti saptamana startline a temei: ");
        int startline = scanner.nextInt();

        if (service.saveTema(id, descriere, deadline, startline) != 0) {
            System.out.println("Tema adaugata cu succes! \n");
        }
        else {
            System.out.println("Tema existenta sau invalida! \n");
        }
    }

    public void uiDeleteTema() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti ID-ul temei: ");
        String id = scanner.nextLine();

        if (service.deleteTema(id) != 0) {
            System.out.println("Tema stearsa cu succes! \n");
        }
        else {
            System.out.println("Tema nu exista! \n");
        }
    }

    public void uiExtendDeadline() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti ID-ul temei: ");
        String id = scanner.nextLine();

        System.out.println("Introduceti numarul de saptamani adaugate la deadline: ");
        int nrWeeks = scanner.nextInt();

        if (service.extendDeadline(id, nrWeeks) != 0) {
            System.out.println("Deadline extins cu succes! \n");
        }
        else {
            System.out.println("Tema nu exista! \n");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int cmd = -1;

        printMenu();

        while(cmd != 0) {
            System.out.println("Introduceti comanda: ");
            cmd = scanner.nextInt();

            switch(cmd) {
                case 1:
                    uiPrintAllStudents();
                    break;
                case 2:
                    uiSaveStudent();
                    break;
                case 3:
                    uiDeleteStudent();
                    break;
                case 4:
                    uiUpdateStudent();
                    break;
                case 5:
                    uiPrintAllTeme();
                    break;
                case 6:
                    uiSaveTema();
                    break;
                case 7:
                    uiDeleteTema();
                    break;
                case 8:
                    uiExtendDeadline();
                    break;
                case 9:
                    cmd = 0;
                    break;
            }
        }
    }
}
