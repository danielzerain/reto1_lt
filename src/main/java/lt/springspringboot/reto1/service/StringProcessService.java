package lt.springspringboot.reto1.service;

import lt.springspringboot.reto1.domain.BodyPayload;
import lt.springspringboot.reto1.repository.StringNameRedisHash;
import lt.springspringboot.reto1.repository.StringTransformRedisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StringProcessService {
  private final Logger LOGGER = LoggerFactory.getLogger(StringProcessService.class);

  private final StringTransformRedisRepository stringTransformRedisRepository;

  public StringProcessService(StringTransformRedisRepository stringTransformRedisRepository) {
    this.stringTransformRedisRepository = stringTransformRedisRepository;
  }

  public BodyPayload transformText(BodyPayload payload) {
    String strTemp = String.format("Hola %s, bienvenido a Spring Boot", payload.name());
    LOGGER.debug("Saludo creado");
    return new BodyPayload(strTemp);
  }

  public BodyPayload transformTextPersist(BodyPayload payload) {
    String strTemp = String.format("Hola %s, bienvenido a Spring Boot", payload.name());
    stringTransformRedisRepository.save(new StringNameRedisHash(payload));
    LOGGER.debug("Saludo creado y nombre persistido en redis");
    return new BodyPayload(strTemp);
  }
}
