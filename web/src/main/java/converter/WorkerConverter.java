package converter;

import com.samgau.start.model.Employee;
import com.samgau.start.model.dto.EmployeeDTO;
import controller.MainController;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.List;

/**
 * Created by Chingiskhan on 05.04.2017.
 */
@FacesConverter("workerConverter")
public class WorkerConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                MainController mainController = (MainController) facesContext.getELContext()
                                .getELResolver()
                                .getValue(facesContext.getELContext(), null, "mainController");
                List<EmployeeDTO> workers = mainController.getWorkersDTO();
                for (int i=0, s = workers.size(); i < s; i++) {
                    if (workers.get(i).getId().equals(Long.valueOf(value))) {
                        return workers.get(i);
                    }
                }
                return null;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid worker."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        if (object != null) {
            return String.valueOf(((EmployeeDTO) object).getId());
        }
        return null;
    }
}
