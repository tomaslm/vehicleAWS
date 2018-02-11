package br.com.tomas.example.vehicle.type;

import br.com.tomas.example.vehicle.VehicleRepository;
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
public class VehicleTypeTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    public VehicleRepository vehicleRepository;
    @Autowired
    public VehicleTypeRepository vehicleTypeRepository;

    final String jsonNullName = "{"
            + "\"description\":\"description\"}";
    final String jsonShortName = "{\"name\":\"A\","
            + "\"description\":\"description\"}";

    @Test(expected = Exception.class)
    public void testNullName() throws Exception {
        mockMvc.perform(post("/vehicleTypes").contentType(MediaType.APPLICATION_JSON)
                .content(jsonNullName)).andExpect(status().isBadRequest());
    }

    @Test(expected = Exception.class)
    public void testShortName() throws Exception {
        mockMvc.perform(post("/vehicleTypes").contentType(MediaType.APPLICATION_JSON)
                .content(jsonShortName)).andExpect(status().isBadRequest());
    }
}
