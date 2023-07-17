package pro.sky.skyspringemployee.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyspringemployee.model.Employee;
import pro.sky.skyspringemployee.repository.EmployeeBookRepository;
import pro.sky.skyspringemployee.services.api.EmployeeBookService;
import pro.sky.skyspringemployee.services.mapimpl.EmployeeBookServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EmployeeBookServiceImplTest {

    private EmployeeBookService service;
    @Mock
    private EmployeeBookRepository repositoryMock;

    @BeforeEach
    public void setUp() throws Exception {
        service = new EmployeeBookServiceImpl(repositoryMock);
    }

    @Test
    void shouldRunOneTimeAddEmployee() throws Exception {

        service.addEmployee("John", 1000, "IT");
        verify(repositoryMock, times(1)).saveEmployee(any());
    }

    @Test
    void shouldReturnCorrectAddedEmployeeName() throws Exception {
        Employee employee = new Employee("John", 1000, "IT");
        when(repositoryMock.saveEmployee(employee)).thenReturn(employee);

        String result = service.addEmployee("John", 1000, "IT");

        assertEquals(String.valueOf(employee), result);

    }

    @Test
    void shouldNotAddAlreadyExistingEmployee() throws Exception {

        when(repositoryMock.saveEmployee(any())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> service.addEmployee("John", 1000, "IT"));


    }

    @Test
    void shouldReturnCorrectDeletedEmployee() {
        Employee employee = new Employee("John", 1000, "IT");
        when(repositoryMock.removeEmployeeByName("John")).thenReturn(employee);

        String result = service.removeEmployeeByName("John");

        assertEquals(String.valueOf(employee), result);
    }

    @Test
    void shouldThrowExceptionWhenDeletingNonExistingEmployee() {
        when(repositoryMock.removeEmployeeByName("John")).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> service.removeEmployeeByName("John"));
    }


    @Test
    void shouldReturnCorrectFoundEmployee() {
        Employee employee = new Employee("John", 1000, "IT");
        when(repositoryMock.findEmployeeByName("John")).thenReturn(employee);

        String result = service.findEmployeeByName("John");

        assertEquals(String.valueOf(employee), result);
    }

    @Test
    void shouldThrowExceptionWhenFindingNonExistingEmployee() {
        when(repositoryMock.findEmployeeByName("John")).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> service.findEmployeeByName("John"));
    }


}
