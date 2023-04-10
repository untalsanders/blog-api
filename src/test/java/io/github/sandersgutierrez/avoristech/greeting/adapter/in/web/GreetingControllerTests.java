package io.github.sandersgutierrez.avoristech.greeting.adapter.in.web;

import io.github.sandersgutierrez.avoristech.greeting.application.port.in.GreetingPort;
import io.github.sandersgutierrez.avoristech.greeting.domain.Greeting;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingPort greetingPort;

    @Autowired
    private GreetingController greetingController;

    @Test
    public void contextLoads() {
        assertThat(greetingController).isNotNull();
    }

    @Test
    @Disabled
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello World!"));
    }

    @Test
    @Disabled
    public void withParamGreetingShouldReturnCustomMessage() throws Exception {
        this.mockMvc.perform(get("/greeting").param("name", "Sanders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello Sanders!"));
    }

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        Greeting greeting = new Greeting(new AtomicLong().incrementAndGet(), "Hello Sanders!");
        when(greetingPort.greet("Sanders")).thenReturn(greeting);
        this.mockMvc.perform(get("/greeting").param("name", "Sanders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello Sanders!"));
        verify(greetingPort, times(1)).greet("Sanders");
    }
}
