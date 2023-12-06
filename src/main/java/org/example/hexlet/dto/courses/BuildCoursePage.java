package org.example.hexlet.dto.courses;

import java.util.List;
import java.util.Map;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildCoursePage {
    private String name;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;
}
