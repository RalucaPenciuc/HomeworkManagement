package com.company.repository;

import com.company.domain.Tema;
import com.company.validation.Validator;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }

    public void extendDeadline(Tema tema, int noWeeks) {
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int currentWeek = date.get(weekFields.weekOfWeekBasedYear());

        if (currentWeek >= 39) {
            currentWeek = currentWeek - 39;
        }
        else {
            currentWeek = currentWeek + 12;
        }

        if (currentWeek <= tema.getDeadline()) {
            tema.setDeadline(tema.getDeadline() + noWeeks);
        }
    }
}

