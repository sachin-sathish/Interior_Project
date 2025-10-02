import axios from "axios";

const contact_api = "http://localhost:8080/api/contact";

export const createcontact = (contactdata) =>
  axios.post(contact_api, contactdata);

// import axios from "axios";

// // Replace localhost with your EC2 public IP
// const contact_api = "http://52.66.203.174:8080/api/contact";

// export const createcontact = (contactdata) =>
//   axios.post(contact_api, contactdata);
