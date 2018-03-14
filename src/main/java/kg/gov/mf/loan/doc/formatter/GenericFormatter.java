package kg.gov.mf.loan.doc.formatter;

import kg.gov.mf.loan.doc.model.GenericModel;
import kg.gov.mf.loan.doc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Locale;

public class GenericFormatter<E> implements Formatter<E> {

    @Autowired
    GenericService<E> service;

    @Override
    public E parse(String text, Locale locale) throws ParseException {
        Long id = Long.valueOf(text);
        return this.service.findById(id);
    }

    @Override
    public String print(E object, Locale locale) {
        return (object != null ? String.valueOf(((GenericModel)object).getId()) : "");
    }


}
