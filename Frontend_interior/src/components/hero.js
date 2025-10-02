import Carousel from 'react-bootstrap/Carousel';

var heroData = [
    {
      id: 1,
      image: require('../Images/assest/c1.jpeg'),
      title: 'Modern Interiors for Every Lifestyle',
      description: 'Blending beauty and practicality to elevate your space. Designed for the way you live today',
    },
    {
      id: 2,
      image: require('../Images/assest/c2.jpeg'),
      title: 'Elegant Living Spaces',
      description: 'Transform your home into a stylish, functional haven.Every detail designed with comfort in mind',
    },
    {
      id: 3,
      image: require('../Images/assest/c3.jpeg'),
      title: 'Crafted with Timeless Elegance',
      description: 'Experience interiors that balance luxury with simplicity.Perfectly styled for modern living and lasting impressions',
    }
  ]

export default function AppHero() {
  return (
    <section id='home' className='hero-block'>
     <Carousel>
        {
            heroData.map(hero=>{
                return(
        <Carousel.Item key={hero.id}>
        <img
          className="d-block w-100"
          src={hero.image}
          alt={"slide" + hero.id}
        />
        <Carousel.Caption>
          <h5>{hero.title}</h5>
          <p>{hero.description}</p>
        </Carousel.Caption>
      </Carousel.Item>
                )
            })
        }
    </Carousel>
  </section>
  )
}

