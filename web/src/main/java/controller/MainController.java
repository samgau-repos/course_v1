package controller;

import com.samgau.start.model.Employee;
import com.samgau.start.model.dto.EmployeeDTO;
import com.samgau.start.service.api.EmployeeService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chingiskhan on 27.03.2017.
 */
@ManagedBean(name = "mainController")
@ViewScoped
public class MainController {

    private static final List<String> workers = new ArrayList<>();
    private List<EmployeeDTO> workersDTO = null;
    private EmployeeDTO employeeDTO = null;

    @EJB
    private EmployeeService employeeService;

    public MainController() {
        prepareEmployeeDTO();
    }

    public List<String> getWorkers() {
        return workers;
    }

    public List<EmployeeDTO> getWorkersDTO() {
        if (workersDTO == null) {
            workersDTO = employeeService.getAll();
        }
        return workersDTO;
    }

    public void prepareEmployeeDTO() {
        employeeDTO = new EmployeeDTO();
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public void saveEmployee() {
        employeeService.create(employeeDTO);
        // ставим workersDTO = null,
        workersDTO = null;
        // После окончания вызова текущего метода saveEmployee() в main.xhtml происходит update="workersList"
        // перерисовывается часть страницы, но так как workersList берёт значения из value="#{mainController.workersDTO}"
        // вызывается метод getWorkersDTO, который видит что workersDTO == null и
        // запрашивает данные с БД выполняя employeeService.getAll(); таким образом на UI мы видим последнего добавленого
        // сотрудника
    }

}