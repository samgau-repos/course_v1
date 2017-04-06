package controller;

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
    private final int MODE_CREATE = 1;
    private final int MODE_EDIT = 2;
    private final int MODE_VIEW = 3;
    private int currentMode;

    @EJB
    private EmployeeService employeeService;

    public MainController() {
        currentMode = MODE_VIEW;
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
        currentMode = MODE_CREATE;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public void saveEmployee() {
        if (currentMode == MODE_CREATE) {
            employeeService.create(employeeDTO);
        } else if (currentMode == MODE_EDIT) {
            employeeService.update(employeeDTO);
        }
        // ставим workersDTO = null,
        workersDTO = null;
        // После окончания вызова текущего метода saveEmployee() в main.xhtml происходит update="workersList"
        // перерисовывается часть страницы, но так как workersList берёт значения из value="#{mainController.workersDTO}"
        // вызывается метод getWorkersDTO, который видит что workersDTO == null и
        // запрашивает данные с БД выполняя employeeService.getAll(); таким образом на UI мы видим последнего добавленого
        // сотрудника
        currentMode = MODE_VIEW;
    }

    public int getCurrentMode() {
        return this.currentMode;
    }

    public boolean getIsReadonly() {
        return this.currentMode == 3;
    }

    public String getTitle() {
        String result;
        switch (this.currentMode) {
            case 1:
                result = "Добавить сотрудника";
                break;
            case 2:
                result = "Редактировать сотрудника";
                break;
            case 3:
                result = "Просмотр сотрудника";
                break;
            default:
                result = "Неизвестный режим";
        }
        return result;
    }

    public void modeEdit() {
        currentMode = MODE_EDIT;
    }

    public void modeView() {
        currentMode = MODE_VIEW;
    }

    public void removeEmployee(EmployeeDTO employee) {
        employeeService.removeEmployee(employee);
        workersDTO = null;
    }

    public List<EmployeeDTO> completeName(String query) {
        List<EmployeeDTO> workers = getWorkersDTO();
        List<EmployeeDTO> results = new ArrayList<>();
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getName().contains(query)) {
                results.add(workers.get(i));
            }
        }
        return results;
    }

}