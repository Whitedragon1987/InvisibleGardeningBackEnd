package com.example.invisiblegardening.services;

import com.example.invisiblegardening.exeptions.RecordNotFoundException;
import com.example.invisiblegardening.models.Company;
import com.example.invisiblegardening.repositories.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @Mock
    CompanyRepository companyRepository;

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Captor
    ArgumentCaptor<Company> companyCaptor;

    @Test
    public void getCompanyTest() {
        Company company = new Company();
        company.setCompanyName("test");
        when(companyRepository.findById(1L)).thenReturn(Optional.of(company));

        var company1 =companyService.getCompany(1L);
        assertThat(company1.getCompanyName()).isEqualTo("test");
    }

    @Test
    public void getCompanyExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> companyService.getCompany(null));
    }

    @Test
    public void saveCompanyTest() {
        Company company = new Company();
        company.setId(1L);
        company.setCompanyName("test");

        companyRepository.save(company);

        verify(companyRepository, times(1)).save(companyCaptor.capture());
        var company1 = companyCaptor.getValue();

        assertThat(company1.getCompanyName()).isEqualTo("test");
        assertThat(company1.getId()).isEqualTo(1);
    }


    @Test
    public void updateCompanyTest() {
        Company company1 = new Company();
        company1.setId(1L);
        company1.setCompanyName("test");
        when(companyRepository.findById(1L)).thenReturn(Optional.of(company1));

        company1.setCompanyName("test1");
        companyService.updateCompany(1L, company1);

        verify(companyRepository).save(company1);

        assertThat(company1.getId()).isEqualTo(1);
        assertThat(company1.getCompanyName()).isEqualTo("test1");
    }

    @Test
    public void updateCompanyExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> companyService.getCompany(null));
    }

    @Test
    public void deleteCompanyTest() {
        Company company1 = new Company();
        company1.setId(1L);
        company1.setCompanyName("test");

        companyRepository.delete(company1);

        companyService.deleteCompany(1L);

        verify(companyRepository, times(1)).delete(company1);
    }
}



