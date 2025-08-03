// ListofPlayers.js
import React from 'react';

const players = [
    { name: 'Virat', score: 85 },
    { name: 'Rohit', score: 65 },
    { name: 'Rahul', score: 90 },
    { name: 'Jadeja', score: 55 },
    { name: 'Bumrah', score: 80 },
    { name: 'Dhoni', score: 45 },
    { name: 'Ashwin', score: 95 },
    { name: 'Gill', score: 70 },
    { name: 'Pant', score: 60 },
    { name: 'Iyer', score: 75 },
    { name: 'Shami', score: 68 }
];

const ListofPlayers = () => {
    const filtered = players.filter(p => p.score >= 70);

    return (
        <div>
            <h2>Qualified Players (Score ≥ 70)</h2>
            <ul>
                {filtered.map((player, index) => (
                    <li key={index}>{player.name} - {player.score}</li>
                ))}
            </ul>
        </div>
    );
};

export default ListofPlayers;
