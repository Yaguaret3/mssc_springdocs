package guru.microservices.mssc_beer_service.web.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {

    public OffsetDateTime asOffsetDateTime(Timestamp ts){
        return ts == null ? null : OffsetDateTime.of(ts.toLocalDateTime().getYear(), ts.toLocalDateTime().getMonthValue(), ts.toLocalDateTime().getDayOfMonth(),
                ts.toLocalDateTime().getHour(), ts.toLocalDateTime().getMinute(), ts.toLocalDateTime().getSecond(),
                ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
    }
    public Timestamp asTimestamp(OffsetDateTime offsetDateTime){
        return offsetDateTime == null ? null : Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
    }

}
