package br.com.tomas.example.vehicle;

import br.com.tomas.example.vehicle.type.VehicleTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Tomas
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    public VehicleRepository vehicleRepository;
    @Autowired
    public VehicleTypeRepository vehicleTypeRepository;

    final String jsonNullName = "{"
            + "\"description\":\"description\","
            + "\"type\":0,"
            + "\"plate\":\"AAA-0000\","
            + "}";
    final String jsonShortName = "{"
            + "\"name\":\"A\","
            + "\"description\":\"description\","
            + "\"type\":0,"
            + "\"plate\":\"AAA-0000\","
            + "}";

    @Test
    public void testNullName() throws Exception {
        mockMvc.perform(post("/vehicles").contentType(MediaType.APPLICATION_JSON)
                .content(jsonNullName)).andExpect(status().isBadRequest());
    }

    @Test
    public void testShortName() throws Exception {
        mockMvc.perform(post("/vehicles").contentType(MediaType.APPLICATION_JSON)
                .content(jsonShortName)).andExpect(status().isBadRequest());
    }
}
