// IndianPlayers.js
import React from 'react';

const T20players = ['Virat', 'Rohit', 'Gill'];
const RanjiTrophyPlayers = ['Rahul', 'Jadeja', 'Bumrah'];

const IndianPlayers = () => {
    const merged = [...T20players, ...RanjiTrophyPlayers];
    const [oddPlayers, evenPlayers] = [
        merged.filter((_, i) => i % 2 === 0),
        merged.filter((_, i) => i % 2 !== 0),
    ];

    return (
        <div>
            <h2>Odd Team Players</h2>
            <ul>{oddPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>

            <h2>Even Team Players</h2>
            <ul>{evenPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>
        </div>
    );
};

export default IndianPlayers;
