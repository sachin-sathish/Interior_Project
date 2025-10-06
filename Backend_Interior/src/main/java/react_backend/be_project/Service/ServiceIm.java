
//package react_backend.be_project.Service;
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import react_backend.be_project.Dto.ContactDto;
//import react_backend.be_project.Entity.Contact;
//import react_backend.be_project.Mapper.Mapper;
//import react_backend.be_project.Repository.Contactrepo;
//
//@Service
//@AllArgsConstructor
//public class ServiceIm implements ServiceIn {
//
//private Contactrepo repository;
//
//    @Override
//    public ContactDto createcontact(ContactDto dto) {
//       Contact con = Mapper.maptocontact(dto);
//      Contact savedcon =  repository.save(con);
//        return  Mapper.mapTocontactdto(savedcon);
//    }
//}

package react_backend.be_project.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import react_backend.be_project.Dto.ContactDto;
import react_backend.be_project.Entity.Contact;
import react_backend.be_project.Mapper.Mapper;
import react_backend.be_project.Repository.Contactrepo;

@Service
@AllArgsConstructor
public class ServiceIm implements ServiceIn {

    private Contactrepo repository;
    private EmailService emailService; // ✅ ADD THIS

    @Override
    public ContactDto createcontact(ContactDto dto) {
        // Save to database
        Contact con = Mapper.maptocontact(dto);
        Contact savedcon = repository.save(con);
        ContactDto savedDto = Mapper.mapTocontactdto(savedcon);

        // ✅ SEND EMAIL NOTIFICATION
        emailService.sendContactNotification(savedDto);

        return savedDto;
    }
}