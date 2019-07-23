package com.xxx.xxx.controller;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
    @InjectMocks
    PersonController personController;

    @Mock
    PersonService personService;

    @Test
    public void should_Get_Name() {
        // given
        String name = "Merson";
        given(personService.find(argThat(arg -> name.equals(arg.getName()))))
                .willReturn(new Person("Merson", "James", BigDecimal.TEN));
        // when
         String nameResult = personController.getName(name);
        // then
        assertThat(nameResult).isEqualTo(new String("Merson,James"));
    }
}