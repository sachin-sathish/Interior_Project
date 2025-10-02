import Container from 'react-bootstrap/Container';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import { useState } from 'react';
import { createcontact } from '../service/contactservice';

export default function AppContact() {
const [formdata,setformdata] = useState({
  name:"",
  email:"",
  phone:"",
  requirement:""
})

const handleChange = (e)=>{
setformdata({
  ...formdata, [e.target.name]: e.target.value
})
};

const handlesubmit = async (e)=>{
  e.preventDefault();
  try{
    await createcontact(formdata)
    alert("Data added successfully")
    setformdata({ name: "", email: "", phone: "", requirement: "" })
  }
  catch(error){
    console.error(" failed" , error);
    alert("Failed to saved the contact ");
  }
};

  return (
    <section id='contact' className='block contact-block'>
    <Container fluid>
        <div className='title-holder'>
            <h2>CONTACT US</h2>
            <div className='subtitle'>get connected with us</div>
        </div>
      <Form className='contact-form' onSubmit={handlesubmit}>
      <Row>
        <Col sm={4}>
          <Form.Control type='text' name = "name" placeholder="Enter your name" value={formdata.name}
                onChange={handleChange} required/>
        </Col>
        <Col sm={4}>
          <Form.Control type='email' name = "email" placeholder="Enter your Email" value={formdata.email}
                onChange={handleChange} required/>
        </Col>
        <Col sm={4}>
          <Form.Control type='tel' name = "phone" placeholder="Enter your Phone number"  value={formdata.phone}
                onChange={handleChange}required />
        </Col>
      </Row>
      <Row>
        <Col sm={12}>
        <Form.Control as="textarea" name = "requirement" placeholder="Project Requirement" value={formdata.requirement}
                onChange={handleChange}required/></Col>
      </Row>
      <div className='btn-holder'>
      <Button type='submit' >Submit</Button></div>
    </Form>
    </Container>
    <div className='google-map'>
        <iframe  title='map' src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3915.2743991261887!2d76.94401327377946!3d11.092915253278862!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ba8f75c80daf7f1%3A0x25f767b36aba9854!2sShree%20Sanaa%20Interior-Interior%20Designer%20in%20Coimbatore!5e0!3m2!1sen!2sin!4v1750052344354!5m2!1sen!2sin"  allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
    <Container fluid>
        <div className='contact-info'>
          <ul>
            <li>
              <i className="fas fa-envelope"></i>
              Sanaa@gmail.com
            </li>
            <li>
              <i className="fas fa-phone"></i>
              9345421990
            </li>
            <li>
              <i className="fas fa-map-marker-alt"></i>
              Coimbatore, Tamil Nadu
            </li>
            
          </ul>
        </div>
      </Container>
    </section>
  )
}
