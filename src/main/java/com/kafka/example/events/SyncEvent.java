package com.kafka.example.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SyncEvent implements Serializable {
    @Serial
    private static final long serialVersionUID = 6606488823469351391L;

    private UUID id;
    private OffsetDateTime timestamp;

   public static SyncEvent createDefault() {
       return new SyncEvent(UUID.randomUUID(), OffsetDateTime.now(ZoneId.systemDefault()));
   }
}
