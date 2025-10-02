package react_backend.be_project.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import react_backend.be_project.Dto.ContactDto;
import react_backend.be_project.Service.ServiceIm;

@RestController
@AllArgsConstructor
@RequestMapping("api/contact")
@CrossOrigin(origins = "*")
public class Controller {
    private ServiceIm service;

    @PostMapping
    public ResponseEntity<ContactDto> Pmapping(@RequestBody ContactDto dto){
        ContactDto savedservice = service.createcontact(dto);
        return ResponseEntity.ok(savedservice);
    }
}
