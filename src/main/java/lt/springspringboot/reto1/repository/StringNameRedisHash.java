package lt.springspringboot.reto1.repository;

import lt.springspringboot.reto1.domain.BodyPayload;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash
public class StringNameRedisHash {

    @Id
    private UUID id;
    private final BodyPayload bodyPayload;

    public StringNameRedisHash(BodyPayload bodyPayload) {
        this.bodyPayload = bodyPayload;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BodyPayload getBodyPayload() {
        return bodyPayload;
    }
}
