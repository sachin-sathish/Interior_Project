import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Image from 'react-bootstrap/Image';
import Pagination from 'react-bootstrap/Pagination';

const worksData = [
  {
    id: 1,
    link: 'https://www.google.com',
    image: require('../Images/assest/kkichen.jpg'),
    title: 'Modular Kitchen',
    subtitle: 'Space-Saving Solutions'
  },
  {
    id: 2,
    link: 'https://www.google.com',
    image: require('../Images/assest/oofice.jpg'),
    title: 'Office',
    subtitle: 'Ergonomic Designs'
  },
  {
    id: 3,
    link: 'https://www.google.com',
    image: require('../Images/assest/ppoja.jpg'),
    title: 'Pooja Room',
    subtitle: 'Sacred Space Design'
  },
  {
    id: 4,
    link: 'https://www.google.com',
    image: require('../Images/assest/tv unit.jpeg'),
    title: 'Tv Unit',
    subtitle: 'Entertainment Walls'
  },
  {
    id: 5,
    link: 'https://www.google.com',
    image: require('../Images/assest/bedroom.jpg'),
    title: 'Bedroom',
    subtitle: 'Luxury Retreats'
  },
  {
    id: 6,
    link: 'https://www.google.com',
    image: require('../Images/assest/w.jpg'),
    title: 'Wardrobe',
    subtitle: 'Custom Storage Systems'
  },

]

let active = 2;
let items = [];
for (let number = 1; number <= 5; number++) {
  items.push(
    <Pagination.Item key={number} active={number === active}>
      {number}
    </Pagination.Item>,
  );
}

function AppWorks() {
  return (
    <section id="works" className="block works-block">
      <Container fluid>
        <div className="title-holder">
          <h2>Our works</h2>
          <div className="subtitle">our awesome works</div>
        </div>
        <Row className='portfoliolist'>
          {
            worksData.map(works => {
              return (
                <Col sm={4} key={works.id}>
                  <div className='portfolio-wrapper'>
                    <a href={works.link}>
                      <Image src={works.image} />
                      <div className='label text-center'>
                        <h3>{works.title}</h3>
                        <p>{works.subtitle}</p>
                      </div>
                    </a>
                  </div>
                </Col>
              );
            })
          }
        </Row>
        <Pagination>{items}</Pagination>
      </Container>  
    </section>
  );
}

export default AppWorks;