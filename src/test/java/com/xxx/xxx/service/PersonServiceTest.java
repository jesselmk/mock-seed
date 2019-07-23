package com.xxx.xxx.service;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.utils.SalaryCalculator;
import com.xxx.xxx.utils.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(PowerMockRunner.class)
@PrepareForTest({TimeUnit.class, SalaryCalculator.class})
public class PersonServiceTest {
    private PersonService personService;

    @Before
    public void setUp() throws Exception{
        personService = new PersonService();
    }
    @Test
    public void should_return_James() {
        // given
        String name = "James";
        PersonRequest personRequest = new PersonRequest(name);
        PowerMockito.mockStatic(TimeUnit.class);
//        PowerMockito.mockStatic(SalaryCalculator.class);
//        BigDecimal value = BigDecimal.valueOf(20);
//        PowerMockito.when(SalaryCalculator.calculate(new BigDecimal(10))).thenCallRealMethod();
        PowerMockito.doNothing().when(TimeUnit.class);
        // when
        Person  person = personService.find(personRequest);
        // then
        assertThat(person).isEqualToComparingFieldByField(new Person("Merson","James", BigDecimal.valueOf(20)));
    }
    @Test
    public void should_return_none() {
        //given
        String name = "James1";
        PersonRequest personRequest = new PersonRequest(name);
        // when
        Person person = personService.find(personRequest);

        //then
        assertThat(person).isEqualToComparingFieldByField(new Person("None","None",BigDecimal.ZERO));

    }
}