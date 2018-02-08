package br.com.tomas.example;

import br.com.tomas.example.vehicle.VehicleRepository;
import br.com.tomas.example.vehicle.type.VehicleTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExampleApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    public VehicleRepository vehicleRepository;
    @Autowired
    public VehicleTypeRepository vehicleTypeRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldCreateVehicle() throws Exception {
        mockMvc.perform(get("/vehicles")).andExpect(status().isOk());
    }

}
