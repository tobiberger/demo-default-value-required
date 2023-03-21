package com.example.demodefaultvaluerequired.demodefaultvaluerequired

import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class OpenApiTest(@Autowired private val mockMVC: MockMvc) {
    @Test
    fun `should not change api docs`() {
        val referenceDocs = ClassPathResource("api.json").inputStream.bufferedReader().use { it.readText() }
        val currentDocs =
            mockMVC.perform(MockMvcRequestBuilders.get("/v3/api-docs/api")).andReturn().response.contentAsString

        JSONAssert.assertEquals(
            "Api docs shouldn't have changed on version update",
            referenceDocs,
            currentDocs,
            true,
        )
    }
}
