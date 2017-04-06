package unit;

import com.samgau.start.common.util.TransferUtil;
import com.samgau.start.model.Employee;
import com.samgau.start.model.dto.EmployeeDTO;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Chingiskhan on 03.04.2017.
 */
public class TransferUtilTest {

    @Test
    public void testGetAsEmployeeDTO() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("2");
        employee.setAddress("3");
        employee.setSkype("4");
        employee.setPhone("5");
        employee.setMail("6");

        EmployeeDTO employeeDTO = TransferUtil.getAsEmployeeDTO(employee);
        Assert.assertEquals(employeeDTO.getName(), "2");
        Assert.assertEquals(employeeDTO.getAddress(), "3");
        Assert.assertEquals(employeeDTO.getSkype(), "4");
        Assert.assertEquals(employeeDTO.getPhone(), "5");
        Assert.assertEquals(employeeDTO.getMail(), "6");
    }

}
