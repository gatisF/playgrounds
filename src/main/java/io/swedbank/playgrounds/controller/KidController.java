package io.swedbank.playgrounds.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swedbank.playgrounds.dto.KidDto;
import io.swedbank.playgrounds.services.KidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("/kid")
public class KidController {

    private final KidService kidService;

    public KidController(final KidService kidService) {
        this.kidService = Objects.requireNonNull(kidService);
    }

    @PostMapping("/add-to-playsite")
    @Operation(description = "Add kid to playsite")
    @ResponseBody
    public ResponseEntity<Void> add(@RequestBody KidDto kidDto) {
        kidService.add(kidDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove-from-playsite/{name}/{ticketNumber}")
    @Operation(description = "Remove kid from playsite")
    @ResponseBody
    public ResponseEntity<Void> remove(@PathVariable String name, @PathVariable Long ticketNumber) {
        var isRemoved = kidService.remove(name, ticketNumber);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().build();
    }
}
