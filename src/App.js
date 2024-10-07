import React, { useState } from 'react';
import './App.css'; // Create this if you want to style
import { FaSearch } from 'react-icons/fa'; // You'll need to install react-icons

function App() {
  const [doctorName, setDoctorName] = useState('');
  const [zipCode, setZipCode] = useState('');

  const handleSearch = () => {
    // You can add your search logic here
    console.log(`Searching for Doctor: ${doctorName}, Zip Code: ${zipCode}`);
  };

  return (
    <div className="App">
      <h1>Doctor Search</h1>
      <div className="search-form">
        <label>Doctor Name:</label>
        <input
          type="text"
          value={doctorName}
          onChange={(e) => setDoctorName(e.target.value)}
          placeholder="Enter doctor name"
        />
        <label>Zip Code:</label>
        <input
          type="text"
          value={zipCode}
          onChange={(e) => setZipCode(e.target.value)}
          placeholder="Enter zip code"
        />
        <button onClick={handleSearch} className="search-button">
          <FaSearch /> {/* Search Icon */}
        </button>
      </div>
    </div>
  );
}

export default App;
