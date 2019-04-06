package com.company;

import com.company.console.UI;
import com.company.domain.Student;
import com.company.domain.Tema;
import com.company.repository.StudentFileRepository;
import com.company.repository.TemaFileRepository;
import com.company.service.Service;
import com.company.validation.StudentValidator;
import com.company.validation.TemaValidator;
import com.company.validation.Validator;

public class Main {
    public static void main(String[] args) {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        StudentFileRepository fileRepository = new StudentFileRepository(studentValidator, "studenti.txt");
        TemaFileRepository fileRepository2 = new TemaFileRepository(temaValidator, "teme.txt");

        Service service = new Service(fileRepository, fileRepository2);
        UI consola = new UI(service);
        consola.run();
    }
}
