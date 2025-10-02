import Container from 'react-bootstrap/Container';
import { useEffect,useState } from 'react';

export default function AppFooter() {
    const[ShowTopBtn,SetShowTopBtn] = useState(false);

    useEffect(() => {
        window.addEventListener("scroll", () => {
            if (window.scrollY > 400) {
                SetShowTopBtn(true);
            } else {
                SetShowTopBtn(false);
            }
        });
    }, []);

    function goTop() {
        window.scrollTo({
          top: 0,
          behavior: "smooth",
        });
      }    
  
  return (
    <Container fluid>
     <div className="copyright">&copy;2025 Sanaa Interiors. Built by Sachin S | All Rights Reserved.</div>
      <div className="socials">
        <ul>
          <li><a href="https://www.facebook.com"><i className="fab fa-facebook-f"></i></a></li>
          <li><a href="https://www.twitter.com"><i className="fab fa-twitter"></i></a></li>
          <li><a href="https://www.linkedin.com"><i className="fab fa-linkedin-in"></i></a></li>
        </ul>
      </div>
      {
        ShowTopBtn && (
          <div className="go-top" onClick={goTop}></div>
        )
      }
    </Container>
  )
}
