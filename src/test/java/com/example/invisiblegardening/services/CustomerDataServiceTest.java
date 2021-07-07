package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Company;
import com.example.invisiblegardening.models.CustomerData;
import com.example.invisiblegardening.repositories.CompanyRepository;
import com.example.invisiblegardening.repositories.CustomerDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerDataServiceTest {

    @Mock
    CustomerDataRepository customerDataRepository;

    @Mock
    CompanyRepository companyRepository;

    @InjectMocks
    private CustomerDataServiceImpl customerDataService;

    @Captor
    ArgumentCaptor<CustomerData> customerDataCaptor;

    @Test
    public void getCustomerDataTest() {
        CustomerData customerData = new CustomerData();
        customerData.setCustomersName("test");
        when(customerDataRepository.findById(1L)).thenReturn(Optional.of(customerData));

        var customerData1 =customerDataService.getCustomerData(1L);
        assertThat(customerData1.getCustomersName()).isEqualTo("test");
    }

    @Test
    public void getCustomerDataExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> customerDataService.getCustomerData(null));
    }

    @Test
    public void getCustomerDatasTest() {
        List<CustomerData> testCustomerDatas = new ArrayList<>();
        CustomerData customerData1 = new CustomerData();
        customerData1.setId(1L);
        customerData1.setCustomersName("kraan");
        CustomerData customerData2 = new CustomerData();
        customerData2.setId(2L);
        customerData2.setCustomersName("trilplaat");
        CustomerData customerData3 = new CustomerData();
        customerData3.setId(3L);
        customerData3.setCustomersName("shovel");

        testCustomerDatas.add(customerData1);
        testCustomerDatas.add(customerData2);
        testCustomerDatas.add(customerData3);

        when(customerDataRepository.findAll()).thenReturn(testCustomerDatas);

        customerDataService.getCustomerDatas();

        verify(customerDataRepository, times(1)).findAll();

        assertThat(testCustomerDatas.size()).isEqualTo(3);
        assertThat(testCustomerDatas.get(0)).isEqualTo(customerData1);
        assertThat(testCustomerDatas.get(1)).isEqualTo(customerData2);
        assertThat(testCustomerDatas.get(2)).isEqualTo(customerData3);
    }


    @Test
    public void saveCustomerDataTest() {
        CustomerData customerData = new CustomerData();
        customerData.setId(1L);
        customerData.setCustomersName("test");

        customerDataRepository.save(customerData);

        verify(customerDataRepository, times(1)).save(customerDataCaptor.capture());
        var customerData1 = customerDataCaptor.getValue();

        assertThat(customerData1.getCustomersName()).isEqualTo("test");
        assertThat(customerData1.getId()).isEqualTo(1);
    }


    @Test
    public void updateCustomerDataTest() {
        CustomerData customerData1 = new CustomerData();
        customerData1.setId(1L);
        customerData1.setCustomersName("test");
        when(customerDataRepository.findById(1L)).thenReturn(Optional.of(customerData1));

        customerData1.setCustomersName("test1");
        customerDataService.updateCustomerData(1L, customerData1);

        verify(customerDataRepository).save(customerData1);
        assertThat(customerData1.getId()).isEqualTo(1);
        assertThat(customerData1.getCustomersName()).isEqualTo("test1");
    }

    @Test
    public void updateCustomerDataExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> customerDataService.getCustomerData(null));
    }

    @Test
    public void assignCompanyToCustomerDataTest() {
        CustomerData customerData = new CustomerData();
        customerData.setId(1L);
        when(customerDataRepository.findById(1L)).thenReturn(Optional.of(customerData));

        Company company = new Company();
        company.setId(1L);
        company.setCompanyName("test");
        when(companyRepository.findById(1L)).thenReturn(Optional.of(company));

        customerDataService.assignCompanyToCustomerData(1L,1L);

        customerData.setCompany(company);
        verify(customerDataRepository, times(1)).save(customerDataCaptor.capture());

        var customerData1 = customerDataCaptor.getValue();

        assertThat(customerData1.getId()).isEqualTo(1);
        assertThat(customerData1.getCompany().getId()).isEqualTo(1);
        assertThat(customerData1.getCompany().getCompanyName()).isEqualTo("test");
    }

    @Test
    public void deleteCustomerDataTest() {
        CustomerData customerData1 = new CustomerData();
        customerData1.setId(1L);
        customerData1.setCustomersName("test");

        customerDataRepository.delete(customerData1);

        customerDataService.deleteCustomerData(1L);

        verify(customerDataRepository, times(1)).delete(customerData1);
    }
}
