package mk.ukim.finki.proekti.controller;


import mk.ukim.finki.proekti.models.DTO.CallDto;
import mk.ukim.finki.proekti.models.Call;
import mk.ukim.finki.proekti.service.CallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/calls")
public class CallController {
    private final CallService callService;

    public CallController(CallService callService) {
        this.callService = callService;
    }

    @GetMapping("/all")
    public List<Call> findAllCalls() {
        return this.callService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Call> findCallById(@PathVariable Long id) {
        return this.callService.findById(id)
                .map(call -> ResponseEntity.ok().body(call))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Call> deleteCall(@PathVariable Long id) {
        this.callService.delete(id);
        if (this.callService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Call> addCall(@RequestBody CallDto callDto) {
        return this.callService.addCall(callDto)
                .map(call -> ResponseEntity.ok().body(call))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Call> editCall(@PathVariable Long id, @RequestBody CallDto callDto) {
        return this.callService.editCall(id, callDto)
                .map(call -> ResponseEntity.ok().body(call))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
