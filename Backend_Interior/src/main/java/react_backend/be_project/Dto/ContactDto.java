package react_backend.be_project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    private long id;
    private String name ;
    private String email;
    private String phone;
    private String requirement;
}
