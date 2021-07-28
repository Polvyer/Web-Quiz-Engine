package engine.api.converter;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter
        implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        log.info("LocalDateTime: " + localDateTime.toString());
        return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        log.info("Timestamp: " + timestamp);
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }
}
