package projetojava.grupo4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import projetojava.grupo4.Grupo4Application;
import projetojava.grupo4.model.Cachorro;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = Grupo4Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class CachorroControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void buscarCachorroPorId() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/cachorro/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("Cachorro1"))
                .andExpect(jsonPath("$.raca").value("Raca1"));
    }

    @Test
    public void salvarCachorro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/cachorro")
                        .content(converterCachorroParaJson(new Cachorro(null,"Mel","Vira lata")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void alterarCachorro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/cachorro")
                        .content(converterCachorroParaJson(new Cachorro(2L,"Mel","Vira lata")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("Mel"))
                .andExpect(jsonPath("$.raca").value("Vira lata"));
    }

    public static String converterCachorroParaJson(final Cachorro obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

