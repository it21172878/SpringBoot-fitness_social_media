import { Avatar, Card, IconButton } from '@mui/material';
import React from 'react';
import AddIcon from '@mui/icons-material/Add';
import StoryCircle from './StoryCircle';
import ImageIcon from '@mui/icons-material/Image';
import VideocamIcon from '@mui/icons-material/Videocam';
import ArticleIcon from '@mui/icons-material/Article';
import PostCard from '../Post/PostCard';

const story = [1, 1, 1, 1];
const posts = [1, 1, 1, 1];

const MiddlePart = () => {
  const handleOpenCreatePostModel = () => {
    console.log('handle Open Create Post Model');
  };
  return (
    <div className="px-20">
      <section className="flex items-center p-5 rounded-b-md">
        <div className="flex flex-col items-center mr-4 cursor-pointer">
          <Avatar
            sx={{ width: '5rem', height: '5rem' }}
            // src="https://wallpaperaccess.com/full/2562964.jpg"
          >
            <AddIcon sx={{ fontSize: '3rem' }} />
          </Avatar>
          <p>New</p>
        </div>
        {story.map((item) => (
          <StoryCircle />
        ))}
      </section>

      <Card className="p-5 mt-5">
        <div className="flex justify-between">
          <Avatar />
          <input
            readOnly
            className="outline-none w-[90%] rounded-full px-5 bg-transparent border-[#3b4054] border"
            type="text"
          />
        </div>
        <div className="flex justify-center space-x-9 mt-5">
          <div className="flex items-center">
            <IconButton color="primary" onClick={handleOpenCreatePostModel}>
              <ImageIcon />
            </IconButton>
            <span>Image</span>
          </div>
          <div className="flex items-center">
            <IconButton color="primary" onClick={handleOpenCreatePostModel}>
              <VideocamIcon />
            </IconButton>
            <span>Video</span>
          </div>
          <div className="flex items-center">
            <IconButton color="primary" onClick={handleOpenCreatePostModel}>
              <ArticleIcon />
            </IconButton>
            <span>Write Article</span>
          </div>
        </div>
      </Card>
      <div className="mt-5 space-y-5">
        {posts.map((item) => (
          <PostCard />
        ))}
      </div>
    </div>
  );
};

export default MiddlePart;
