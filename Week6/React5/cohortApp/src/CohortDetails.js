import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohort }) => {
    const { name, status, description } = cohort;

    const headingStyle = {
        color: status.toLowerCase() === 'ongoing' ? 'green' : 'blue'
    };

    return (
        <div className={styles.box}>
            <h3 style={headingStyle}>{name}</h3>
            <dl>
                <dt>Status:</dt>
                <dd>{status}</dd>
                <dt>Description:</dt>
                <dd>{description}</dd>
            </dl>
        </div>
    );
};

export default CohortDetails;
