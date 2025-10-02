import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Image from 'react-bootstrap/Image';
import about from '../Images/assest/about.jpeg';
import ProgressBar from 'react-bootstrap/ProgressBar';


export default function AppAbout() {
    const design = 100;
    const Space = 100;
    const Project = 100;
  return (
    <section id="about" className="block about-block">
         <Container fluid>
            <div className='title-holder'>
                <h2>ABOUT US</h2>
            <div className='subtitle'> Leran more about us</div>
            </div>
      <Row>
        <Col sm={6}><Image src={about}/></Col>
        <Col sm={6}><p>We transform spaces into inspiring, functional, and beautiful environments tailored to your vision. With a passion for creativity and an eye for detail, our team delivers bespoke interior design solutions that blend aesthetics, comfort, and innovation. From modern minimalism to timeless elegance, we craft unique interiors that reflect your personality and lifestyle. Let’s bring your dream space to life—one design at a time</p>
        <p>At our core, we believe great design should be both stunning and livable. Our process begins by listening deeply to your needs, then blending functionality with artistic flair to create spaces that truly feel like home. With expertise in space planning, material selection, and custom furnishings, we handle every detail - from initial concept to flawless execution. </p>
        <div className='progress-block'>
            <h4>Design Accuracy</h4>
        <ProgressBar now={design} label={`${design}%`} />
        </div>
        <div className='progress-block'>
            <h4>Space planning</h4>
        <ProgressBar now={Space} label={`${Space}%`} />
        </div>
        <div className='progress-block'>
            <h4>Project Timelines</h4>
        <ProgressBar now={Project} label={`${Project}%`} />
        </div>
        </Col>
      </Row>
    </Container>
    </section>
  )
}
