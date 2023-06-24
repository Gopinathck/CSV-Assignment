import CSVNavbar from './Navbar';
import { MDBTable, MDBTableHead, MDBTableBody,MDBIcon,MDBBtn} from 'mdb-react-ui-kit';
import axios  from 'axios';
import { useEffect, useState } from 'react';
const CSVData = () => {
    const [data,setData]=useState([]);
   // const [boolean,setBoolean]=useState([]);
    let e=1;

    useEffect(()=>{
        axios.get("http://localhost:8080/tutorials").then(response=>{
            setData(response.data);
            //setBoolean(response.published);
            //console.log(response.boolean.published);
        })
    },[0])
    return ( <>
    <CSVNavbar/>
    <MDBTable>
      <MDBTableHead dark>
        <tr>
            	{/* wid	episodes	season	seriesid	seriesname	rating	 */}
          <th scope='col'>Id</th>
          <th scope='col'>Description</th>
          <th scope='col'>Title</th>
          <th scope='col'>Published</th>
        </tr>
      </MDBTableHead>
      <MDBTableBody>
        {
            data.map(m=>{
                return <tr key={m["id"]}>
                <th scope='row'>{e++}</th>
                <td>{m["description"]}</td>
                <td>{m["title"]}</td>
                <td>{m["published"].toString()}</td>
                
              </tr>
            })
        }
      </MDBTableBody>
    </MDBTable>
    </> );
}
 
export default CSVData;