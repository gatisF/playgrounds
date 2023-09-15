package io.swedbank.playgrounds.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swedbank.playgrounds.dto.PlaySiteDto;
import io.swedbank.playgrounds.dto.out.PlaySiteDtoOut;
import io.swedbank.playgrounds.services.PlaySiteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/play-sites")
public class PlaySiteController {

    private final PlaySiteService playSiteService;

    public PlaySiteController(PlaySiteService playSiteService) {
        this.playSiteService = Objects.requireNonNull(playSiteService);
    }

    @GetMapping("/all")
    @Operation(description = "Get all available play sites")
    @ResponseBody
    public ResponseEntity<List<PlaySiteDtoOut>> all() {
        return ResponseEntity.ok(playSiteService.findAll());
    }

    @PostMapping("/create")
    @Operation(description = "Create a new play site")
    @ResponseBody
    public ResponseEntity<Void> create(@RequestBody @Valid PlaySiteDto playSite) {

        if (Objects.isNull(playSite)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        playSiteService.create(playSite);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/total-visitors")
    @Operation(description = "Get all play site visitor count")
    @ResponseBody
    public ResponseEntity<Integer> count() {
        return ResponseEntity.ok(playSiteService.count());
    }
}
