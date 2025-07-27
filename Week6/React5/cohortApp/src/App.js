import React from 'react';
import CohortDetails from './CohortDetails';

const App = () => {
  const cohorts = [
    { name: 'React Bootcamp', status: 'ongoing', description: 'Learn React basics' },
    { name: 'Advanced NodeJS', status: 'completed', description: 'Deep dive into Node.js and Express' },
    { name: 'Frontend Masters', status: 'ongoing', description: 'Advanced frontend concepts' }
  ];

  return (
    <div style={{ padding: '20px' }}>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
};

export default App;
