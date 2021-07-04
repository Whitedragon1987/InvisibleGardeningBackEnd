//package com.example.invisiblegardening.services;
//
//import com.example.invisiblegardening.models.Machine;
//import com.example.invisiblegardening.repositories.MachineRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class MachineServiceTest {
//
//    @Mock
//    MachineRepository machineRepository;
//
//    @InjectMocks
//    private MachineServiceImpl machineService;
//
//    @Captor
//    ArgumentCaptor<Machine> machineCaptor;
//
//    @Test
//    public void getMachineTest() {
//        Machine machine = new Machine();
//        machine.setId(1L);
//
//        machineService.getMachine(1L);
//    }
//}