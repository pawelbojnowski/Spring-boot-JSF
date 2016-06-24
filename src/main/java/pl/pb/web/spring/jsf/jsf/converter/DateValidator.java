package pl.pb.web.spring.jsf.jsf.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dateConverter")
public class DateValidator implements Converter {

    SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/YYYY");

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (s != null && !s.isEmpty()) {
            try {
                return dataFormat.parse(s);
            } catch (ParseException e) {
              //ther shoube some thing
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        if (o != null) {
            Date date = (Date) o;
            return dataFormat.format(date);
        } else {
            return "";
        }

    }
}
