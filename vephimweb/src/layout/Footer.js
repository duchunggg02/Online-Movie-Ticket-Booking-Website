import { Alert } from "react-bootstrap";

const Footer = () => {
    return (
       
        <Alert variant="primary" className="mt-8 p-8 text-center">
         &copy; {new Date().getFullYear()} Copyright:{' '}  
       Nguyễn Đức Hưng, Trường Đại học Mở Thành phố Hồ Chí Minh
      </Alert>
      );
}

export default Footer;