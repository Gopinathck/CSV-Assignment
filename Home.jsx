
import { MDBFile } from 'mdb-react-ui-kit';
import {
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBBtn
    
  } from 'mdb-react-ui-kit';
  import axios  from 'axios';
//import Navbar from './Navbar';
import CSVNavbar from './Navbar';
import { useState } from 'react';
//import axios from 'axios';
const CSVHome = () => {

  const[file,setFile]=useState(null);
  const uploadSingleFile= (e) =>{
    setFile( URL.createObjectURL(e.target.files[0]))
   // console(file)
};

const  uploading= (e)=> {
  e.preventDefault();
  console.log(file);
}
    
    return ( <>
    <CSVNavbar/>
      <MDBContainer fluid>

<MDBRow className='d-flex justify-content-center align-items-center h-100'>
  <MDBCol col='12'>

    <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '500px'}}>
      <MDBCardBody className='p-5 w-100 d-flex flex-column'>

        <h2 className="fw-bold mb-2 text-center">UPLOAD CSV FILE</h2>
        <MDBFile label='Upload here' id='customFile' size='lg' onChange={uploadSingleFile} />
        <hr className="my-8" />
        <MDBBtn size='m' onClick={uploading}>
          SUBMIT
        </MDBBtn>
      </MDBCardBody>
      
    </MDBCard>

  </MDBCol>
</MDBRow>

</MDBContainer>
     
    </> );
}
 
export default CSVHome;