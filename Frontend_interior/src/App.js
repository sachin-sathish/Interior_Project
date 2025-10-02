import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import AppHeader from './components/header';
import AppHero from './components/hero';
import AppAbout from './components/about';
import AppWorks from './components/works';
import AppContact from './components/contact';
import AppFooter from './components/footer';
import { Routes, Route } from 'react-router-dom';


function App() {
  return (
    <div className="App">
       <header id='header'>
       <AppHeader/>
       </header>
       <main>
        <Routes>
          <Route path='/' element={
            <>
             <AppHero/>
        <AppAbout/>
        <AppWorks/>
        <AppContact/>
            </>
          }/>
          <Route path='/about' element={<AppAbout/>}/>
          <Route path='/hero' element={<AppHero/>}/>
          <Route path='/works' element={<AppWorks/>}/>
          <Route path='/contact' element={<AppContact/>}/>
        </Routes>
        </main>
        <footer id='footer'>
          <AppFooter/>
        </footer>
    </div>
  );
}

export default App;
