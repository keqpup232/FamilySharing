import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import AuthForm from './components/AuthForm';
import Profile from './components/Profile';
import UsersList from './components/UsersList';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<AuthForm />} />
                <Route path="/profile/:id" element={<Profile />} />
                <Route path="/users" element={<UsersList />} />
            </Routes>
        </Router>
    );
}

export default App;