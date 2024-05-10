import { Avatar, Box, Button, Tab, Tabs } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';

const tabs = [
  {
    value: 'post',
    name: 'Post',
  },
  {
    value: 'reels',
    name: 'Reels',
  },
  {
    value: 'saved',
    name: 'Saved',
  },
  {
    value: 'repost',
    name: 'Repost',
  },
];
const Profile = () => {
  const { id } = useParams();
  const [value, setValue] = React.useState('one');

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };
  return (
    <div className="py-10 w-[70%]">
      <div className="rounded-md">
        <div className="h-[15rem">
          <img
            className="w-full h-full rounded-t-md"
            src="https://img.freepik.com/free-photo/healthy-message-with-wooden-background_1134-374.jpg?t=st=1715350950~exp=1715354550~hmac=dc2b4ca5f564ea933d077b986e60670a39e1aca1cff54652f393368b6a04512c&w=740"
            alt=""
          />
        </div>
        <div className=" px-5 flex justify-between items-start mt-5 h-[5rem]">
          <Avatar
            className="transform -translate-y-24"
            sx={{ height: '10rem', width: '10rem' }}
            src="https://avatars.githubusercontent.com/u/99156192?u=8294da846260b576515b9884a14bf7f43e6fd897&v=4"
          />
          {true ? (
            <Button sx={{ borderRadius: '20px' }} variant="outlined">
              Edit Profile
            </Button>
          ) : (
            <Button sx={{ borderRadius: '20px' }} variant="outlined">
              Follow
            </Button>
          )}
        </div>
        <div className="p-5">
          <div>
            <h1>D.P. Liyanagama</h1>
            <p>@Dilanka Prasad Liyanagama</p>
          </div>
          <div className="flex gap-5 items-center py-3">
            <span>41 post</span>
            <span>35 followers</span>
            <span>5 followings</span>
          </div>
          <div>
            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.</p>
          </div>
        </div>
        <section>
          <Box sx={{ width: '100%' }}>
            <Tabs
              value={value}
              onChange={handleChange}
              aria-label="wrapped label tabs example"
            >
              {tabs.map((item) => (
                <Tab value={item.value} label={item.name} />
              ))}
            </Tabs>
          </Box>
        </section>
      </div>
    </div>
  );
};

export default Profile;
