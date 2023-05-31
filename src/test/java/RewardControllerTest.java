import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.RewardApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = RewardApplication.class)
@AutoConfigureMockMvc
public class RewardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAll() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/reward")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int expectedStatus = 200; // expect response code

        int actualStatus = result.getResponse().getStatus();

        assertEquals(expectedStatus, actualStatus);

    }
}