package org.sonic.user.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties("test")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class DummyBean {
    private Integer abc;
    private List<Integer> bbc;

    @Override
    public String toString() {
        return "{" +
                "\"abc\":" + abc +
                ", \"bbc\":" + bbc +
                "}";
    }
}
