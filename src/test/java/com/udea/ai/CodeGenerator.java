package com.udea.ai;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    private static final String API_KEY = "";
    private static final String OPENAI_URL = "https://api.openai.com/v1/engines/davinci-codex/completions";

    public static String generateStepImpl(String stepDescription) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(OPENAI_URL);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", "Bearer " + API_KEY);

        JsonObject json = new JsonObject();
        json.addProperty("prompt", "Convert the following Gherkin step into Java code using Selenium:\nStep: " + stepDescription);
        json.addProperty("max_tokens", 150);

        request.setEntity(new StringEntity(json.toString()));

        CloseableHttpResponse response = httpClient.execute(request);
        String responseBody = EntityUtils.toString(response.getEntity());
        response.close();

        JsonObject responseObject = JsonParser.parseString(responseBody).getAsJsonObject();
        return responseObject.get("choices").getAsJsonArray().get(0).getAsJsonObject().get("text").getAsString().trim();
    }

    public static List<String> readFeatureFile(String filePath) throws IOException {
        List<String> steps = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("Given") || line.startsWith("When") || line.startsWith("Then")) {
                    steps.add(line);
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) throws IOException {
        String featureFilePath = "src/resources/feature/file.feature";
        List<String> steps = readFeatureFile(featureFilePath);

        List<String> stepImplementations = new ArrayList<>();
        for (String step : steps) {
            String stepImplementation = generateStepImpl(step);
            stepImplementations.add(stepImplementation);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/java/stepdefinitions/StepDefinitions.java"))) {
            writer.write("package steps;\n\n");
            writer.write("import org.openqa.selenium.*;\n");
            writer.write("import org.openqa.selenium.chrome.ChromeDriver;\n");
            writer.write("import io.cucumber.java.en.*;\n\n");
            writer.write("public class StepDefinitions {\n");
            for (String impl : stepImplementations) {
                writer.write(impl + "\n\n");
            }
            writer.write("}\n");
        }

        System.out.println("Step implementations generated successfully.");
    }
}