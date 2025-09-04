import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ParseMultiLineJson {
    public static void main(String[] args) {
        // Multi-line JSON using text blocks
        String json = """
                {
                    "name": "Shreya",
                    "age": 22,
                    "skills": ["Java", "Python", "SQL"],
                    "address": {
                        "city": "Patna",
                        "state": "Bihar"
                    }
                }
                """;

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode root = mapper.readTree(json);

            // Access fields
            String name = root.get("name").asText();
            int age = root.get("age").asInt();
            JsonNode skills = root.get("skills");
            String city = root.get("address").get("city").asText();

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.print("Skills: ");
            for (JsonNode skill : skills) {
                System.out.print(skill.asText() + " ");
            }
            System.out.println("\nCity: " + city);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
