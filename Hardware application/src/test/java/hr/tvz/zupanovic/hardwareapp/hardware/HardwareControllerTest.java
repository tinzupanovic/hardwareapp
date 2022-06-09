package hr.tvz.zupanovic.hardwareapp.hardware;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.swing.tree.ExpandVetoException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HardwareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getAll() throws Exception {
        String accessToken = obtainAccessToken();
        this.mockMvc.perform(
                        get("/hardware")
                                .header("Authorization", "Bearer " + accessToken)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(5)));
    }

    @Test
    void getByCode() throws Exception {
        String accessToken = obtainAccessToken();
        this.mockMvc.perform(
                        get("/hardware/{id}", "1")
                                .header("Authorization", "Bearer " + accessToken)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("Asus TUF RTX 3080"))
                .andExpect(jsonPath("$.code").value("1"))
                .andExpect(jsonPath("$.price").value("1599.0"));
    }

    @Test
    void update_asUser() throws Exception {
        String accessToken = obtainAccessTokenAsUser();
        Map<String,Object> body = new HashMap<>();
        body.put("name", "test");
        body.put("code", "2");
        body.put("price", "123");
        body.put("type", "GPU");
        body.put("units", "123");
        this.mockMvc.perform(
                        put("/hardware/{id}", "2")
                                .header("Authorization", "Bearer " + accessToken)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(body))
                )
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void delete_asUser() throws Exception {
        String accessToken = obtainAccessTokenAsUser();
        this.mockMvc.perform(
                        delete("/hardware/{id}", "5")
                                .header("Authorization", "Bearer " + accessToken)
                )
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void save_asUser() throws Exception {
        String accessToken = obtainAccessTokenAsUser();
        Map<String,Object> body = new HashMap<>();
        body.put("name", "test");
        body.put("code", "123");
        body.put("price", "123");
        body.put("type", "GPU");
        body.put("units", "123");
        this.mockMvc.perform(
                        post("/hardware")
                                .header("Authorization", "Bearer " + accessToken)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(body))
                )
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void update_asAdmin() throws Exception {
        String accessToken = obtainAccessToken();
        Map<String,Object> body = new HashMap<>();
        body.put("name", "test");
        body.put("code", "2");
        body.put("price", "123");
        body.put("type", "GPU");
        body.put("units", "123");
        this.mockMvc.perform(
                        put("/hardware/{id}", "2")
                                .header("Authorization", "Bearer " + accessToken)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(body))
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void save_asAdmin() throws Exception {
        String accessToken = obtainAccessToken();
        Map<String,Object> body = new HashMap<>();
        body.put("name", "test");
        body.put("code", "123");
        body.put("price", "123");
        body.put("type", "GPU");
        body.put("units", "123");
        this.mockMvc.perform(
                        post("/hardware")
                                .header("Authorization", "Bearer " + accessToken)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(body))
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void delete_asAdmin() throws Exception {
        String accessToken = obtainAccessToken();
        this.mockMvc.perform(
                        delete("/hardware/{id}", "5")
                                .header("Authorization", "Bearer " + accessToken)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    private String obtainAccessToken() throws Exception {

        Map<String,Object> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "admin");

        ResultActions result
                = mockMvc.perform(post("/authentication/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("jwt").toString();
    }
    private String obtainAccessTokenAsUser() throws Exception {

        Map<String,Object> body = new HashMap<>();
        body.put("username", "user");
        body.put("password", "user");

        ResultActions result
                = mockMvc.perform(post("/authentication/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("jwt").toString();
    }
}