import {
  Button,
  FormControlLabel,
  Radio,
  RadioGroup,
  TextField,
} from '@mui/material';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import * as Yup from 'yup';
import { registerUserAction } from '../../Redux/Auth/auth.action';

const initialValues = {
  firstName: '',
  lastName: '',
  email: '',
  password: '',
  gender: '',
};
const validationSchema = {
  email: Yup.string().email('Invalid email').required('Email is required'),
  password: Yup.string()
    .min(6, 'Password should be at least 6 characters')
    .required("Password can't be empty"),
};
const Register = () => {
  const [gender, setGender] = useState();
  const dispatch = useDispatch();

  const handleSubmit = (values) => {
    values.gender = gender;
    console.log('handle submit', values);

    dispatch(registerUserAction({ data: values }));
  };
  const handleChange = (event) => {
    setGender(event.target.value);
  };
  return (
    <>
      <Formik
        onSubmit={handleSubmit}
        // validationSchema={validationSchema}
        initialValues={initialValues}
      >
        <Form className=" space-y-5">
          <div className="space-y-5">
            <div>
              <Field
                as={TextField}
                name="firstName"
                placeholder="First Name"
                type="text"
                variant="outlined"
                fullWidth
              />
              <ErrorMessage
                name="firstName"
                component={'div'}
                className="text-red-500"
              />
            </div>
            <div>
              <Field
                as={TextField}
                name="lastName"
                placeholder="Last Name"
                type="text"
                variant="outlined"
                fullWidth
              />
              <ErrorMessage
                name="lastName"
                component={'div'}
                className="text-red-500"
              />
            </div>
            <div>
              <Field
                as={TextField}
                name="email"
                placeholder="Email"
                type="email"
                variant="outlined"
                fullWidth
              />
              <ErrorMessage
                name="email"
                component={'div'}
                className="text-red-500"
              />
            </div>
            <div>
              <Field
                as={TextField}
                name="password"
                placeholder="password"
                type="password"
                variant="outlined"
                fullWidth
              />
              <ErrorMessage
                name="password"
                component={'div'}
                className="text-red-500"
              />
            </div>
            <div>
              <RadioGroup
                onChange={handleChange}
                row
                aria-label="gender"
                name="gender"
              >
                <FormControlLabel
                  value="female"
                  control={<Radio />}
                  label="Female"
                />
                <FormControlLabel
                  value="male"
                  control={<Radio />}
                  label="Male"
                />
                <ErrorMessage
                  name="gender"
                  component={'div'}
                  className="text-red-500"
                />
              </RadioGroup>
            </div>
          </div>
          <Button
            sx={{ padding: '.8rem orem' }}
            fullWidth
            type="submit"
            variant="contained"
            color="primary"
          >
            Register
          </Button>
        </Form>
      </Formik>
    </>
  );
};

export default Register;
