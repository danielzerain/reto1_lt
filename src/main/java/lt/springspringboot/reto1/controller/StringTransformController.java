package lt.springspringboot.reto1.controller;

import lt.springspringboot.reto1.domain.BodyPayload;
import lt.springspringboot.reto1.service.StringProcessService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reto1")
public class StringTransformController {

  private final StringProcessService stringProcessService;

  public StringTransformController(StringProcessService stringProcessService) {
    this.stringProcessService = stringProcessService;
  }

  @PostMapping("/process")
  public @ResponseBody BodyPayload transformStringPost(@RequestBody BodyPayload payload) {
    return stringProcessService.transformText(payload);
  }

  @PostMapping("/process-persist")
  public @ResponseBody BodyPayload transformStringPersistPost(@RequestBody BodyPayload payload) {
    return stringProcessService.transformTextPersist(payload);
  }

  @GetMapping("/process")
  public @ResponseBody BodyPayload transformStringGet(@RequestParam String name) {
    return stringProcessService.transformText(new BodyPayload(name));
  }
}
