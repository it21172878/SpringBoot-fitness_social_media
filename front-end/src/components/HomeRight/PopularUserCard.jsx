import { Avatar, Button, CardHeader, IconButton } from '@mui/material';
import React from 'react';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import { blue } from '@mui/material/colors';

const PopularUserCard = () => {
  return (
    <div>
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: blue[500] }} aria-label="recipe">
            DP
          </Avatar>
        }
        action={<Button size="small">Follow</Button>}
        title="Dilanka prasad liyanagama"
        subheader="@DPL"
      />
    </div>
  );
};

export default PopularUserCard;
