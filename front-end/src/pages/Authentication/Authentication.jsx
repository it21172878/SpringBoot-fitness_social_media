import { Card, Grid } from '@mui/material';
import React from 'react';
import Login from './Login';
import Register from './Register';
import { Route, Routes } from 'react-router-dom';

const Authentication = () => {
  return (
    <div>
      <Grid container>
        <Grid className=" h-screen overflow-hidden" item xs={7}>
          <img
            className="h-full w-full"
            src="https://wallpaperaccess.com/full/804843.jpg"
            alt=""
          />
        </Grid>
        <Grid item xs={5}>
          <div className="px-20 flex flex-col justify-center h-full">
            <Card className="card p-8">
              <div className="flex flex-col items-center mb-5 space-y-1">
                <h1 className="log text-center">Fitness Healthcare</h1>
                <p className=" text-center text-sm w-[70&]">
                  Connecting Lives, Sharing Stories: Your Social World, Your Way
                </p>
              </div>

              <Routes>
                <Route path="/" element={<Login />}></Route>
                <Route path="/login" element={<Login />}></Route>
                <Route path="/register" element={<Register />}></Route>
              </Routes>
            </Card>
          </div>
        </Grid>
      </Grid>
    </div>
  );
};

export default Authentication;
