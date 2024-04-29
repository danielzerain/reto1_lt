package lt.springspringboot.reto1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StringTransformRedisRepository extends CrudRepository<StringNameRedisHash, UUID> {}
