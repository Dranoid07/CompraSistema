package com.jp.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.jp.RncValidator")
public class RncValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String rnc = (String) value;
        if (!validarRNC(rnc)) {
            FacesMessage msg = new FacesMessage("Formato incorrecto.", "RNC inválido.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    public static boolean validarRNC(String rnc) {
        char[] peso = { '7', '9', '8', '6', '5', '4', '3', '2' };
        int suma = 0;
        int division = 0;

        if (rnc.length() != 9)
            return false;
        else {
            for (int i = 0; i < 8; i++) {
                if (!Character.isDigit(rnc.charAt(i)))
                    return false;

                suma += Character.getNumericValue(rnc.charAt(i)) * Character.getNumericValue(peso[i]);
            }

            division = suma / 11;
            int resto = suma - (division * 11);
            int digito = 0;

            if (resto == 0)
                digito = 2;
            else if (resto == 1)
                digito = 1;
            else
                digito = 11 - resto;

            return digito == Character.getNumericValue(rnc.charAt(8));
        }
    }
}
