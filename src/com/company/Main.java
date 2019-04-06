package com.company;

import com.company.domain.Student;
import com.company.repository.AbstractCRUDRepository;
import com.company.repository.StudentRepository;
import com.company.validation.StudentValidator;
import com.company.validation.ValidationException;
import com.company.validation.Validator;

public class Main {
    public static void main(String[] args) {
        Validator<Student> validator = new StudentValidator();
        AbstractCRUDRepository<String, Student> repository = new StudentRepository(validator);

        try {
            repository.save(new Student("1", "ana", 111));
            repository.save(new Student("2", "maria", 112));
            repository.save(new Student("", "ana", 223));
            repository.save(new Student("3", "", 224));
            repository.save(new Student(null, "ion", 222));
        }
        catch (ValidationException ve) {
            System.out.println(ve.getMessage());
        }

        try {
            repository.update(new Student("1", "maria",  111));
            repository.update(new Student("10", "ana", 123));
        }
        catch (ValidationException ve) {
            System.out.println(ve.getMessage());
        }

        try {
            repository.delete("1");
            repository.delete("12");
        }
        catch (ValidationException ve) {
            System.out.println(ve.getMessage());
        }
    }
}
