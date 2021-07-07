package com.example.invisiblegardening.services;

import com.example.invisiblegardening.models.*;
import com.example.invisiblegardening.repositories.CustomerDataRepository;
import com.example.invisiblegardening.repositories.CustomerRequestRepository;
import com.example.invisiblegardening.repositories.JobRepository;
import com.example.invisiblegardening.repositories.MachineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerRequestServiceTest {

    @Mock
    CustomerDataRepository customerDataRepository;

    @Mock
    MachineRepository machineRepository;

    @Mock
    JobRepository jobRepository;

    @Mock
    CustomerRequestRepository customerRequestRepository;

    @InjectMocks
    private CustomerRequestServiceImpl customerRequestService;

    @Captor
    ArgumentCaptor<CustomerRequest> customerRequestCaptor;

    @Captor
    ArgumentCaptor<CustomerRequest> customerRequestForCaptor;

    @Test
    public void planCustomerRequestTest() {
        var testMachine = new Machine();
        testMachine.setId(1L);
        testMachine.setMachineName("test machine");

        var testCustomerData = new CustomerData();
        testCustomerData.setId(1L);
        testCustomerData.setCustomersName("Klaas");

        var testJob = new Job();
        testJob.setId(1L);
        testJob.setJobName("test klus");

        when(machineRepository.findById(1L)).thenReturn(Optional.of(testMachine));
        when(jobRepository.findById(1L)).thenReturn(Optional.of(testJob));
        when(customerDataRepository.findById(1L)).thenReturn(Optional.of(testCustomerData));

        customerRequestService.planCustomerRequest(1L, 1L, 1L, LocalDateTime.parse("2021-09-12T08:00:00"), LocalDateTime.parse("2021-09-14T14:00:00"));

        verify(customerRequestRepository, times(1)).save(customerRequestCaptor.capture());
        var customerRequest = customerRequestCaptor.getValue();

        assertThat(customerRequest.getMachine().getMachineName()).isEqualTo("test machine");
        assertThat(customerRequest.getCustomerData().getCustomersName()).isEqualTo("Klaas");
        assertThat(customerRequest.getJob().getJobName()).isEqualTo("test klus");
        assertThat(customerRequest.getRequestedStartTime()).isEqualTo("2021-09-12T08:00:00");
        assertThat(customerRequest.getRequestedEndTime()).isEqualTo("2021-09-14T14:00:00");
        assertThat(customerRequest.getStatus()).isEqualTo(RequestStatus.PLANNED);
    }
}