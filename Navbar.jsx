
//import CSVNavbar from './Navbar';
import { NavLink } from 'react-router-dom';

const CSVNavbar = () => {
    return ( 
        <>
           <nav className="navbar navbar-expand-sm bg-secondary" >
      <div className="container-fluid">
  <ul className="navbar-nav ">
  <li className="nav-item">
      <NavLink className="nav-link" to="/">CODING ASSIGNMENT</NavLink>
    </li>
    <li className="nav-item">
      <NavLink className="nav-link" to="/">HOME</NavLink>
    </li>
    <li className="nav-item">
      <NavLink className="nav-link" to="/data">DATA</NavLink>
    </li>
    <li className="nav-item">
      <NavLink className="nav-link" to="/"></NavLink>
    </li>
    <li className="nav-item">
      <NavLink className="nav-link" to="/">GOPINATH</NavLink>
    </li>
 
  </ul>
</div>

</nav>
        </>
     );
}
 
export default CSVNavbar;