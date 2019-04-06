package com.company.validation;

import com.company.domain.Student;

public class StudentValidator implements Validator<Student> {
    public void validate(Student student) throws ValidationException {
        if (student.getID() == null || student.getID().equals("")) {
            throw new ValidationException("ID invalid! \n");
        }
        else {
            if (student.getNume() == null || student.getNume().equals("")) {
                throw new ValidationException("Nume invalid! \n");
            }
            else {
                if (student.getGrupa() <= 110 || student.getGrupa() >= 938) {
                    throw new ValidationException("Grupa invalida! \n");
                }
            }
        }
    }
}

