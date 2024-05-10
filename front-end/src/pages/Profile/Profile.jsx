import React from 'react';
import { useParams } from 'react-router-dom';

const Profile = () => {
  const { id } = useParams();
  return (
    <div className="py-10 w-[70%]">
      <div className="rounded-md">
        <div className="h-[15rem]">
          <img
            src="https://images.pexels.com/photos/7243182/pexels-photo-7243182.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            alt=""
          />
        </div>
      </div>
    </div>
  );
};

export default Profile;
