import { Route, Routes } from 'react-router-dom';
import CSVHome from './Home';
import CSVData from './Data';
const AppRoutes = () => {

    return (  
        <>
        <Routes>
        <Route path="/" element={<CSVHome/>}/>
        <Route path="/data" element={<CSVData/>}/>
        </Routes>
        </>
    );
}
 
export default AppRoutes;