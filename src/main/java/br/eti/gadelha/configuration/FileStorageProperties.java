package br.eti.gadelha.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component @ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;
}
