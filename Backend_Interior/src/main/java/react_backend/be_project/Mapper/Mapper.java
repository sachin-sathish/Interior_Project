package react_backend.be_project.Mapper;


import react_backend.be_project.Dto.ContactDto;
import react_backend.be_project.Entity.Contact;

public class Mapper {
    public static ContactDto mapTocontactdto(Contact con){
        return new ContactDto(
                con.getId(),
                con.getName(),
                con.getEmail(),
                con.getPhone(),
                con.getRequirement()
        );
    }
    public static Contact maptocontact(ContactDto dto) {
        return new Contact(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getRequirement()
        );
    }
}
